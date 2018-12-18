package com.github.udanton.demopetclinic.repositories;

import com.github.udanton.demopetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
