package com.zenika.ddd;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchunitTest {

    @Test
    void hexagonal_architecture_domain_should_not_import_other_packages() {
        // Given
        JavaClasses classes = new ClassFileImporter().importPackages("com.zenika.ddd.domain..");

        // When
        ArchRule rule = noClasses().that().resideInAPackage("com.zenika.ddd.domain..")
                                   .should().accessClassesThat().resideInAnyPackage("com.zenika.ddd.infrastructure..");

        // Then
        rule.allowEmptyShould(true).check(classes);
    }
}
