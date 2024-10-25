package com.example.demo2.untils;

import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager en = DbConnect.getEntityManager();
        en.getTransaction().begin();
    }
}
