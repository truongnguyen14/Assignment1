package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckduplicatedTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkduplicated() {
        assertFalse((new Checkduplicated()).Checkduplicated("Sid", "Cid", "Semester"));
        assertFalse((new Checkduplicated()).Checkduplicated("foo", "foo", "foo"));
    }
}