package com.github.udanton.demopetclinic.bootstrap;

import com.github.udanton.demopetclinic.model.Owner;
import com.github.udanton.demopetclinic.model.Pet;
import com.github.udanton.demopetclinic.model.PetType;
import com.github.udanton.demopetclinic.model.Vet;
import com.github.udanton.demopetclinic.services.OwnerService;
import com.github.udanton.demopetclinic.services.PetTypeService;
import com.github.udanton.demopetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        System.out.println("Loaded Pet Types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Harry");
        owner1.setLastName("Potter");
        owner1.setCity("Kiev");
        owner1.setAdress("Khreshchatyk 12-B");
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
        owner2.setAdress("troyaschina 22-A");
        owner2.setTelephone("0931111111");


        Pet pet2 = new Pet();
        pet2.setName("Jack");
        pet2.setPetType(saveDogPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDay(LocalDate.now());

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jack");
        vet1.setLastName("Swagger");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Roy");
        vet2.setLastName("Jonas");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }

}
