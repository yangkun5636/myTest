package shiro.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * @author yangkun
 */
public class MySessionListener implements SessionListener {
    @Override
    public void onStart(Session session) {
        System.out.println("会话创建:" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        System.out.println("会话停止:" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("会话过期:" + session.getId());
    }
}
