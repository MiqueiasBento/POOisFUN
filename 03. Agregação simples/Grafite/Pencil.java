package Grafite;

public class Pencil {
    private float espessura;
	private Lead tipo;
	
	public Pencil(float espessura) {
		super();
		this.espessura = espessura;
		this.tipo = null;
	}
	
	public float getEspessura() {
		return espessura;
	}

	public void setEspessura(float espessura) {
		this.espessura = espessura;
	}

	public Lead getTipo() {
		return tipo;
	}

	public void setTipo(Lead tipo) {
		this.tipo = tipo;
	}

	public boolean hasGrafite(){
		if(tipo != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void insert(Lead lead) {
		if(!hasGrafite()) {
			if(lead.getEspessura() == this.getEspessura()) {
				tipo = lead;
			} else {
				System.out.println("fail: calibre incompativel");
			}
		} else {
			System.out.println("fail: ja existe grafite");
		}
	}
	
	public void remove() {
		if(hasGrafite()) {
			setTipo(null);
		}
	}
	
	public void writePage() {
		if(hasGrafite()) {
			if(tipo.getTamanho() > 10) {
				if((tipo.getTamanho() -  tipo.usagePerSheet()) >= 10) {
					tipo.setTamanho(tipo.getTamanho() - tipo.usagePerSheet());
				} else {
				    tipo.setTamanho(10);
					System.out.println("fail: folha incompleta");
				}
			} else {
				System.out.println("fail: tamanho insuficiente");
			}
		} else {
			System.out.println("fail: nao existe grafite");
		}
		
	}

	@Override
	public String toString() {
		return "calibre: " + espessura
				+ ", grafite: " + tipo;
	}
}
