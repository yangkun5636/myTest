package shiro.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.Serializable;

/**
 * @author yangkun
 */
public class MySessionDao extends CachingSessionDAO {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
    }

    @Override
    protected void doDelete(Session session) {
        redisTemplate.delete(session.getId().toString());
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        redisTemplate.opsForValue().set(sessionId.toString(), session.toString());
        return session.getId();
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        return null;
    }
}
