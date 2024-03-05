package com.brett.catalog.application;

import com.brett.ApplicationService;
import com.brett.catalog.domain.velo.CodeModeleVelo;
import com.brett.catalog.domain.velo.ModeleDeVelo;
import com.brett.catalog.domain.velo.ModeleVeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ApplicationService
@Service
public class AddModeleToCatalog {

    @Autowired
    public ModeleVeloRepository modeleVeloRepository;

    public void addModele(CreateModelCommand command){
        ModeleDeVelo modeleDeVelo = new ModeleDeVelo(new CodeModeleVelo(command.modele()));
        modeleVeloRepository.addModele(modeleDeVelo);
    }

}
