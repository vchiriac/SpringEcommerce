package org.ecommerce.services;

import org.ecommerce.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<UserProfile, Integer> {

    UserProfile findByType(String type);

}
