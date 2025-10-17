package com.tnsif.placement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.placement.entity.Placement;
import com.tnsif.placement.repository.PlacementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    public Optional<Placement> getPlacementById(int id) {
        return placementRepository.findById(id);
    }

    public Placement createPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    public Optional<Placement> updatePlacement(int id, Placement placement) {
        return placementRepository.findById(id).map(existing -> {
            placement.setId(id);
            return placementRepository.save(placement);
        });
    }

    public boolean deletePlacement(int id) {
        if (placementRepository.existsById(id)) {
            placementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
