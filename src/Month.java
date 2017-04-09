public enum Month {
	Jan(1),Feb(2),Mar(3),Apr(4),May(5),Jun(6),
	Jul(7),Aug(8),Sep(9),Oct(10),Nov(11),Dec(12);
	
	private final int value;
	
	Month(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static void main(String[] args) {
		String m = "Jan";
		Month month = Month.valueOf(m);
		System.out.println(month.getValue());
		System.out.println(month.name());
		System.out.println(month.toString());
		System.out.println(month.ordinal());
	}
}
