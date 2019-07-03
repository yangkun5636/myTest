package com.ben.simpleshiro.config.shiro;

import com.ben.simpleshiro.logic.bo.User;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author yangkun
 */
//@Service
public class RedisSessionDao extends AbstractSessionDAO {
    // Session超时时间，单位为毫秒
    private long expireTime = 600000;
    private static final String KEY = "userSessionId:";

    @Autowired
    private RedisTemplate redisTemplate;// Redis操作类，对这个使用不熟悉的，可以参考前面的博客

    public RedisSessionDao() {
        super();
    }

    public RedisSessionDao(long expireTime, RedisTemplate redisTemplate) {
        super();
        this.expireTime = expireTime;
        this.redisTemplate = redisTemplate;
    }

    @Override // 更新session
    public void update(Session session) throws UnknownSessionException {
        System.out.println("===============update================");
        if (session.getId() == null) {
            return;
        }
        session.setTimeout(expireTime);
        User user = (User) session.getAttribute("user");
        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
        if (user != null) {
            redisTemplate.opsForValue().set(KEY + user.getId(), session.getId(), expireTime, TimeUnit.MILLISECONDS);
        }
    }

    @Override // 删除session
    public void delete(Session session) {
        System.out.println("===============delete================");
        if (null == session) {
            return;
        }
        User user = (User) session.getAttribute("user");
        redisTemplate.opsForValue().getOperations().delete(session.getId());
        redisTemplate.opsForValue().getOperations().delete(KEY + user.getId());
    }

    /**
     * 获取活跃的session，可以用来统计在线人数，如果要实现这个功能，可以在将session加入redis时指定一个session前缀，统计的时候则使用keys("session-prefix*")的方式来模糊查找redis中所有的session集合
     */
    @Override
    public Collection<Session> getActiveSessions() {
        System.out.println("==============getActiveSessions=================");
        return redisTemplate.keys("*");
    }

    @Override// 加入session
    protected Serializable doCreate(Session session) {
        System.out.println("===============doCreate================");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        User user = (User) session.getAttribute("user");
        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
        if (user != null) {
            redisTemplate.opsForValue().getOperations().delete((String)redisTemplate.opsForValue().get(KEY + user.getId()));
            redisTemplate.opsForValue().set(KEY + user.getId(), sessionId);
        }
        return sessionId;
    }

    @Override// 读取session
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("readSession");
        if (sessionId == null) {
            return null;
        }
        Session session = (Session) redisTemplate.opsForValue().get(sessionId);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                String id = (String) redisTemplate.opsForValue().get(KEY + user.getId());
                if (!sessionId.equals(id)) {
                    return null;
                }
            }
        }
        return session;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;

    }
}
