package com.github.udanton.demopetclinic.services;

import com.github.udanton.demopetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(Long id);

    Owner findByid(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
