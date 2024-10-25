package com.example.demo2.dao_imp;

import com.example.demo2.dao_interface.TinTuc_interface;
import com.example.demo2.model.TinTuc;
import com.example.demo2.untils.DbConnect;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TinTuc_imp implements TinTuc_interface {

    @Override
    public List<TinTuc> getAllTinTuc() {
        EntityManager em = DbConnect.getEntityManager();
        String mySQL = "SELECT t FROM TinTuc t";
        List<TinTuc> listTT = em.createQuery(mySQL, TinTuc.class).getResultList();
        em.close();
        return listTT;
    }

    @Override
    public List<TinTuc> getTinTucByDM(int maDM) {
        EntityManager em =DbConnect.getEntityManager();
        String mySQL = "SELECT t FROM TinTuc t WHERE t.danhMuc.maDM = :maDM";
        List<TinTuc> listTT = em.createQuery(mySQL, TinTuc.class).getResultList();
        em.close();
        return listTT;
    }

    @Override
    public void addTinTuc(TinTuc tinTuc) {
        EntityManager em = DbConnect.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tinTuc);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateTinTuc(TinTuc tinTuc) {

    }

    @Override
    public void deleteTinTuc(int maTT) {

    }


}
