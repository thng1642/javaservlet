package timetable;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import timetable.TimeTable;
/**
 * Servlet implementation class TimetableServlet
 */
@WebServlet("/TimetableServlet")
public class TimetableServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public TimetableServlet() {
    //    super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String url = "/profile.jsp";
		String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String dbUsername = "root";
        String dbPassword = "thng1642";
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception ex) {
			// handler exception
			System.out.println(ex.getMessage());
		};
		try {
			conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			String queryGetIdClass = "select namesubject, T2.room, T2.time, T2.day\r\n"
					+ "from subject inner join \r\n"
					+ "	(select idclass,room, subject_idsubject as id, T1.time, T1.day\r\n"
					+ "	from class inner join timetable T1 \r\n"
					+ "				on class.idclass = T1.class_idclass) T2\r\n"
					+ "			on T2.id = subject.idsubject\r\n"
					+ "where T2.idclass in (select idclass from class\r\n"
					+ "		where idclass in \r\n"
					+ "			(select class_idclass\r\n"
					+ "			from study\r\n"
					+ "			where student_mssv = ?))";
			PreparedStatement getIdClass = conn.prepareStatement(queryGetIdClass);
			getIdClass.setString(1, "19110296");
			ResultSet results = getIdClass.executeQuery();
			
			 // get response writer
	        //PrintWriter writer = response.getWriter();
	        // build HTML code
	        //String htmlRespone = "<html>";
	        ArrayList<TimeTable> MyTimeTable = new ArrayList<TimeTable>();
			while (results.next()) {
				
				TimeTable tmp = new TimeTable(results.getString(1), results.getString(3), results.getString(2), results.getString(4));
				MyTimeTable.add(tmp);
				
		        //htmlRespone += "<h2>"+ results.getString(1) +"</h2>";      
		        //htmlRespone += "<h2>"+ results.getString(2)+"</h2>";    
		      
			} 
			request.setAttribute("MyTimeTable", MyTimeTable);
			//htmlRespone += "</html>";	        
	        // return response
	        //writer.println(htmlRespone);
	        
			conn.close();
			getIdClass.close();
			getServletContext().getRequestDispatcher(url).forward(request, response);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
			
	}

}
