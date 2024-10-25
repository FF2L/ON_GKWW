package com.example.demo2.dao_imp;

import com.example.demo2.dao_interface.DanhMuc_interface;
import com.example.demo2.model.DanhMuc;
import com.example.demo2.untils.DbConnect;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DanhMuc_imp implements DanhMuc_interface {

    @Override
    public List<DanhMuc> getAllDanhMuc() {
        EntityManager em = DbConnect.getEntityManager();
        String mySQL = "SELECT d from DanhMuc  d";
        List<DanhMuc> listDM = em.createQuery(mySQL, DanhMuc.class).getResultList();
        em.close();
        return listDM;
    }

    @Override
    public void addDanhMuc(DanhMuc danhMuc) {
        EntityManager em = DbConnect.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(danhMuc);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

    }

    @Override
    public void updatDanhMuc(DanhMuc danhMuc) {
        EntityManager em = DbConnect.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(danhMuc);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

    }

    @Override
    public void deleteDanhMuc(int maDM) {
        EntityManager em = DbConnect.getEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.find(DanhMuc.class, maDM));
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }


}
