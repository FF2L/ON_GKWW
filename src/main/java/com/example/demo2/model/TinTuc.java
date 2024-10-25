package com.example.demo2.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TinTuc")

public class TinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTT;
    @ManyToOne
    @JoinColumn(name = "maDM")
    private DanhMuc danhMuc;
    private String tieuDe;
    private String noiDungTT;
    private String lienKet;



    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setNoiDungTT(String noiDungTT) {
        this.noiDungTT = noiDungTT;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public int getMaTT() {
        return maTT;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public String getLienKet() {
        return lienKet;
    }

    public String getNoiDungTT() {
        return noiDungTT;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public TinTuc(int maTT) {
        this.maTT = maTT;
    }

    public TinTuc(DanhMuc danhMuc, String lienKet, String noiDungTT, String tieuDe) {
        this.danhMuc = danhMuc;
        this.lienKet = lienKet;
        this.noiDungTT = noiDungTT;
        this.tieuDe = tieuDe;
    }

    public TinTuc() {
    }

    public TinTuc(int maTT, DanhMuc danhMuc, String tieuDe, String noiDungTT, String lienKet) {
        this.maTT = maTT;
        this.danhMuc = danhMuc;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
    }
}
