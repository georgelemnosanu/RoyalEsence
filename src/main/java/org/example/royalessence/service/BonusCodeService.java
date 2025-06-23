package org.example.royalessence.service;

import org.example.royalessence.models.BonusCode;
import org.example.royalessence.repository.BonusCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BonusCodeService {

    private final BonusCodeRepository bonusCodeRepository;

    public BonusCodeService(BonusCodeRepository bonusCodeRepository) {
        this.bonusCodeRepository = bonusCodeRepository;
    }

    public BonusCode createBonusCode(BonusCode bonusCode) {
        return bonusCodeRepository.save(bonusCode);
    }

    public List<BonusCode> getAllBonusCodes() {
        return bonusCodeRepository.findAll();
    }

    public Optional<BonusCode> getById(Integer id) {
        return bonusCodeRepository.findById(id);
    }

    public Optional<BonusCode> getByCode(String code) {
        return bonusCodeRepository.findByCode(code);
    }

    public BonusCode updateBonusCode(BonusCode updated) {
        return bonusCodeRepository.save(updated);
    }

    public void deleteBonusCode(Integer id) {
        bonusCodeRepository.deleteById(id);
    }
}
