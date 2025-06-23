package org.example.royalessence.repository;


import org.example.royalessence.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner, Long> {
    Optional<Banner> findFirstByActiveTrue();
}