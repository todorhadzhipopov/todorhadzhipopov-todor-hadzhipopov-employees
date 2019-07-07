package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class EmployeesFileReader {
	private static final String FILE_PATH = "employees_records.txt";
	private static final String COMMA_SEPARATOR = ",";
	
	public ArrayList<EmployeeRecord> read() {
		ArrayList<EmployeeRecord> records = new ArrayList<>();
	
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			String[] record;
		
			while ((line = br.readLine()) != null) {
				record = line.split(COMMA_SEPARATOR);
				if (record.length == 4) {
					records.add(new EmployeeRecord(record[0].trim(), 
								new ProjectDetails(record[1].trim(), record[2].trim(),
												   record[3].trim())));
				}
			}
			return records;
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();	
		}
		return records;
	}
}