package com.tripify.demo.users;

import com.tripify.demo.roles.types.RoleTypesComponent;
import com.tripify.demo.users.admins.models.Admin;
import com.tripify.demo.users.clients.model.User;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public static UserPrincipal create(Admin admin) {
        List<GrantedAuthority> auths = new ArrayList<>();
        RoleTypesComponent.getAdminPrivileges().forEach(privilege -> auths.add(new SimpleGrantedAuthority(privilege)));
        return new UserPrincipal(
                admin.getId(),
                admin.getPhone(),
                admin.getPassword(),
                auths
        );
    }
    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().getPrivileges().forEach(privilege -> authorities.add(new SimpleGrantedAuthority(privilege.getName())));
        return new UserPrincipal(
                user.getId(),
                user.getPhone(),
                user.getPassword(),
                authorities
        );
    }
}
