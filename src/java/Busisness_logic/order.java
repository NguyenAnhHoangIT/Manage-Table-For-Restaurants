/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Busisness_logic;

import Data_access.DAO;
import Entity.CHITIETHOADON;
import Entity.HOADON;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
@WebServlet(name = "order", urlPatterns = {"/order"})
public class order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        Date date = new Date();
        int hoadon = Integer.parseInt(request.getParameter("hoadon"));
        int maban = Integer.parseInt(request.getParameter("maban"));
        String trangthai = request.getParameter("trangthai");
        
        ArrayList<CHITIETHOADON> cart_list = (ArrayList<CHITIETHOADON>) request.getSession().getAttribute("douong_list");
        if (cart_list != null) {
            HOADON hd = new HOADON();
            hd.setMaHoaDon_ID(hoadon);
            hd.setMaBan_ID(maban);
            hd.setTongTien(dao.getTotalCartPrice(cart_list));
            hd.setNgayBan(date);
            dao.insertHoaDon(hd);
            for(CHITIETHOADON c : cart_list) {
                CHITIETHOADON order = new CHITIETHOADON();
                order.setMaHoaDon_ID(hoadon);
                order.setMaDoUong_ID(c.getMaDoUong_ID());
                order.setSoLuong(c.getSoLuong());
                order.setDonGia(dao.convertMaDoUong_IDtoDonGia(c.getMaDoUong_ID()));
                dao.insertChiTietHoaDon(order);
            }
            dao.updateBanTrangThai(maban, trangthai);
            cart_list.clear();
            response.sendRedirect("datmon?id=" + maban + "&trangthai=Using");
        } else {
            response.sendRedirect("datmon?id=" + maban + "&trangthai="+trangthai);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
