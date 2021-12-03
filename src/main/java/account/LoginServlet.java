package account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import account.User;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("accountName");
        String password = request.getParameter("passString");
        // String name = request.getParameter("name");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        // System.out.println("name:" + name);
 
        // do some processing here...
        //String url = "/profile.jsp";
        String url = "/TimetableServlet";
        //load driver
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception ex) {
			// handler exception
			System.out.println(ex.getMessage());
		};
		Connection conn = null;
		try {
			
			String dbURL = "jdbc:mysql://localhost:3306/mydb";
	        String dbUsername = "root";
	        String dbPassword = "thng1642";
			conn  = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			//do something here
			String StrQuery = "SELECT password FROM account where name = ?";
			PreparedStatement PsPassword = conn.prepareStatement(StrQuery);
			PsPassword.setString(1, username);
			ResultSet ResultPass= PsPassword.executeQuery();
			
			if (ResultPass.next()) {

				// compare string pass user input and pass in database
				if (password.equals(ResultPass.getString(1))) {		
					// get mssv from database
					String QueryMssv = "select mssv from student where account_name = ?";
					PreparedStatement PsMssv = conn.prepareStatement(QueryMssv);
					PsMssv.setString(1, username);
					ResultSet ResultMssv = PsMssv.executeQuery();
					// sent mssv here
					if (ResultMssv.next()) {
						String id = ResultMssv.getString(1);
						User user = new User(id, username);
						request.setAttribute("user",user);
					}
					conn.close();
					PsPassword.close();
					PsMssv.close();			
				}	
			}
		}
		catch (SQLException e) {
			// handle any errors
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		};
	getServletContext().getRequestDispatcher(url).forward(request, response);	
    }
 
}