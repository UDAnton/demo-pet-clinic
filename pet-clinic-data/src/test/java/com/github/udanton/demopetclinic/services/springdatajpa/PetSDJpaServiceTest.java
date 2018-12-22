package com.github.udanton.demopetclinic.services.springdatajpa;

import com.github.udanton.demopetclinic.model.Pet;
import com.github.udanton.demopetclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService petSDJpaService;

    Pet returnPet;


    @BeforeEach
    void setUp() {
        returnPet = new Pet();
        returnPet.setId(1L);
    }

    @Test
    void findAll() {
        Set<Pet> returnPets = new HashSet<>();

        Pet pet1 = new Pet();
        pet1.setId(1L);

        Pet pet2 = new Pet();
        pet2.setId(2L);

        returnPets.add(pet1);
        returnPets.add(pet2);

        when(petRepository.findAll()).thenReturn(returnPets);

        Set<Pet> pets = petSDJpaService.findAll();

        assertNotNull(pets);
        assertEquals(2, pets.size());
        verify(petRepository).findAll();
    }

    @Test
    void findById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(returnPet));
        assertNotNull(petSDJpaService.findById(returnPet.getId()));
    }

    @Test
    void findByIdNotFound() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.empty());
        Pet pet = petSDJpaService.findById(1L);
        assertNull(pet);
    }

    @Test
    void save() {
        when(petRepository.save(any())).thenReturn(returnPet);

        Pet pet = petSDJpaService.save(returnPet);

        assertNotNull(pet);

        verify(petRepository).save(any());
    }

    @Test
    void delete() {
        petSDJpaService.delete(returnPet);
        verify(petRepository).delete(any());
    }

    @Test
    void deleteById() {
        petSDJpaService.deleteById(returnPet.getId());
        verify(petRepository).deleteById(anyLong());
    }
}