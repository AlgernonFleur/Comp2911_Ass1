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
		System.out.println("\t#TODO:\t"+String.join(" ",line));
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
