public enum Transmission {
	Automatic,Manual;
	
	public static void main(String[] args) {
		for(Transmission t:Transmission.values()){
			System.out.println(t.toString());
		}
	}
}
