package com.zenika.ddd.doc;

import java.lang.annotation.Retention;

/**
 * Marker annotation for domain services.
 * Helper for Spring component scanning.
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface DomainService {
}
