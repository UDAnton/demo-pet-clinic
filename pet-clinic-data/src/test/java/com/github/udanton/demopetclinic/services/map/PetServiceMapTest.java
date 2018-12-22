package com.github.udanton.demopetclinic.services.map;

import com.github.udanton.demopetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    PetServiceMap petServiceMap;
    final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        Pet pet = new Pet();
        pet.setId(petId);
        petServiceMap.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(petId);
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(petId));
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet pet = new Pet();
        pet.setId(id);
        Pet savedPet = petServiceMap.save(pet);
        assertEquals(id, savedPet.getId());
    }


    @Test
    void saveNoId() {
        Pet pet = petServiceMap.save(new Pet());
        assertNotNull(pet);
        assertNotNull(pet.getId());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(petId);
        assertEquals(petId, pet.getId());
    }
}