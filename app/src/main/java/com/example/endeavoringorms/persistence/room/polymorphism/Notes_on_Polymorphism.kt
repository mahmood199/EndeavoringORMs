package com.example.endeavoringorms.persistence.room.polymorphism

/**
 *      We could go the other route: have a single table for all note objects, regardless of
 *      whether they are a comment or a link. For small objects with few properties, with a
 *      lot of overlap between the properties of the concrete types, this is manageable. It
 *      becomes unwieldy for many concrete types with many disparate properties. It also
 *      puts limits on your SQL, as the only practical NOT NULL columns are ones for which
 *      you can supply values for every possible concrete type. You also need some way of
 *      determining what concrete type to use for any given table row, and often that
 *      requires yet another column.
 */


/**
 *      Another way is to add all the columns of the child entities into parent columns.
 *      We can get whatever entity we need by specifying columns in the Query annotation.
 *      The function will return the appropriate entity
 *
 */