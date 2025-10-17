package com.tnsif.placement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.placement.entity.Placement;
import com.tnsif.placement.service.PlacementService;

import java.util.List;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable int id) {
        return placementService.getPlacementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Placement> createPlacement(@RequestBody Placement placement) {
        return ResponseEntity.status(201).body(placementService.createPlacement(placement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Placement> updatePlacement(@PathVariable int id, @RequestBody Placement placement) {
        return placementService.updatePlacement(id, placement)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlacement(@PathVariable int id) {
        if (placementService.deletePlacement(id)) {
            return ResponseEntity.ok("Placement with ID " + id + " deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
