package com.loloconsult.storebay.servlet;

import com.loloconsult.storebay.service.Service;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Laurent
 * Date: 28/04/13
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name="serviceServlet", urlPatterns={"/ServiceServlet"})
public class ServiceServlet extends HttpServlet {

    @EJB
    private Service service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServiceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + service.saluer() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Ma servlet de test";
    }
}
