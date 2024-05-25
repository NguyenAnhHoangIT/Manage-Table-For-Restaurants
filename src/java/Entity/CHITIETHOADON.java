/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class CHITIETHOADON {
    int maChiTiet_ID, maHoaDon_ID,maDoUong_ID;
    Double donGia;
    int soLuong;

    public CHITIETHOADON() {
    }

    public CHITIETHOADON(int maChiTiet_ID, int maHoaDon_ID, int maDoUong_ID, Double donGia, int soLuong) {
        this.maChiTiet_ID = maChiTiet_ID;
        this.maHoaDon_ID = maHoaDon_ID;
        this.maDoUong_ID = maDoUong_ID;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public int getMaChiTiet_ID() {
        return maChiTiet_ID;
    }

    public void setMaChiTiet_ID(int maChiTiet_ID) {
        this.maChiTiet_ID = maChiTiet_ID;
    }

    public int getMaHoaDon_ID() {
        return maHoaDon_ID;
    }

    public void setMaHoaDon_ID(int maHoaDon_ID) {
        this.maHoaDon_ID = maHoaDon_ID;
    }

    public int getMaDoUong_ID() {
        return maDoUong_ID;
    }

    public void setMaDoUong_ID(int maDoUong_ID) {
        this.maDoUong_ID = maDoUong_ID;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "CHITIETHOADON{" + "maChiTiet_ID=" + maChiTiet_ID + ", maHoaDon_ID=" + maHoaDon_ID + ", maDoUong_ID=" + maDoUong_ID + ", donGia=" + donGia + ", soLuong=" + soLuong + '}';
    }
    
}
