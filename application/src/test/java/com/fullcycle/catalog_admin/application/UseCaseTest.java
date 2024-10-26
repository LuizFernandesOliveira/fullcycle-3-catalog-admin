package com.fullcycle.catalog_admin.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCaseTest {

    @Test
    void test() {
        UseCase useCase = new UseCase();
        assertNotNull(useCase.execute());
    }
}