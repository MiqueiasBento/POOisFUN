package Trem;

public class Movimento {
	private String idPass;
	private Direction direcao;
	
	public Movimento(String idPass, Direction direcao) {
		this.idPass = idPass;
		this.direcao = direcao;
	}
	
	public String getIdPass() {
		return idPass;
	}
	
	@ Override
	public String toString() {
		return this.idPass + " " + this.direcao;
	}
}