package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryGenerator {

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerFactoryGenerator() {}

    public static EntityManagerFactory getInstance() {

        return factory;
    }


}
