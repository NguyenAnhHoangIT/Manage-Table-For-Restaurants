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
public class HOADON {
    int maHoaDon_ID, maBan_ID;
    Double tongTien;
    Date ngayBan;

    public HOADON() {
    }

    public HOADON(int maHoaDon_ID, int maBan_ID, Double tongTien, Date ngayBan) {
        this.maHoaDon_ID = maHoaDon_ID;
        this.maBan_ID = maBan_ID;
        this.tongTien = tongTien;
        this.ngayBan = ngayBan;
    }

    public int getMaHoaDon_ID() {
        return maHoaDon_ID;
    }

    public void setMaHoaDon_ID(int maHoaDon_ID) {
        this.maHoaDon_ID = maHoaDon_ID;
    }

    public int getMaBan_ID() {
        return maBan_ID;
    }

    public void setMaBan_ID(int maBan_ID) {
        this.maBan_ID = maBan_ID;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    @Override
    public String toString() {
        return "HOADON{" + "maHoaDon_ID=" + maHoaDon_ID + ", maBan_ID=" + maBan_ID + ", tongTien=" + tongTien + ", ngayBan=" + ngayBan + '}';
    }
    
}
