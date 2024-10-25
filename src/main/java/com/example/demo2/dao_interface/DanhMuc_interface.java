package com.example.demo2.dao_interface;

import com.example.demo2.model.DanhMuc;

import java.util.List;

public interface DanhMuc_interface {
    void addDanhMuc(DanhMuc danhMuc);
    void updatDanhMuc(DanhMuc danhMuc);
    void deleteDanhMuc(int maDM);
    List<DanhMuc> getAllDanhMuc();

}
