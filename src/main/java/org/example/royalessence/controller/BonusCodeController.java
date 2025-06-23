package org.example.royalessence.controller;

import org.example.royalessence.models.BonusCode;
import org.example.royalessence.service.BonusCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/bonus-codes")
@CrossOrigin(origins = "http://localhost:3000")
public class BonusCodeController {

    private final BonusCodeService bonusCodeService;

    public BonusCodeController(BonusCodeService bonusCodeService) {
        this.bonusCodeService = bonusCodeService;
    }

    // Create bonus code
    @PostMapping
    public ResponseEntity<BonusCode> createBonusCode(@RequestBody BonusCode bonusCode) {
        BonusCode created = bonusCodeService.createBonusCode(bonusCode);
        return ResponseEntity.ok(created);
    }

    // Get all bonus codes
    @GetMapping
    public ResponseEntity<List<BonusCode>> getAllBonusCodes() {
        List<BonusCode> list = bonusCodeService.getAllBonusCodes();
        return ResponseEntity.ok(list);
    }

    // Get bonus code by ID
    @GetMapping("/{id}")
    public ResponseEntity<BonusCode> getBonusById(@PathVariable Integer id) {
        Optional<BonusCode> opt = bonusCodeService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get bonus code by code string
    @GetMapping("/by-code/{code}")
    public ResponseEntity<BonusCode> getByCode(@PathVariable String code) {
        Optional<BonusCode> opt = bonusCodeService.getByCode(code);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update bonus code
    @PutMapping("/{id}")
    public ResponseEntity<BonusCode> updateBonusCode(@PathVariable Integer id, @RequestBody BonusCode bonusCode) {
        bonusCode.setId(id);
        BonusCode updated = bonusCodeService.updateBonusCode(bonusCode);
        return ResponseEntity.ok(updated);
    }

    // Delete bonus code
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBonusCode(@PathVariable Integer id) {
        bonusCodeService.deleteBonusCode(id);
        return ResponseEntity.noContent().build();
    }
}
