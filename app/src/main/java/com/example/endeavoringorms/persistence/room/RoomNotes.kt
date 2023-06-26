package com.example.endeavoringorms.persistence.room

/**
 *  Note, though, that many of the annotation attributes
 *  that Room uses refer to column names, not property names
 */

/**
 *  Embedded Types
 *  With type converters, we are teaching Room how to deal with custom types, but we
 *  are limited to mapping from one property to one column. That property might be
 *  complex, but it still goes into one column in the table.
 *
 *  What happens, though, when we have multiple columns that should combine to
 *  create a single property?
 *
 *  In that case, we can use the @Embedded annotation on some data class or other
 *  simple Kotlin class, then use that class as a type in an entity.
 *
 */