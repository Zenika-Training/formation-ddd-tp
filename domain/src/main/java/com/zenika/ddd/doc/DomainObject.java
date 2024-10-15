package com.zenika.ddd.doc;

import java.lang.annotation.Retention;

/**
 * Marker annotation for domain objects (Aka Entities).
 * Helper for Spring component scanning.
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface DomainObject {
}
