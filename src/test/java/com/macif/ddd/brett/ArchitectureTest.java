package com.macif.ddd.brett;

import com.tngtech.archunit.core.domain.JavaPackage;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = {"com.macif.ddd.brett.catalogue"} )
public class ArchitectureTest {



    @ArchTest
    static final ArchRule validerArchitectureHexagonale =
        onionArchitecture().domainServices("..domain..")
                .domainModels("..domain.model..")
                .applicationServices("..application..")
                .adapter("database", "..infrastructure.database..")
                .adapter("inmemory", "..infrastructure.inmemory..")
            ;


}
