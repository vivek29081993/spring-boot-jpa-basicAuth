package com.example.demo.entity;

import com.example.demo.entity.secure.CustomUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * @author Vivek
 * @since 05/07/17
 */
public class CustomUserFactory {
    public static CustomUser create(User user) {
        Collection<? extends GrantedAuthority> authorities;
        try {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities());
        } catch (Exception e) {
            authorities = null;
        }
        return new CustomUser(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                authorities
        );
    }
}
