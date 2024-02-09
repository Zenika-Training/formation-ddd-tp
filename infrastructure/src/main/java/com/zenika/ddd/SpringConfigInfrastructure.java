package com.zenika.ddd;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.zenika.ddd.repository")
@EntityScan("com.zenika.ddd.entity")
public class SpringConfigInfrastructure {
}
