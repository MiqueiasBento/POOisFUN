package Estacionamento;

public class Moto extends Veiculo{
    public Moto(String id){
        super(id, "Moto");
    }
    
    @ Override
    public double calcularValor(int horaSaida) {
        // Para o velor não ficar negativo, por conta da subtração
        return Math.abs((double) (horaSaida - this.getEntrada()) / 20);
    }
}