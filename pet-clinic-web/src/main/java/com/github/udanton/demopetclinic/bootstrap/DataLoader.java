package com.github.udanton.demopetclinic.bootstrap;

import com.github.udanton.demopetclinic.model.*;
import com.github.udanton.demopetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        System.out.println("Loaded Pet Types...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        System.out.println("Loaded Specialities...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Harry");
        owner1.setLastName("Potter");
        owner1.setCity("Kiev");
        owner1.setAddress("Khreshchatyk 12-B");
        owner1.setTelephone("0991111111");

        Pet pet1 = new Pet();
        pet1.setName("Lancelot");
        pet1.setPetType(saveCatPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDay(LocalDate.now());

        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sirius");
        owner2.setLastName("Black");
        owner2.setCity("Kiev");
        owner2.setAddress("troyaschina 22-A");
        owner2.setTelephone("0931111111");


        Pet pet2 = new Pet();
        pet2.setName("Jack");
        pet2.setPetType(saveDogPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDay(LocalDate.now());

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        Visit visit2 = new Visit();
        visit2.setPet(pet2);
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Sneezy Kitty");

        visitService.save(visit2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jack");
        vet1.setLastName("Swagger");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roy");
        vet2.setLastName("Jonas");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }

}
