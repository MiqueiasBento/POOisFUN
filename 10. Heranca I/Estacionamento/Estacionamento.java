package Estacionamento;

import java.util.LinkedHashMap;

public class Estacionamento {
    private LinkedHashMap<String, Veiculo> veiculos;
    private int horaAtual;
    
    public Estacionamento() {
        this.veiculos = new LinkedHashMap<>();
        this.horaAtual = 0;
    }

    // Incrementa a hora atual
    public void passarTempo(int tempo) {
        this.horaAtual += tempo;
    }

    // Estaciona o veículo no estacionamento, salva a hora de entrada
    public void estacionar(Veiculo veiculo) {
        veiculo.setEntrada(horaAtual);
        this.veiculos.put(veiculo.getId(), veiculo);
    }

    // Verifica se o veículo existe no map, verifica se não está pago e retorna comprovante de pagamento do veiculo
    public String pagar(String id) throws Exception{
        // Verificando se o veículo existe
        if(this.veiculos.get(id) == null){
            throw new Exception("fail: veiculo " + id + " nao encontrado");
        }
        
        if(this.veiculos.get(id).isPago()) {
            throw new Exception("fail: veiculo  " + id + " ja foi pago");
        }
        
        veiculos.get(id).pagar();
        return veiculos.get(id).getComprovante(this.horaAtual);
    }

    // Verifica se há algum veículo no estacionamento e retorna os comprovantes de pagamento de todos os veiculos
    public String pagarTodos() throws Exception{
        if(veiculos.size() == 0) {
            throw new Exception("fail: nenhum veiculo encontrado");
        }
        
        String out = "";
        
        for(Veiculo v : veiculos.values()) {
            v.pagar();
            out += v.getComprovante(this.horaAtual) + "\n";
        }
        
        return out;
    }

    // Verifica se o veículo existe no map, verifica se está pago e o remove
    public void sair(String id) throws Exception{
        // Verifica se está no estacionamento
        if(veiculos.get(id) == null){
            throw new Exception("fail: veiculo " + id + " nao encontrado");
        }
        
        // Verifica se já pagou
        if(!veiculos.get(id).isPago()){
            throw new Exception("fail: veiculo  " + id + " so pode sair depois de pagar");
        }
        
        veiculos.remove(id);
    }

    // Remove todos os veiculos
    public void sairTodos() throws Exception{
        if(veiculos.size() == 0) {
            throw new Exception("fail: nenhum veiculo encontrado");
        }
        this.veiculos.clear();
    }

    // Mostra a lista de veículos na ordem em que foram estacionados
    @Override
    public String toString() {
        String out = "";
        
        if(veiculos.size() > 0){
            for(Veiculo v : veiculos.values()){
                out += v.toString() + "\n";
            }
        }
        
        return out + "Hora atual: " + this.horaAtual;
    }
}
