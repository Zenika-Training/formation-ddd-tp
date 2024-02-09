package com.zenika.ddd.configuration;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.mvc.ValidationPiecesDepotApprenantController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.zenika.ddd"},
        basePackageClasses = {ValidationPiecesDepotApprenantController.class},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                DomainObject.class,
                DomainService.class,
                Stub.class
        })}
)
public class SpringConfig {
}
