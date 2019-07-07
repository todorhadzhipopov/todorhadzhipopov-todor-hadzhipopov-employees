package main;

public class Team {
	private String firstEmpID;
	private String secondEmpID;
	private long commonWorkDays;
	
	public Team(String firstEmpID, String secondEmpID, long commonWorkDays) {
		super();
		this.firstEmpID = firstEmpID;
		this.secondEmpID = secondEmpID;
		this.commonWorkDays = commonWorkDays;
	}

	public String getFirstEmpID() {
		return firstEmpID;
	}

	public void setFirstEmpID(String firstEmpID) {
		this.firstEmpID = firstEmpID;
	}

	public String getSecondEmpID() {
		return secondEmpID;
	}

	public void setSecondEmpID(String secondEmpID) {
		this.secondEmpID = secondEmpID;
	}

	public long getCommonWorkDays() {
		return commonWorkDays;
	}

	public void setCommonWorkDays(long commonWorkDays) {
		this.commonWorkDays = commonWorkDays;
	}
	
	@Override
	public String toString() {
		return "Employees " + firstEmpID + " and " + secondEmpID
				+ " has worked " + commonWorkDays + " days together.";
	}
}
