package tarifas;

public enum Label {
	DEPOSIT,
	FEE,
	OPENING,
	REVERSE,
	WITHDRAW;
	
	@ Override
	public String toString() {
		switch(this) {
			case DEPOSIT:
				return "deposit";
			case FEE:
				return "fee";
			case OPENING:
				return "opening";
			case REVERSE:
				return "reverse";
			case WITHDRAW:
				return "withdraw";
			default:
				return "";
		}
	}
}