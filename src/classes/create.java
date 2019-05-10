package classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class create
 */
@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create() {
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
		String task_name = request.getParameter("task_name");
		String Description = request.getParameter("description");
		String Username = session.getAttribute("username").toString();
		String Status = request.getParameter("status");
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
					String query5 = "insert into Tasks values(" + s_no + ",'" + task_name + "','"+ Description + "','"+ Username + "','"+Status+"'); select * from Tasks;";
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
