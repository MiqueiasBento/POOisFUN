package Estacionamento;

public class Carro extends Veiculo{
    public Carro(String id){
        super(id, "Carro");
    }
    
    @ Override
    public double calcularValor(int horaSaida) {
        // Para o velor não ficar negativo, por conta da subtração
        double val = Math.abs((double) (horaSaida - this.getEntrada()) / 10);
        
        if (val < 5){
            return 5.00;
        } else {
            return val;
        }
    }
}