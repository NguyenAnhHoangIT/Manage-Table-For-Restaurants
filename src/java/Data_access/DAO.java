/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_access;

import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import Entity.*;

/**
 *
 * @author Admin
 */
public class DAO {

    SQLSEVERDataAccess con;

    public List<KHUVUC> getAllKhuVuc() {
        List<KHUVUC> ds = new ArrayList<>();
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT [MaKhuVuc_ID]\n"
                    + "      ,[TenKhuVuc]\n"
                    + "      ,[Mota]\n"
                    + "  FROM [dbo].[KHUVUC]";
            ResultSet rs = con.getResultSet(sql);
            while (rs.next()) {
                KHUVUC kv = new KHUVUC();
                kv.setMaKhuVuc_ID(rs.getInt("MaKhuVuc_ID"));
                kv.setTenKhuVuc(rs.getString("TenKhuVuc"));
                kv.setMoTa(rs.getString("MoTa"));
                ds.add(kv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public int DemSoKhu() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT COUNT(MaKhuVuc_ID) AS tong FROM KHUVUC";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("tong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public List<BAN> getBanTheoKhu(int k) {
        List<BAN> ds = new ArrayList<>();
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT [MaBan_ID]\n"
                    + "      ,[TenBan]\n"
                    + "      ,[TrangThai]\n"
                    + "      ,[MoTa]\n"
                    + "      ,[MaKhuVuc_ID]\n"
                    + "  FROM [dbo].[BAN]"
                    + "  WHERE [MaKhuVuc_ID] = ?";
            Object[] params = {k};
            ResultSet rs = con.getResultSet(sql, params);
            while (rs.next()) {
                BAN b = new BAN();
                b.setMaBan_ID(rs.getInt("MaBan_ID"));
                b.setTenBan(rs.getString("TenBan"));
                b.setTrangThai(rs.getString("TrangThai"));
                b.setMoTa(rs.getString("MoTa"));
                b.setMaKhuVuc_ID(rs.getInt("MaKhuVuc_ID"));
                ds.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<DANHMUC> getAllDanhMuc() {
        List<DANHMUC> ds = new ArrayList<>();
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT [Madanhmuc_ID]\n"
                    + "      ,[TenDanhMuc]\n"
                    + "      ,[MaDanhMuc_Cha]\n"
                    + "  FROM [dbo].[DANHMUC]";
            ResultSet rs = con.getResultSet(sql);
            while (rs.next()) {
                DANHMUC kv = new DANHMUC();
                kv.setMaDanhMuc_ID(rs.getInt("Madanhmuc_ID"));
                kv.setTenDanhMuc(rs.getString("TenDanhMuc"));
                kv.setMaDanhMuc_cha(rs.getInt("MaDanhMuc_Cha"));
                ds.add(kv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public int DemSoDanhMuc() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT COUNT(Madanhmuc_ID) AS tong FROM DANHMUC";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("tong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public List<DOUONG> getAllDoUong() {
        List<DOUONG> ds = new ArrayList<>();
        try {
            con = new SQLSEVERDataAccess();
            String sql = "select m.*, d.MoTa as dongia\n"
                    + "from MENUDOUONG as m, DONGIA as d \n"
                    + "where m.DonGia_ID = D.DonGia_ID";
            ResultSet rs = con.getResultSet(sql);
            while (rs.next()) {
                DOUONG b = new DOUONG();
                b.setMaDoUong(rs.getInt("MaDoUong_ID"));
                b.setTenDoUong(rs.getString("TenDoUong"));
                b.setDonGia_ID(rs.getInt("DonGia_ID"));
                b.setMaDanhMuc_ID(rs.getInt("MaDanhMuc_ID"));
                b.setDonGia(rs.getDouble("dongia"));
                ds.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public int timDonGia_ID() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT top (1) DonGia_ID FROM DONGIA order by DonGia_ID desc";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("DonGia_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int timMaDoUong_ID() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT top (1) MaDoUong_ID FROM MENUDOUONG order by MaDoUong_ID desc";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("MaDoUong_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public void insertDonGia(DONGIA monmoi) {
        con = new SQLSEVERDataAccess();
        int madg_raw = timDonGia_ID() + 1;
        int madu = timMaDoUong_ID() + 1;
        String sql1 = "INSERT INTO [dbo].[DONGIA]\n"
                + "           ([DonGia_ID]\n"
                + "           ,[MaDoUong_ID]\n"
                + "           ,[TuNgay]\n"
                + "           ,[DenNgay]\n"
                + "           ,[MoTa])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        Object[] params1 = {madg_raw, madu, monmoi.getTuNgay(), monmoi.getDenNgay(), monmoi.getMoTa()};
        int rs1 = con.ExecuteUpdateSQL(sql1, params1);
    }

    public void insertDoUong(DONGIA monmoi) {
        int madu = timMaDoUong_ID() + 1;
        int madg = timDonGia_ID();
        String sql2 = "INSERT INTO [dbo].[MENUDOUONG]\n"
                + "           ([MaDoUong_ID]\n"
                + "           ,[TenDoUong]\n"
                + "           ,[DonGia_ID]\n"
                + "           ,[MaDanhMuc_ID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        Object[] params2 = {madu, monmoi.getTenDoUong(), madg, monmoi.getMaDanhMuc_ID()};
        int rs2 = con.ExecuteUpdateSQL(sql2, params2);
    }

    public int timMaKhuVuc_ID() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT top (1) MaKhuVuc_ID FROM KHUVUC order by MaKhuVuc_ID desc";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("MaKhuVuc_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int timMaBan_ID() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT top (1) MaBan_ID FROM BAN order by MaBan_ID desc";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("MaBan_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public void insertKhuVuc(KHUVUC khumoi) {
        con = new SQLSEVERDataAccess();
        int makv = timMaKhuVuc_ID() + 1;
        String sq = "INSERT INTO [dbo].[KHUVUC]\n"
                + "           ([MaKhuVuc_ID]\n"
                + "           ,[TenKhuVuc]\n"
                + "           ,[Mota])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        Object[] params = {makv, khumoi.getTenKhuVuc(), khumoi.getMoTa()};
        int rs = con.ExecuteUpdateSQL(sq, params);
    }

    public void insertBan(BAN banmoi) {
        con = new SQLSEVERDataAccess();
        int mab = timMaBan_ID() + 1;
        String tt = "Available";
        String sq = "INSERT INTO [dbo].[BAN]\n"
                + "           ([MaBan_ID]\n"
                + "           ,[TenBan]\n"
                + "           ,[TrangThai]\n"
                + "           ,[MoTa]\n"
                + "           ,[MaKhuVuc_ID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        Object[] params = {mab, banmoi.getTenBan(), tt, banmoi.getMoTa(), banmoi.getMaKhuVuc_ID()};
        int rs = con.ExecuteUpdateSQL(sq, params);
    }

    public ArrayList<CART> getCartDoUong(ArrayList<CHITIETHOADON> cartList) {
        con = new SQLSEVERDataAccess();
        ArrayList<CART> products = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (CHITIETHOADON item : cartList) {
                    con = new SQLSEVERDataAccess();
                    String sql = "select m.MaDoUong_ID, m.TenDoUong, d.MoTa\n"
                            + "from MENUDOUONG as m, DONGIA as d\n"
                            + "where m.DonGia_ID = d.DonGia_ID and m.MaDoUong_ID = ?";
                    Object[] params = {item.getMaDoUong_ID()};
                    ResultSet rs = con.getResultSet(sql, params);
                    while (rs.next()) {
                        CART row = new CART();
                        row.setSoLuong(item.getSoLuong());
                        row.setMaDoUong(rs.getInt("MaDoUong_ID"));
                        row.setTenDoUong(rs.getString("TenDoUong"));
                        double unitPrice = rs.getDouble("MoTa");
                        int quantity = item.getSoLuong();
                        double totalPrice = unitPrice * quantity;
                        row.setDonGia(totalPrice);

                        products.add(row);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public Double getTotalCartPrice(ArrayList<CHITIETHOADON> cartList) {
        con = new SQLSEVERDataAccess();
        Double total = 0.0;
        try {
            if (cartList.size() > 0) {
                for (CHITIETHOADON item : cartList) {
                    String sql = "select d.MoTa\n"
                            + "from MENUDOUONG as m, DONGIA as d\n"
                            + "where m.DonGia_ID = d.DonGia_ID and m.MaDoUong_ID = ?";
                    Object[] params = {item.getMaDoUong_ID()};
                    ResultSet rs = con.getResultSet(sql, params);
                    while (rs.next()) {
                        total += rs.getDouble("MoTa") * item.getSoLuong();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int timHoaDon_ID() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT top (1) MaHoaDon_ID FROM HOADON order by MaHoaDon_ID desc";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("MaHoaDon_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public void insertHoaDon(HOADON hoadon) {
        con = new SQLSEVERDataAccess();
        String sq = "INSERT INTO [dbo].[HOADON]\n"
                + "           ([MaHoaDon_ID]\n"
                + "           ,[MaBan_ID]\n"
                + "           ,[TongTien]\n"
                + "           ,[NgayBan])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        Object[] params = {hoadon.getMaHoaDon_ID(), hoadon.getMaBan_ID(), hoadon.getTongTien(), hoadon.getNgayBan()};
        int rs = con.ExecuteUpdateSQL(sq, params);
    }

    public int timMaChiTiet_ID() {
        int kq = 0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "SELECT top (1) MaChiTiet_ID FROM CHITIETHOADON order by MaChiTiet_ID desc";
            ResultSet rs = con.getResultSet(sql);
            if (rs.next()) {
                kq = rs.getInt("MaChiTiet_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public void insertChiTietHoaDon(CHITIETHOADON chitiet) {
        con = new SQLSEVERDataAccess();
        int machitiet = timMaChiTiet_ID() + 1;
        String sq = "INSERT INTO [dbo].[CHITIETHOADON]\n"
                + "           ([MaChiTiet_ID]\n"
                + "           ,[MaHoaDon_ID]\n"
                + "           ,[MaDoUong_ID]\n"
                + "           ,[DonGia]\n"
                + "           ,[SoLuong])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        Object[] params = {machitiet, chitiet.getMaHoaDon_ID(), chitiet.getMaDoUong_ID(), chitiet.getDonGia(), chitiet.getSoLuong()};
        int rs = con.ExecuteUpdateSQL(sq, params);
    }

    public int updateBanTrangThai(int ban_id, String trangthai) {
        con = new SQLSEVERDataAccess();
        String newTrangThai = "Available".equals(trangthai) ? "Using" : "Available";
        String sq = "update BAN \n"
                + "set TrangThai = ?\n"
                + "where MaBan_ID = ?";
        Object[] params = {newTrangThai, ban_id};
        int rs = con.ExecuteUpdateSQL(sq, params);
        return rs;
    }

    public Double convertMaDoUong_IDtoDonGia(int id) {
        Double kq = 0.0;
        try {
            con = new SQLSEVERDataAccess();
            String sql = "select d.MoTa\n"
                    + "from MENUDOUONG as m, DONGIA as d\n"
                    + "where m.DonGia_ID = d.DonGia_ID and m.MaDoUong_ID = ?";
            Object[] params = {id};
            ResultSet rs = con.getResultSet(sql, params);
            if (rs.next()) {
                kq = rs.getDouble("MoTa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int timMaHoaDon_ID(int ban_id) {
        con = new SQLSEVERDataAccess();
        int kq = 0;
        try {
            String sql = "SELECT [MaHoaDon_ID]\n"
                    + "      ,[MaBan_ID]\n"
                    + "      ,[TongTien]\n"
                    + "      ,[NgayBan]\n"
                    + "  FROM [dbo].[HOADON]\n"
                    + "where MaBan_ID = ?\n"
                    + "order by NgayBan desc";
            Object[] params = {ban_id};
            ResultSet rs = con.getResultSet(sql, params);
            if (rs.next()) {
                kq = rs.getInt("MaHoaDon_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public HOADON getHoaDon(int mahoadon) {
        con = new SQLSEVERDataAccess();
        HOADON h = new HOADON();
        try {
            String sql = "SELECT [MaHoaDon_ID]\n"
                    + ",[MaBan_ID]\n"
                    + ",[TongTien]\n"
                    + ",[NgayBan]\n"
                    + "FROM [dbo].[HOADON]\n"
                    + "where MaHoaDon_ID = ?";
            Object[] params = {mahoadon};
            ResultSet rs = con.getResultSet(sql, params);
            while (rs.next()) {
                h.setMaHoaDon_ID(rs.getInt("MaHoaDon_ID"));
                h.setMaBan_ID(rs.getInt("MaBan_ID"));
                h.setTongTien(rs.getDouble("TongTien"));
                h.setNgayBan(rs.getDate("NgayBan"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return h;
    }

    public List<CHITIETHOADON> getDoUongfromChiTiet(int mahoadon) {
        con = new SQLSEVERDataAccess();
        List<CHITIETHOADON> products = new ArrayList<>();
        try {
            String sql = "SELECT [MaChiTiet_ID]\n"
                    + "      ,[MaHoaDon_ID]\n"
                    + "      ,[MaDoUong_ID]\n"
                    + "      ,[DonGia]\n"
                    + "      ,[SoLuong]\n"
                    + "  FROM [dbo].[CHITIETHOADON]\n"
                    + "where MaHoaDon_ID = ?";
            Object[] params = {mahoadon};
            ResultSet rs = con.getResultSet(sql, params);
            while (rs.next()) {
                CHITIETHOADON c = new CHITIETHOADON();
                c.setMaChiTiet_ID(rs.getInt("MaChiTiet_ID"));
                c.setMaHoaDon_ID(rs.getInt("MaHoaDon_ID"));
                c.setMaDoUong_ID(rs.getInt("MaDoUong_ID"));
                c.setDonGia(rs.getDouble("DonGia"));
                c.setSoLuong(rs.getInt("SoLuong"));
                products.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public List<CART> getThongTinDoUong(ArrayList<CHITIETHOADON> cartList) {
        con = new SQLSEVERDataAccess();
        List<CART> products = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (CHITIETHOADON item : cartList) {
                    con = new SQLSEVERDataAccess();
                    String sql = "select c.MaDoUong_ID, m.TenDoUong, c.DonGia, c.SoLuong\n"
                            + "from CHITIETHOADON as c, MENUDOUONG as m\n"
                            + "where c.MaDoUong_ID = m.MaDoUong_ID and c.MaDoUong_ID = ? and c.MaChiTiet_ID = ?";
                    Object[] params = {item.getMaDoUong_ID(), item.getMaChiTiet_ID()};
                    ResultSet rs = con.getResultSet(sql, params);
                    while (rs.next()) {
                        CART row = new CART();
                        row.setMaDoUong(rs.getInt("MaDoUong_ID"));
                        row.setTenDoUong(rs.getString("TenDoUong"));
                        row.setDonGia(rs.getDouble("DonGia"));
                        row.setSoLuong(rs.getInt("SoLuong"));
                        products.add(row);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public CART getCart_DoUong(CHITIETHOADON item) {
        con = new SQLSEVERDataAccess();
        CART products = new CART();
        try {
            con = new SQLSEVERDataAccess();
            String sql = "select m.MaDoUong_ID, m.TenDoUong, d.MoTa\n"
                    + "from MENUDOUONG as m, DONGIA as d\n"
                    + "where m.DonGia_ID = d.DonGia_ID and m.MaDoUong_ID = ?";
            Object[] params = {item.getMaDoUong_ID()};
            ResultSet rs = con.getResultSet(sql, params);
            while (rs.next()) {
                CART row = new CART();
                row.setMaDoUong(rs.getInt("MaDoUong_ID"));
                row.setTenDoUong(rs.getString("TenDoUong"));
                row.setDonGia(rs.getDouble("MoTa") * item.getSoLuong());
                row.setSoLuong(rs.getInt(item.getSoLuong()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
}
