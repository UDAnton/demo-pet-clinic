package com.github.udanton.demopetclinic.services;

import com.github.udanton.demopetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
