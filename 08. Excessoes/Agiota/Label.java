package Agiota;

public enum Label {
	GIVE,
	TAKE,
	PLUS;
	
	public String toString(Label label) {
		switch(label) {
			case GIVE:
				return "give";
			case TAKE:
				return "take";
			case PLUS:
				return "plus";
			default:
				return "";
		}
	}
}
