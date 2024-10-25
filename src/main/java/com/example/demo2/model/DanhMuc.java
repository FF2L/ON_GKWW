package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "DanhMuc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDM;
    private String TenDm;
    private String nguoiQL;
    private String ghiChu;

    public DanhMuc() {
    }

    public DanhMuc(int maDM) {
        this.maDM = maDM;
    }

    public DanhMuc(int maDM, String ghiChu, String nguoiQL, String tenDm) {
        this.maDM = maDM;
        this.ghiChu = ghiChu;
        this.nguoiQL = nguoiQL;
        TenDm = tenDm;
    }

    public DanhMuc(String tenDm, String nguoiQL, String ghiChu) {
        TenDm = tenDm;
        this.nguoiQL = nguoiQL;
        this.ghiChu = ghiChu;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNguoiQL() {
        return nguoiQL;
    }

    public void setNguoiQL(String nguoiQL) {
        this.nguoiQL = nguoiQL;
    }

    public String getTenDm() {
        return TenDm;
    }

    public void setTenDm(String tenDm) {
        TenDm = tenDm;
    }
    //    @OneToMany(mappedBy = "danhMuc")
//    private List<TinTuc> tintuc;
}
