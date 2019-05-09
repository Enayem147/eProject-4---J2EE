/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import Model.ManageNews;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "updatenews", urlPatterns = {"/updatenews"})
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class updatenews extends HttpServlet {

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

            String filename1 = "";
            String filename2 = "";
            Date date = new Date();
            /*
             Goi session bean de lay gia tri cityid
             */
            /*
             Lay gia tri tu nguoi dung
             */
            int newId = 0;
            if (request.getParameter("txtNewsID") != null) {
                newId = Integer.parseInt(request.getParameter("txtNewsID"));
            }

            String introduction = "";
            if (request.getParameter("txtIntro") != null) {
                introduction = request.getParameter("txtIntro");
            }

            String title = "";
            if (request.getParameter("txtTitle") != null) {
                title = request.getParameter("txtTitle");
            }

            String description1 = "";
            if (request.getParameter("txtDecription1") != null) {
                description1 = request.getParameter("txtDecription1");
            }

            Part file = request.getPart("image1");
            //obtains file name
            filename1 = file.getSubmittedFileName();
            InputStream input = file.getInputStream();
            FileOutputStream output = new FileOutputStream("E:\\test\\RDTH\\RDTH-war\\web\\resources\\images\\" + filename1);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = input.read(buf)) > 0) {
                output.write(buf, 0, len);
            }

            String description2 = "";
            if (request.getParameter("txtDecription2") != null) {
                description2 = request.getParameter("txtDecription2");
            }

            Part file2 = request.getPart("image2");
            //obtains file name
            filename2 = file2.getSubmittedFileName();
            InputStream input2 = file.getInputStream();
            FileOutputStream output2 = new FileOutputStream("E:\\test\\RDTH\\RDTH-war\\web\\resources\\images\\" + filename2);
            byte[] buf2 = new byte[1024];
            int len2 = 0;
            while ((len = input.read(buf)) > 0) {
                output.write(buf, 0, len);
            }

            String postname = "";
            if (request.getParameter("txtPost") != null) {
                postname = request.getParameter("txtPost");
            }

            /*
             Khoi tao instance class ManageCity.java
             */
            
            ManageNews m = new ManageNews();
            if (m.update(newId, introduction, title, description1, filename1, description2, filename2, postname, new Timestamp(date.getTime()))) {
                RequestDispatcher dis = request.getRequestDispatcher("List_News.jsp");
                dis.forward(request, response);
            }
        } finally {
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
