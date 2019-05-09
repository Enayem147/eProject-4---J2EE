/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import Model.ManageEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import ntd.mySessionbeanLocal;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "addevent", urlPatterns = {"/addevent"})
@MultipartConfig(maxFileSize = 16177215)
public class addevent extends HttpServlet {

    @EJB
    private mySessionbeanLocal mySessionbean;

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
        PrintWriter out = response.getWriter();
        try {
            String filename = "";

            String eventname = "";
            if (request.getParameter("txtEventName") != null) {
                eventname = request.getParameter("txtEventName");
            }

            String description = "";
            if (request.getParameter("txtDecription") != null) {
                description = request.getParameter("txtDecription");
            }
            
            String datestart = "";
            if (request.getParameter("txtStart") != null) {
                datestart = request.getParameter("txtStart");
            }

            String dateend = "";
            if (request.getParameter("txtEnd") != null) {
                dateend = request.getParameter("txtEnd");
            }

            Part file = request.getPart("image");
            //obtains file name
            filename = file.getSubmittedFileName();
            InputStream input = file.getInputStream();
            FileOutputStream output = new FileOutputStream("E:\\test\\RDTH\\RDTH-war\\web\\resources\\images\\" + filename);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = input.read(buf)) > 0) {
                output.write(buf, 0, len);
            }

            

            String reward = "";
            int re = 0;
            if (request.getParameter("dlReward") != null) {
                re = Integer.parseInt(request.getParameter("dlReward"));
            }
            if (re == 1) {
                reward = "";
            } else if (re == 2) {
                reward = "Discount 10%";
            } else if (re == 3) {
                reward = "Discount 20%";
            } else if (re == 4) {
                reward = "Discount 30%";
            } else if (re == 5) {
                reward = "Discount 50%";
            }
            
                int id = mySessionbean.getEventid();
                ManageEvent m = new ManageEvent();
                if (m.add(id + 1, eventname, description, filename, new Timestamp(Timestamp.parse(datestart)), new Timestamp(Timestamp.parse(dateend)), reward)) {
                    RequestDispatcher dis = request.getRequestDispatcher("List_Event.jsp");
                    dis.forward(request, response);
                }

            }finally {
            out.close();
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
