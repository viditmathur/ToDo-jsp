package classes;

public class Tasks {

	

	public Tasks() {
		super();
	}
	int s_no;
	String task_name;
	String Description;
	String Username;
	String Status;

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	public Tasks(int s_no, String task_name, String description, String username, String status) {
		super();
		this.s_no = s_no;
		this.task_name = task_name;
		Description = description;
		Username = username;
		Status = status;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
