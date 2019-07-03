package com.ben.simpleshiro.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author yangkun
 */
public class RetryCredentialMatcher extends HashedCredentialsMatcher {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String RETRY_PRE_KEY = "retry:";
    private static final int MAX = 5, MIN = 1;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo authenticationInfo) {
        String username = (String) token.getPrincipal();
        String retry = redisTemplate.opsForValue().get(RETRY_PRE_KEY + username);
        if (retry == null) {
            redisTemplate.opsForValue().set(RETRY_PRE_KEY + username, retry = MIN + "");
        }
        if (new Integer(retry) > MAX) {
            throw new ExcessiveAttemptsException();
        }
        boolean match = equals(authenticationInfo.getCredentials(), token.getCredentials());

        if (match) {
            redisTemplate.delete(RETRY_PRE_KEY + username);
        }
        return match;
    }

    public StringRedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
