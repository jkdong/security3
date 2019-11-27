package com.cun.security3.service;

import com.cun.security3.bean.SelfUserDetails;
import com.cun.security3.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * RBAC  基于角色的权限访问控制
 */

@Component("rbacauthorityservice")
public class RbacAuthorityService {

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object userInfo = authentication.getPrincipal();

        boolean hasPermission  = false;

        if (userInfo instanceof UserDetails) {

            String username = ((UserDetails) userInfo).getUsername();
            //获取资源
            Set<String> urls = new HashSet();
            urls.add("/common/**"); // 这些 url 都是要登录后才能访问，且其他的 url 都不能访问！
//            Set<String> goUrls = new HashSet();
//            goUrls.add();

            AntPathMatcher antPathMatcher = new AntPathMatcher();

            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
            return hasPermission;
        } else {
            return false;
        }
    }
}
