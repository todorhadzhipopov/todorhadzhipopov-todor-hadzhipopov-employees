package main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TeamsProcessor {	
	public ArrayList<Team> getAllTeams(ArrayList<EmployeeRecord> employeeRecords) {
		ArrayList<Team> teams = new ArrayList<>();
		for (int i = 0; i < employeeRecords.size() - 1; i++) {
			for (int j = i + 1; j < employeeRecords.size(); j++) {
				if (employeeRecords.get(i).getProject().getProjectID()
									.equals(employeeRecords.get(j).getProject()
															.getProjectID())) {
					//Calc their work days
					long days = calcWorkDays(employeeRecords.get(i), employeeRecords.get(j));
					if (days == -1) {
						continue;
					}
					if (!haveEmpsWorkedTogether(employeeRecords.get(i).getEmpID(),
										   employeeRecords.get(j).getEmpID(), teams, days)) {
						teams.add(new Team(employeeRecords.get(i).getEmpID(),
										   employeeRecords.get(j).getEmpID(), days));					
						}					
				}
			}
		}
		return teams;
	}
	
	private long calcWorkDays(EmployeeRecord empRec1, EmployeeRecord empRec2) {
		LocalDate dateFrom1 = empRec1.getProject().getDateFrom();
		LocalDate dateFrom2 = empRec2.getProject().getDateFrom();	
		LocalDate dateTo1 = empRec1.getProject().getDateTo();
		LocalDate dateTo2 = empRec2.getProject().getDateTo();
		
		LocalDate dateFrom;
		LocalDate dateTo;
		
		if (dateFrom1.isAfter(dateTo2) || dateFrom2.isAfter(dateTo1)) {
			return -1;
		}
		
		if (dateFrom1.isAfter(dateFrom2)) {
			dateFrom = dateFrom1;
		} else {
			dateFrom = dateFrom2;
		}
		
		if (dateTo1.isBefore(dateTo2)) {
			dateTo = dateTo1;
		} else {
			dateTo = dateTo2;
		}			
		return ChronoUnit.DAYS.between(dateFrom, dateTo);			
	}
	
	private boolean haveEmpsWorkedTogether(String empID1, String empID2, List<Team> teams,
									 	   long daysToAdd) {
		if (teams.isEmpty() || teams == null) {
			return false;
		}
		for (Team t : teams) {
			if ((t.getFirstEmpID().equals(empID1) && t.getSecondEmpID().equals(empID2))
					|| (t.getFirstEmpID().equals(empID2) && t.getSecondEmpID().equals(empID1))) {
				
				t.setCommonWorkDays(t.getCommonWorkDays() + daysToAdd);
				return true;			
			}
		}
		return false;
	}
	
	public Team findTopTeam(ArrayList<Team> teams) {
		if (teams == null || teams.isEmpty()) {
			return null;
		}
		Team topTeam = teams.get(0);
		for(int i = 1; i < teams.size(); i++) {
			if(teams.get(i).getCommonWorkDays() > topTeam.getCommonWorkDays()) {
				topTeam = teams.get(i);
			}
		}		
		return topTeam;
	}
}

