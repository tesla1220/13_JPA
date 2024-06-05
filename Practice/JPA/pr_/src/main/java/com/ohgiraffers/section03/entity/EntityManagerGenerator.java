package com.ohgiraffers.section03.entity;

import com.ohgiraffers.section01.entitymanager.EntityManagerFactoryGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerGenerator {

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerGenerator() {}

    public static EntityManager getManagerInstance() {

        return entityManagerFactory.createEntityManager();
    }

}
