package com.brett.catalog.application;

import com.brett.catalog.domain.Reference;
import com.brett.catalog.domain.ReferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowAllReferencesService {

    ReferenceRepository referenceRepository;

    public List<Reference> showAllReferences() {
        return referenceRepository.findAll();
    }

}
