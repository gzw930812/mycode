package com.cptech.common.utils;

import java.security.Principal;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.cptech.system.domain.UserDO;

public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    public static UserDO getUser() {
        Object object = getSubjct().getPrincipal();
        return (UserDO)object;
    }
    public static String getUserId() {
        return getUser().getId();
    }
    public static void logout() {
        getSubjct().logout();
    }

    /**
     * 待完成
     * @Description (TODO)
     * @return
     */
    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
      //  Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
}
