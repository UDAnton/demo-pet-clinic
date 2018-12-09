package com.github.udanton.demopetclinic.bootstrap;

import com.github.udanton.demopetclinic.model.Owner;
import com.github.udanton.demopetclinic.model.Vet;
import com.github.udanton.demopetclinic.services.OwnerService;
import com.github.udanton.demopetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Harry");
        owner1.setLastName("Potter");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sirius");
        owner2.setLastName("Black");
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
