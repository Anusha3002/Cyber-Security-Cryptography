package io.project.cryptography.persistence.dao;

import java.util.List;

import io.project.cryptography.persistence.model.CaeserCipher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CaeserCipherRepository extends JpaRepository<CaeserCipher, Long> { 
		List<CaeserCipher> findByUserId(Long userId);
}
