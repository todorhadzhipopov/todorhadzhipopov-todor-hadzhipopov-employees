package main;

import java.text.ParseException;
import java.time.LocalDate;

public class ProjectDetails {
	private final static String NULL_STRING = "NULL";
	private String projectID;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	public ProjectDetails(String projectID, String dateFrom, String dateTo) 
													throws ParseException {
		this.projectID = projectID;
		if (dateFrom.equals(NULL_STRING)) {
			this.dateFrom = LocalDate.now();
		}
		else {
			this.dateFrom = LocalDate.parse(dateFrom);
		}
		
		if (dateTo.equals(NULL_STRING)) {
			this.dateTo = LocalDate.now();
		}
		else {
			this.dateTo = LocalDate.parse(dateTo);
		}	
	}
	
	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}		
}
