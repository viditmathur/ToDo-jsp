package classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String Uname = request.getParameter("uname");
		String Password = request.getParameter("password");
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con;
			ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG336;database=ToDo";
				String user = "vidit";
				ArrayList<Login> Logindetails = new ArrayList<Login>();
				con = DriverManager.getConnection(dbURL, user, "password");
				if (con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Login where username = '" + Uname + "'";
					rs = stmt.executeQuery(query5);
					while (rs.next()) {
						Logindetails.add(new Login(rs.getString("username"), rs.getString("password")));
					}
					if (Uname.equals(Logindetails.get(0).getUsername())) {
						if (Password.equals(Logindetails.get(0).getPassword())) {
							HttpSession session = request.getSession(true);
							session.setAttribute("username", Uname);
							response.sendRedirect("Member.jsp");
						}
					} else {
						response.sendRedirect("Error.jsp");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception c) {
			c.printStackTrace();
		}

	}

}
