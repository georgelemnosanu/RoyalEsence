package org.example.royalessence.controller;

import org.example.royalessence.models.Banner;
import org.example.royalessence.service.BannerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/banner")
@CrossOrigin(origins = "*")
public class BannerController {
    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    // GET /api/banner
    @GetMapping
    public Optional<Banner> getActiveBanner() {
        return bannerService.getActiveBanner();
    }

    // POST /api/banner (ex: creezi un nou banner)
    @PostMapping
    public Banner createBanner(@RequestBody Banner banner) {
        bannerService.deactivateAllBanners();
        return bannerService.saveBanner(banner);
    }
}
