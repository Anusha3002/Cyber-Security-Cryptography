package io.project.cryptography.persistence.dao;

import io.project.cryptography.persistence.model.User;
import io.project.cryptography.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
