package Lapiseira;

public class Lead {
	private float calibre;
	private String dureza;
	private int tamanho;
	
	public Lead(float espessura, String dureza, int tamanho) {
		super();
		this.calibre = espessura;
		this.dureza = dureza;
		this.tamanho = tamanho;
	}

	public float getCalibre() {
		return calibre;
	}

	public void setCalibre(float calibre) {
		this.calibre = calibre;
	}

	public String getDureza() {
		return dureza;
	}

	public void setDureza(String dureza) {
		this.dureza = dureza;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int usagePerSheet() {
		if("HB".equals(getDureza())) {
			return 1; 
		} else if("2B".equals(getDureza())) {
			return 2; 
		} else if("4B".equals(getDureza())) {
			return 4; 
		} else if("6B".equals(getDureza())) {
			return 6; 
		} else {
			return 0;	
		}
	}
	
	@Override
	public String toString() {
		return "[" 
				+ String.format("%.1f", calibre) 
				+ ":" + dureza 
				+ ":" + tamanho
				+ "]";
	}
}