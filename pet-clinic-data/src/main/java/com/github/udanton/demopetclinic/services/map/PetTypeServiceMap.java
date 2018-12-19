package com.github.udanton.demopetclinic.services.map;

import com.github.udanton.demopetclinic.model.PetType;
import com.github.udanton.demopetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapServices<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType t) {
        super.delete(t);
    }

    @Override
    public PetType save(PetType t) {
        return super.save(t);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
