package Estacionamento;

public class Bike extends Veiculo{
    public Bike(String id){
        super(id, "Bike");
    }
    
    @ Override
    public double calcularValor(int horaSaida) {
        return 3.00;
    }
}
