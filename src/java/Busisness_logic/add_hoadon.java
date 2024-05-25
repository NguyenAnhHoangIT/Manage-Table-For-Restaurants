/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Busisness_logic;

import Entity.CHITIETHOADON;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
@WebServlet(name = "add_hoadon", urlPatterns = {"/add_hoadon"})
public class add_hoadon extends HttpServlet {

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
            out.println("<title>Servlet add_hoadon</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add_hoadon at " + request.getContextPath() + "</h1>");
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
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));

            int maban = Integer.parseInt(request.getParameter("maban"));
            String trangthai = request.getParameter("trangthai");

            HttpSession session = request.getSession();
            ArrayList<CHITIETHOADON> cartList = new ArrayList<>();
            ArrayList<CHITIETHOADON> cart_list = (ArrayList<CHITIETHOADON>) session.getAttribute("douong_list");
            if (cart_list == null) {
                CHITIETHOADON c = new CHITIETHOADON();
                c.setMaDoUong_ID(id);
                c.setSoLuong(1);
                cartList.add(c);
                session.setAttribute("douong_list", cartList);
            } else {
                cartList = cart_list;
                boolean exist = false;

                for (CHITIETHOADON d : cart_list) {
                    if (d.getMaDoUong_ID() == id) {
                        exist = true;
                        int quantity = d.getSoLuong();
                        quantity++;
                        d.setSoLuong(quantity);
                        break;
                    }
                }
                if (!exist) {
                    CHITIETHOADON c = new CHITIETHOADON();
                    c.setMaDoUong_ID(id);
                    c.setSoLuong(1);
                    cartList.add(c);
                }
            }
            response.sendRedirect("datmon?id=" + maban + "&trangthai=" + trangthai);
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
