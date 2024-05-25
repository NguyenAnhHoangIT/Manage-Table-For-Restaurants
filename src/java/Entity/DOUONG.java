/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class DOUONG {
    int maDoUong;
    String tenDoUong;
    int donGia_ID, maDanhMuc_ID;
    Double donGia;

    public DOUONG() {
    }

    public DOUONG(int maDoUong, String tenDoUong, int donGia_ID, int maDanhMuc_ID, Double donGia) {
        this.maDoUong = maDoUong;
        this.tenDoUong = tenDoUong;
        this.donGia_ID = donGia_ID;
        this.maDanhMuc_ID = maDanhMuc_ID;
        this.donGia = donGia;
    }
    

    public int getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(int maDoUong) {
        this.maDoUong = maDoUong;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public int getDonGia_ID() {
        return donGia_ID;
    }

    public void setDonGia_ID(int donGia_ID) {
        this.donGia_ID = donGia_ID;
    }

    public int getMaDanhMuc_ID() {
        return maDanhMuc_ID;
    }

    public void setMaDanhMuc_ID(int maDanhMuc_ID) {
        this.maDanhMuc_ID = maDanhMuc_ID;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "DOUONG{" + "maDoUong=" + maDoUong + ", tenDoUong=" + tenDoUong + ", donGia_ID=" + donGia_ID + ", maDanhMuc_ID=" + maDanhMuc_ID + ", donGia=" + donGia + '}';
    }
    


    
}
