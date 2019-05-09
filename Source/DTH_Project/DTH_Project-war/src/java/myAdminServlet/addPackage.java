/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myAdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myModel.PackageModel;

/**
 *
 * @author r0cklee147
 */
@WebServlet(name = "addPackage", urlPatterns = {"/addPackage"})
public class addPackage extends HttpServlet {

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

            String pack_id = request.getParameter("txtPackageID");
            String pack_name = request.getParameter("txtPackageName");
            int set_id = Integer.parseInt(request.getParameter("dlSetupBox"));
            double price = Double.parseDouble(request.getParameter("txtPrice"));
            String description = request.getParameter("txtDescription");
            double discount = Double.parseDouble(request.getParameter("txtDiscount"));

            PackageModel packmodel = new PackageModel();

            if (packmodel.checkExist(pack_id)) {
                request.setAttribute("exist", "<script>alert('Package ID exists  !');</script>");
                RequestDispatcher dis = request.getRequestDispatcher("admin_page/Package_Add.jsp");
                dis.forward(request, response);
            } else {
                packmodel.add(pack_id, pack_name, set_id, price, description, discount);
                RequestDispatcher dis = request.getRequestDispatcher("admin_page/Package_List.jsp");
                dis.forward(request, response);
            }

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
        processRequest(request, response);
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
