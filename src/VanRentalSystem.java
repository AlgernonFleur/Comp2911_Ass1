import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class VanRentalSystem {
	
	private ArrayList<Depot> depotsList;
	
	public VanRentalSystem() {
		this.depotsList = new ArrayList<>();
	}
	
	public void parseInput(String input){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader(input));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
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
			if(scanner!=null) scanner.close();
		}
	}
	
	private void parseLocation(String[] line) {
		String depotName = line[1];
		String vanName = line[2];
		Transmission transmission = Transmission.valueOf(line[3]);
		
		boolean depotNotInList = true;
		for(Depot d:this.depotsList) {
			if (d.getDepotName().equals(depotName)) {
				d.addVan(new Van(depotName,vanName,transmission));
				depotNotInList = false;
			}
			if(!depotNotInList) break;
		}
		if(depotNotInList){
			Depot depot = new Depot(depotName);
			depot.addVan(new Van(depotName,vanName,transmission));
			this.depotsList.add(depot);
		}
		
	}
	
	private void parseRequest(String[] line) {
		int hour1 = 	Integer.parseInt(line[2]);
		Month month1 = 	Month.valueOf(line[3]);
		int day1 = 		Integer.parseInt(line[4]);
		
		int hour2 = 	Integer.parseInt(line[5]);
		Month month2 = 	Month.valueOf(line[6]);
		int day2 = 		Integer.parseInt(line[7]);
		
		TimeInterval time = new TimeInterval(hour1,month1,day1,hour2,month2,day2);
		
		int requestID = Integer.parseInt(line[1]);
		Request request = null;
		
		if(line.length==10){
			request = new Request(this.depotsList,requestID,time,
					Integer.parseInt(line[8]), Transmission.valueOf(line[9]));
		}else if(line.length==12){
			request = new Request(this.depotsList,requestID,time,
					Integer.parseInt(line[8]), Transmission.valueOf(line[9]),
					Integer.parseInt(line[10]),Transmission.valueOf(line[11]));
		}
		System.out.println(request);
	}
	
	private void parseChange(String[] line) {
		System.out.println("\t#TODO:\t"+String.join(" ",line));
	}
	
	private void parseCancel(String[] line) {
		System.out.println("\t#TODO:\t"+String.join(" ",line));
	}
	
	private void parsePrint(String[] line) {
		System.out.println("\t#TODO:\t"+String.join(" ",line));
	}
	
	private String[] cleanLine(String input){
		String trim[] = input.trim().split("\\s+");
		String uncomment[] = String.join(" ",trim).split("#");
		return uncomment[0].split("\\s+");
	}
	
	public static void main(String[] args) {
		VanRentalSystem vrs = new VanRentalSystem();
		vrs.parseInput(args[0]);
		for(Depot d:vrs.depotsList){
			System.out.println(d);
		}
	}
}
