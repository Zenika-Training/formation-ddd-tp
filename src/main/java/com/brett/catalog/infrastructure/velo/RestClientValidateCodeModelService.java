package com.brett.catalog.infrastructure.velo;

import com.brett.catalog.domain.velo.CodeModeleVelo;
import com.brett.catalog.domain.velo.ValidateCodeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RestClientValidateCodeModelService implements ValidateCodeModelService {

    //@Autowired
    RestClient restClient;

    @Override
    public void validate(CodeModeleVelo codeModeleVelo) {
        // restClient.get();
        // details techniques de l'appel REST sur cet endpoint pour implementer la validation
        // Wiremock
    }
}
