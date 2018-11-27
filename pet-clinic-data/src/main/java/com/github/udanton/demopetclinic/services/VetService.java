package com.github.udanton.demopetclinic.services;

import com.github.udanton.demopetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByid(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
