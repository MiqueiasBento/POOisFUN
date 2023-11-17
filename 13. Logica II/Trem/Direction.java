package Trem;

public enum Direction {
	IN,
	OUT;
	
	@ Override
	public String toString() {
		if(this == Direction.IN) 	return "in";
		else						return "out";
	}
}