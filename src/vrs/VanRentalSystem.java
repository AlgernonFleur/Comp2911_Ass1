package vrs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class VanRentalSystem {
	
	public void parseInput(String input){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader(input));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			parseScannedFile(scanner);
			if(scanner!=null) scanner.close();
		}
	}
	
	private void parseScannedFile(Scanner scanner){
		while(scanner.hasNext()){
			String[] line = cleanLine(scanner.nextLine());
			switch (line[0]){
				case("Location"):	parseLocation(line);break;
				case("Request"):	parseRequest(line);	break;
				case("Change"):		parseChange(line);	break;
				case("Cancel"):		parseCancel(line);	break;
				case("Print"):		parsePrint(line);	break;
			}
		}
	}
	
	private void parseLocation(String[] line) {
	}
	
	private void parseRequest(String[] line) {
	}
	
	private void parseChange(String[] line) {
	}
	
	private void parseCancel(String[] line) {
	}
	
	private void parsePrint(String[] line) {
	}
	
	
	private String[] cleanLine(String input){
		String trimmedLine[] = input.trim().split("\\s+");
		String uncommentLine[] = String.join(" ",trimmedLine).split("#");
		return uncommentLine[0].split("\\s+");
	}
	
	public static void main(String[] args) {
		VanRentalSystem vrs = new VanRentalSystem();
		
	}
}
