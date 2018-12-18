package com.github.udanton.demopetclinic.repositories;

import com.github.udanton.demopetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
