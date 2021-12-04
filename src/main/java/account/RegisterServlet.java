package account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public RegisterServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mssv = request.getParameter("mssv");
		String cccd = request.getParameter("cccd");
		String major = request.getParameter("major");
		String phone = request.getParameter("phone");
		String name = request.getParameter("full-name");
		String email = request.getParameter("email");
		String pass = request.getParameter("fw-password");
		
		// get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is:" + email +"<br/>";      
        htmlRespone += "Your password is: "+ pass + "</h2>";
        htmlRespone += "<h2>cccd/cmnd:"+ cccd +"</h2>";
        htmlRespone += "<h2>mssv:"+ mssv +"</h2>";
        htmlRespone += "<h2>fullname:"+ name +"</h2>";
        htmlRespone += "<h2>phong:"+ phone+"</h2>";
        htmlRespone += "<h2>major:"+ major+"</h2>";
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
	}

}
