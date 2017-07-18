package org.ecommerce.services;

import org.ecommerce.exception.WebException;
import org.ecommerce.model.Permission;
import org.ecommerce.model.User;
import org.ecommerce.model.UserProfile;
import org.ecommerce.repository.PermissionRepository;
import org.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class SecurityService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    RoleRepository roleRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String resetPassword(String email) {
        User user = findUserByEmail(email);
        if (user == null) {
            throw new WebException("Invalid email address");
        }
        String uuid = UUID.randomUUID().toString();
        user.setPasswordResetToken(uuid);
        return uuid;
    }

    public void updatePassword(String email, String token, String password) {
        User user = findUserByEmail(email);
        if (user == null) {
            throw new WebException("Invalid email address");
        }
        if (!StringUtils.hasText(token) || !token.equals(user.getPasswordResetToken())) {
            throw new WebException("Invalid password reset token");
        }
        user.setPassword(password);
        user.setPasswordResetToken(null);
    }

    public boolean verifyPasswordResetToken(String email, String token) {
        User user = findUserByEmail(email);
        if (user == null) {
            throw new WebException("Invalid email address");
        }
        if (!StringUtils.hasText(token) || !token.equals(user.getPasswordResetToken())) {
            return false;
        }
        return true;
    }

/*    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }*/

/*    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }*/

    public UserProfile getRoleByType(String roleName) {
        return roleRepository.findByType(roleName);
    }

    public UserProfile createRole(UserProfile userProfile) {
        UserProfile roleByName = getRoleByType(userProfile.getType());
        if (roleByName != null) {
            throw new WebException("Role " + userProfile.getType() + " already exist");
        }
        List<Permission> persistedPermissions = new ArrayList<>();
        List<Permission> permissions = userProfile.getPermissions();
        if (permissions != null) {
            for (Permission permission : permissions) {
                if (permission.getId() != null) {
                    //persistedPermissions.add(permissionRepository.findOne(permission.getId()));
                }
            }
        }

        userProfile.setPermissions(persistedPermissions);
        return roleRepository.save(userProfile);
    }

/*    public Role updateRole(Role userProfile) {
        Role persistedRole = getRoleById(userProfile.getId());
        if (persistedRole == null) {
            throw new WebException("Role " + userProfile.getId() + " doesn't exist");
        }
        persistedRole.setDescription(userProfile.getDescription());
        List<Permission> updatedPermissions = new ArrayList<>();
        List<Permission> permissions = userProfile.getPermissions();
        if (permissions != null) {
            for (Permission permission : permissions) {
                if (permission.getId() != null) {
                    updatedPermissions.add(permissionRepository.findOne(permission.getId()));
                }
            }
        }
        persistedRole.setPermissions(updatedPermissions);
        return roleRepository.save(persistedRole);
    }*/

/*    public Role getRoleById(Integer id) {
        return roleRepository.findOne(id);
    }*/

    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        User userByEmail = findUserByEmail(user.getEmail());
        if (userByEmail != null) {
            throw new WebException("Email " + user.getEmail() + " already in use");
        }
        Set<UserProfile> persistedProfiles = new HashSet<>();
        Set<UserProfile> userProfiles = user.getUserProfiles();
        if (userProfiles != null) {
            for (UserProfile userProfile : userProfiles) {
                if (userProfile.getId() != null) {
                    persistedProfiles.add(roleRepository.findOne(userProfile.getId()));
                }
            }
        }
        user.setUserProfiles(persistedProfiles);

        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User persistedUser = getUserById(user.getId());
        if (persistedUser == null) {
            throw new WebException("User " + user.getId() + " doesn't exist");
        }

        Set<UserProfile> updatedProfiles = new HashSet<>();
        Set<UserProfile> userProfiles = user.getUserProfiles();
        if (userProfiles != null) {
            for (UserProfile profile : userProfiles) {
                if (profile.getId() != null) {
                    updatedProfiles.add(roleRepository.findOne(profile.getId()));
                }
            }
        }
        persistedUser.setUserProfiles(updatedProfiles);
        return userRepository.save(persistedUser);
    }

}
