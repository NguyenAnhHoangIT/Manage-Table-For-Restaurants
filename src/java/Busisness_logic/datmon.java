/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Busisness_logic;

import Data_access.DAO;
import Entity.CART;
import Entity.CHITIETHOADON;
import Entity.DANHMUC;
import Entity.DOUONG;
import Entity.HOADON;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "datmon", urlPatterns = {"/datmon"})
public class datmon extends HttpServlet {

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
            out.println("<title>Servlet datmon</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet datmon at " + request.getContextPath() + "</h1>");
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
        List<DOUONG> d = dao.getAllDoUong();
        request.setAttribute("dsdouong", d);
        int maban = Integer.valueOf(request.getParameter("id"));
        String tt = request.getParameter("trangthai");
        if ("Available".equals(tt)) {
            int mahoadon = dao.timHoaDon_ID() + 1;

            HttpSession session = request.getSession();

            ArrayList<CHITIETHOADON> cart_list = (ArrayList<CHITIETHOADON>) session.getAttribute("douong_list");
            if (cart_list != null) {
                ArrayList<CART> cartProduct = dao.getCartDoUong(cart_list);
                request.setAttribute("cartProduct", cartProduct);
                Double total = dao.getTotalCartPrice(cart_list);
                request.setAttribute("tong", total);
            }
            request.setAttribute("mahoadon", mahoadon);
            request.setAttribute("maban", maban);
            request.setAttribute("trangthai", tt);
        } else {
           int mahoadon = dao.timMaHoaDon_ID(maban);
            ArrayList<CHITIETHOADON> ds = (ArrayList<CHITIETHOADON>) dao.getDoUongfromChiTiet(mahoadon);
            List<CART> cartProduct = dao.getThongTinDoUong(ds);
            HOADON hoadon = dao.getHoaDon(mahoadon);
            request.setAttribute("hd", hoadon);
            request.setAttribute("cp", cartProduct);
            request.setAttribute("mahoadon", mahoadon);
            request.setAttribute("maban", maban);
            request.setAttribute("trangthai", tt);
        }

        request.getRequestDispatcher("datmon.jsp").forward(request, response);
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
