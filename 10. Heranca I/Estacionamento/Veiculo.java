package Estacionamento;

public abstract class Veiculo {
    protected String id; //id será o nome do dono da bike ou a placa do carro/moto
    protected String tipo;
    protected int horaEntrada;
    protected boolean pago;

    public Veiculo( String id, String tipo ) {
        this.id = id;
        this.tipo = tipo;
        this.horaEntrada = 0;
        this.pago = false;
    }

    // Retorna o valor a ser pago
    public abstract double calcularValor( int horaSaida );

    // Retorna comprovante de pagamento
    public String getComprovante( int horaSaida ) {
        return this.tipo + " chegou " + this.horaEntrada 
        		+ " saiu" + horaSaida
        		+ ".Pagar R$ " + String.format("%.2f", calcularValor( horaSaida ));
    }

    @Override
    public String toString() {
    	String out = "";
    	
    	out += String.format("%10s-:-", this.tipo).replace(' ', '_').replace('-', ' ');
    	out += String.format("%10s-:-", this.id).replace(' ', '_').replace('-', ' ');
    	out += String.format("%-2d", this.horaEntrada).replace(' ', '_').replace('-', ' ');
    	
    	return out;
    }
    
    // Getters e Setters
    public void setEntrada(int horaEntrada){
        this.horaEntrada = horaEntrada;
    }
    
    public int getEntrada(){
        return this.horaEntrada;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getId(){
        return this.id;
    }
    
    public boolean isPago(){
        return (this.pago ? true : false);
    }
    
    public void pagar(){
        this.pago = true;
    }
}