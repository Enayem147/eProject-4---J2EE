/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myModel.CustomerModel;
import myModel.PackageInvoiceModel;
import myModel.PackageModel;

/**
 *
 * @author r0cklee147
 */
@WebServlet(name = "orderPackage", urlPatterns = {"/orderPackage"})
public class orderPackage extends HttpServlet {

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
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String date1 = format.format(date);

            HttpSession session = request.getSession();
            String cus_id = String.valueOf(session.getAttribute("login"));
            String pack_id = request.getParameter("pack_id");
            double totalprice = Double.parseDouble(request.getParameter("total"));
            int month = Integer.parseInt(request.getParameter("month"));

            CustomerModel model = new CustomerModel();

            double wallet = model.getWallet(cus_id);
            String cus_name = model.getCustomerName(cus_id);

            PackageModel pack = new PackageModel();
            PackageInvoiceModel invoiceModel = new PackageInvoiceModel();
            boolean ok = invoiceModel.addPackageSubscribeDetail(pack_id, cus_id, date1, month);
            if (ok) {
                String str = pack.createInvoice(pack_id, totalprice, wallet, cus_name, date1, month);
                request.setAttribute("invoice", str);
                RequestDispatcher dis = request.getRequestDispatcher("PackageInvoice.jsp");
                dis.forward(request, response);
            }
            

//            out.print(cus_id + "     " + pack_id + "     " + totalprice + "    " + wallet + "   " + cus_name + "     " + date1+ "          "+month);
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
