package GatewayServlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import beans.*;
import ctrl.Ctrl;
import wrk.Wrk;

/**
 *
 * @author gamberal01
 */
@WebServlet(name = "GatewayServlet", urlPatterns = {"/GatewayServlet"})
public class GatewayServlet extends HttpServlet {

    Ctrl ctrl;
    Wrk wrk;

    public void init() {
        wrk = new Wrk();
        ctrl = new Ctrl(wrk);
    }

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GatewayServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GatewayServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("application/json;c harset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        String result = "{}";
        switch (action) {
            case "getToutAvis":
                result = ctrl.getTousAvis();
                break;
            case "getFilms":
                result = ctrl.getFilms(Integer.parseInt(request.getParameter("PAGE")));
                break;
            case "getAvis":
                result = ctrl.getAvis(Integer.parseInt(request.getParameter("IDFILM")));
                break;
            default:
                break;
        }
        out.println(result);
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
        
        
        HttpSession session = request.getSession();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = "{\"result\": false}";
        switch (request.getParameter("action")) {

            case "addAvis":
//                if (session.getAttribute("login") == null) {
//                    response.sendError(401, "You are not logged in");
//                    break;
//                }
                String avis = request.getParameter("AVIS");
                System.out.println(avis);
                int idFilm = 0;

                idFilm = Integer.parseInt(request.getParameter("IDFILM"));
                System.out.println(idFilm);
                int pkUser = 0;
                pkUser = Integer.parseInt(request.getParameter("PKUSER"));
                System.out.println(pkUser);
                result = ctrl.addAvis(avis, idFilm, pkUser);
                System.out.println(result);
                break;
            case "login":
                if (ctrl.login(username, password)) {
                    result = "{\"result\": true}";
                    session.setAttribute("login", username);
                }
                break;
            case "":

            default:
                break;
        }
        out.println(result);
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