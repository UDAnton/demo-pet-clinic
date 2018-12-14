package com.github.udanton.demopetclinic.services.map;

import com.github.udanton.demopetclinic.model.Speciality;
import com.github.udanton.demopetclinic.services.SpecialitiesService;

import java.util.Set;

public class SpecialitiesServiceMap extends AbstractMapServices<Speciality, Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality t) {
        super.delete(t);
    }

    @Override
    public Speciality save(Speciality t) {
        return super.save(t);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
