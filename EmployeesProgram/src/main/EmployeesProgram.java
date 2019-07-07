package main;

import java.util.ArrayList;

public class EmployeesProgram {
	public static void main(String args[]) {
		EmployeesFileReader fr = new EmployeesFileReader();
		ArrayList<EmployeeRecord> records = fr.read();
		TeamsProcessor tp = new TeamsProcessor();
		Team topTeam = tp.findTopTeam(tp.getAllTeams(records));
		
		if (topTeam != null) {
			System.out.println("Longest work team: ");
			System.out.println(topTeam);
		} else {
			System.out.println("No top team found");
		}			
	}
}









