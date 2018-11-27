package com.github.udanton.demopetclinic.services;

import com.github.udanton.demopetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByid(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
