package org.ecommerce.auth;


import org.ecommerce.model.Permission;
import org.ecommerce.model.User;
import org.ecommerce.model.UserProfile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private User user;

    public AuthenticatedUser(User user) {
        super(user.getEmail(), user.getPassword(), getAuthorities(user));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Set<String> roleAndPermissions = new HashSet<>();
        Set<UserProfile> profiles = user.getProfiles();

        for (UserProfile profile : profiles) {
            roleAndPermissions.add(profile.getType());
            List<Permission> permissions = profile.getPermissions();
            for (Permission permission : permissions) {
                roleAndPermissions.add("ROLE_" + permission.getName());
            }
        }
        String[] roleNames = new String[roleAndPermissions.size()];
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
        return authorities;
    }

}

