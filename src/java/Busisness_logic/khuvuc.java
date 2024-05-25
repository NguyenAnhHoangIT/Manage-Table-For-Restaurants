package Busisness_logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Data_access.DAO;
import Entity.BAN;
import Entity.KHUVUC;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/khuvuc"})
public class khuvuc extends HttpServlet {

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
            out.println("<title>Servlet khuvuc</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet khuvuc at " + request.getContextPath() + "</h1>");
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
        //Lay danh sach khu vuc
        List<KHUVUC> dskv = dao.getAllKhuVuc();
        request.setAttribute("dskhuvuc", dskv);
        //Lay danh sach cac ban tuong ung voi so khu vuc
        List<List> danhsach = new ArrayList<>();
        for (KHUVUC kv : dskv) {
            List<BAN> dsb = dao.getBanTheoKhu(kv.getMaKhuVuc_ID());
            danhsach.add(dsb);
        }

        request.setAttribute("dsbantheokhu", danhsach);
        request.getRequestDispatcher("khuvuc.jsp").forward(request, response);
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
        KHUVUC k = new KHUVUC();
        BAN b = new BAN();
        try {
            k.setTenKhuVuc(request.getParameter("tenkhuvuc"));
            k.setMoTa(request.getParameter("motakhuvuc"));

            b.setTenBan(request.getParameter("tenban"));
            String check = request.getParameter("khuvuc");
            if (check == null) {
                int i = 0;
                b.setMaKhuVuc_ID(i);
            } else {
                b.setMaKhuVuc_ID(Integer.valueOf(request.getParameter("khuvuc")));
            }
            b.setMoTa(request.getParameter("motaban"));
            if (k == null || k.getTenKhuVuc() == null || k.getTenKhuVuc().isEmpty()) {
                dao.insertBan(b);
            } else {
                dao.insertKhuVuc(k);
            }
            response.sendRedirect("khuvuc");
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
