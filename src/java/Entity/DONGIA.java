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
public class DONGIA extends DOUONG{
    Date tuNgay, denNgay;
    Double moTa;

    public DONGIA() {
    }

    public DONGIA(Date tuNgay, Date denNgay, Double moTa, int maDoUong, String tenDoUong, int donGia_ID, int maDanhMuc_ID, Double donGia) {
        super(maDoUong, tenDoUong, donGia_ID, maDanhMuc_ID, donGia);
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.moTa = moTa;
    }

   

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public Double getMoTa() {
        return moTa;
    }

    public void setMoTa(Double moTa) {
        this.moTa = moTa;
    }
    
    
    
}
