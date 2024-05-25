/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class CART extends DONGIA{
    int soLuong;

    public CART() {
    }

    public CART(int SoLuong, Date tuNgay, Date denNgay, Double moTa, int maDoUong, String tenDoUong, int donGia_ID, int maDanhMuc_ID, Double donGia) {
        super(tuNgay, denNgay, moTa, maDoUong, tenDoUong, donGia_ID, maDanhMuc_ID, donGia);
        this.soLuong = SoLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.soLuong = SoLuong;
    }
    
}
