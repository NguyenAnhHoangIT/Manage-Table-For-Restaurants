/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Busisness_logic;

import Data_access.DAO;
import Entity.DANHMUC;
import Entity.DONGIA;
import Entity.DOUONG;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "menu", urlPatterns = {"/menu"})
public class menu extends HttpServlet {

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
            out.println("<title>Servlet menu</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet menu at " + request.getContextPath() + "</h1>");
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

        List<DANHMUC> dm = dao.getAllDanhMuc();
        request.setAttribute("dsdanhmuc", dm);
        request.getRequestDispatcher("menu.jsp").forward(request, response);
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
        DAO dao = new DAO();
        DONGIA mon = new DONGIA();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mon.setTuNgay(formatter.parse(request.getParameter("tungay")));
            mon.setDenNgay(formatter.parse(request.getParameter("denngay")));
            mon.setMoTa(Double.valueOf(request.getParameter("dongia")));
            mon.setMaDanhMuc_ID(Integer.valueOf(request.getParameter("danhmuc")));
            mon.setTenDoUong(request.getParameter("ten"));

            dao.insertDonGia(mon);
            dao.insertDoUong(mon);
            response.sendRedirect("menu");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while updating the transaction.");
        }
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
