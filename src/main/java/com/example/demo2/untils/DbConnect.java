package com.example.demo2.untils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnect {
    private static EntityManagerFactory emf= null;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("tintucQL");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static EntityManager getEntityManager(){
        if (emf != null && emf.isOpen()) {
            return emf.createEntityManager();
        } else {
            throw new IllegalStateException("EntityManagerFactory is not initialized or closed.");
        }
    }

    public static void close(){
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
