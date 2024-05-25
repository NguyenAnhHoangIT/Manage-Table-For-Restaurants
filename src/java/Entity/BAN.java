/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class BAN {
    int maBan_ID;
    String tenBan, trangThai, moTa;
    int maKhuVuc_ID;

    public BAN() {
    }

    public BAN(int maBan_ID, String tenBan, String trangThai, String moTa, int maKhuVuc_ID) {
        this.maBan_ID = maBan_ID;
        this.tenBan = tenBan;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.maKhuVuc_ID = maKhuVuc_ID;
    }

    public int getMaBan_ID() {
        return maBan_ID;
    }

    public void setMaBan_ID(int maBan_ID) {
        this.maBan_ID = maBan_ID;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaKhuVuc_ID() {
        return maKhuVuc_ID;
    }

    public void setMaKhuVuc_ID(int maKhuVuc_ID) {
        this.maKhuVuc_ID = maKhuVuc_ID;
    }

    @Override
    public String toString() {
        return "BAN{" + "maBan_ID=" + maBan_ID + ", tenBan=" + tenBan + ", trangThai=" + trangThai + ", moTa=" + moTa + ", maKhuVuc_ID=" + maKhuVuc_ID + '}';
    }
    
}
