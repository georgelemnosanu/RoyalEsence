package org.example.royalessence.service;

import org.example.royalessence.models.Banner;
import org.example.royalessence.repository.BannerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public Optional<Banner> getActiveBanner() {
        return bannerRepository.findFirstByActiveTrue();
    }

    public Banner saveBanner(Banner banner) {
        return bannerRepository.save(banner);
    }

    public void deactivateAllBanners() {
        bannerRepository.findAll().forEach(b -> {
            b.setActive(false);
            bannerRepository.save(b);
        });
    }
}
