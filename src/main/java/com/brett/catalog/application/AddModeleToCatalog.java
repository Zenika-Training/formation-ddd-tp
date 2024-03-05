package com.brett.catalog.application;

import com.brett.ApplicationService;
import com.brett.catalog.domain.velo.CodeModeleVelo;
import com.brett.catalog.domain.velo.ModeleDeVelo;
import com.brett.catalog.domain.velo.ModeleVeloRepository;
import com.brett.catalog.domain.velo.ValidateCodeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ApplicationService
@Service
public class AddModeleToCatalog {

    @Autowired
    public ModeleVeloRepository modeleVeloRepository;

    @Autowired
    public ValidateCodeModelService validateCodeModelService;

    public void addModele(CreateModelCommand command){
        var codeModele = new CodeModeleVelo(command.modele());
        validateCodeModelService.validate(codeModele);
        var modeleDeVelo = new ModeleDeVelo(codeModele);
        modeleVeloRepository.addModele(modeleDeVelo);
    }

}
