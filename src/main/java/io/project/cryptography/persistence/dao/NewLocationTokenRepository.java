package io.project.cryptography.persistence.dao;

import io.project.cryptography.persistence.model.NewLocationToken;
import io.project.cryptography.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(UserLocation userLocation);

}
