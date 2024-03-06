package com.zenika.ddd.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.zenika.ddd.infrastructure.repository")
@EntityScan("com.zenika.ddd.infrastructure.entity")
public class SpringConfigInfrastructure {
}
