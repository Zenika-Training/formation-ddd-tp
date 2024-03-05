package com.brett.catalog.domain.velo;

public interface ValidateCodeModelService {

    /**
     * Throw an exception if the code modele is invalid
     * @param codeModeleVelo
     */
    void validate(CodeModeleVelo codeModeleVelo);

}
