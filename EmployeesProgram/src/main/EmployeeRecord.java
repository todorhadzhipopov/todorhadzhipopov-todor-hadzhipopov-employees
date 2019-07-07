package main;

public class EmployeeRecord {
	private String empID;
	private ProjectDetails project;
	
	public EmployeeRecord(String empID, ProjectDetails project) {
		this.empID = empID;
		this.project = project;
	}
	
	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public ProjectDetails getProject() {
		return project;
	}

	public void setProject(ProjectDetails project) {
		this.project = project;
	}
}
