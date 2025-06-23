package org.example.royalessence.repository;

import org.example.royalessence.models.BonusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BonusCodeRepository extends JpaRepository<BonusCode, Integer> {
    Optional<BonusCode> findByCode(String code);
}
