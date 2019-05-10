package classes.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import classes.Tasks;
public class Task_controller {

	
	ArrayList<Tasks> TasksList ;
	public Task_controller() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public ArrayList<Tasks> gettodo(String username) throws ClassNotFoundException{
		try {
			
		       
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con;
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG336;database=ToDo";
				String user = "vidit";
				ArrayList<Tasks> taskslist=new ArrayList<Tasks>();
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Tasks where Username = '"+username+"'";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						taskslist.add(new Tasks(rs.getInt("s_no"),rs.getString("task_name"),rs.getString("Description"),rs.getString("Username"),rs.getString("Status"))); 
					}
				return	taskslist;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		catch(Exception c){
			c.printStackTrace();
			return null;
		}
		return null;
			
		}

	public List<Tasks> getTasksList() {
		return this.TasksList;
	}

	public void setTasksList(ArrayList<Tasks> tasksList) {
		this.TasksList = tasksList;
	}
	 
	public int size() {
		return this.TasksList.size();
	}
	
}
