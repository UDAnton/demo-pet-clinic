package com.github.udanton.demopetclinic.repositories;

import com.github.udanton.demopetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
