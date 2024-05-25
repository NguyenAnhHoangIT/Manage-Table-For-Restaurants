/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class KHUVUC {
    int maKhuVuc_ID;
    String tenKhuVuc, moTa;

    public KHUVUC() {
    }

    public KHUVUC(int maKhuVuc_ID, String tenKhuVuc, String moTa) {
        this.maKhuVuc_ID = maKhuVuc_ID;
        this.tenKhuVuc = tenKhuVuc;
        this.moTa = moTa;
    }

    public int getMaKhuVuc_ID() {
        return maKhuVuc_ID;
    }

    public void setMaKhuVuc_ID(int maKhuVuc_ID) {
        this.maKhuVuc_ID = maKhuVuc_ID;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "KHUVUC{" + "maKhuVuc_ID=" + maKhuVuc_ID + ", tenKhuVuc=" + tenKhuVuc + ", moTa=" + moTa + '}';
    }
    
}
