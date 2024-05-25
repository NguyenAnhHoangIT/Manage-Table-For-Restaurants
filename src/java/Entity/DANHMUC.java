/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class DANHMUC {
    int maDanhMuc_ID;
    String tenDanhMuc;
    int maDanhMuc_cha;

    public DANHMUC() {
    }

    public DANHMUC(int maDanhMuc_ID, String tenDanhMuc, int maDanhMuc_cha) {
        this.maDanhMuc_ID = maDanhMuc_ID;
        this.tenDanhMuc = tenDanhMuc;
        this.maDanhMuc_cha = maDanhMuc_cha;
    }

    public int getMaDanhMuc_ID() {
        return maDanhMuc_ID;
    }

    public void setMaDanhMuc_ID(int maDanhMuc_ID) {
        this.maDanhMuc_ID = maDanhMuc_ID;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getMaDanhMuc_cha() {
        return maDanhMuc_cha;
    }

    public void setMaDanhMuc_cha(int maDanhMuc_cha) {
        this.maDanhMuc_cha = maDanhMuc_cha;
    }

    @Override
    public String toString() {
        return "DANHMUC{" + "maDanhMuc_ID=" + maDanhMuc_ID + ", tenDanhMuc=" + tenDanhMuc + ", maDanhMuc_cha=" + maDanhMuc_cha + '}';
    }
    
}
