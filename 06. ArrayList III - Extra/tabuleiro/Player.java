package tabuleiro;

public class Player {
	private int label;
	private int pos;
	private boolean free;
	
	public Player(int label) {
		this.label = label;
		free = true;
	}
	
	public boolean isFree() {
		if(free) {
			return true;
		} else {
			return false;
		}
	}

	public int getLabel() {
		return label;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void setFree(boolean free) {
		this.free = free;
	}
}
