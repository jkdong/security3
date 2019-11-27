package com.cun.security3.service;

import com.cun.security3.bean.SelfUserDetails;
import com.cun.security3.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 根据 username 获取数据库 user 信息
 */

@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //构建用户信息
        SelfUserDetails selfUserDetails = new SelfUserDetails();
        Map sysUserMap = sysUserMapper.findUserByName(username);
        String userName=(String) sysUserMap.get("userName");
        String password=(String) sysUserMap.get("password");
        String role=(String) sysUserMap.get("role");
        System.out.println("构建用户信息>>>>>> userName"+userName+",password>>"+password+",role>>"+role);
        // 用户名
        selfUserDetails.setUsername(userName);
        //密码
        selfUserDetails.setPassword(new BCryptPasswordEncoder().encode(password));
        // 角色
        Set authoritiesSet = new HashSet();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        authoritiesSet.add(authority);
        selfUserDetails.setAuthorities(authoritiesSet);

        return selfUserDetails;
    }
}
