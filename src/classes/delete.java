package classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("Member.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(true);
		int s_no =Integer.parseInt(request.getParameter("s_no"));
		String Username = session.getAttribute("username").toString();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG336;database=ToDo";
				String user = "vidit";
				boolean rs;
				con = DriverManager.getConnection(dbURL, user, "password");
				if (con != null) {
					Statement stmt = con.createStatement();
					String query5 = "delete from Tasks where s_no="+ s_no + "and Username='"+ Username + "';";
					rs= stmt.execute(query5);
					response.sendRedirect("Member.jsp");
				}
				else {
					System.out.println("Database Connectivity issue");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception c) {
			c.printStackTrace();
		}

	
	}

}
