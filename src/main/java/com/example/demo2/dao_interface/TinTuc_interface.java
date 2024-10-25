package com.example.demo2.dao_interface;

import com.example.demo2.model.TinTuc;

import java.util.List;

public interface TinTuc_interface {
    void addTinTuc(TinTuc tinTuc);
    void updateTinTuc(TinTuc tinTuc);
    void deleteTinTuc(int maTT);
    List<TinTuc> getAllTinTuc();
    List<TinTuc> getTinTucByDM(int maDM);
}
