package Salario;

import java.util.Map;
import java.util.LinkedHashMap;

public class UFC {
    protected Map<String, Funcionario> funcionarios = new LinkedHashMap<>();

    public UFC() {
    }

    public Funcionario getFuncionario(String nome) {
        return funcionarios.get(nome);
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getNome(), funcionario);
    }

    public void rmFuncionario(String nome) {
        funcionarios.remove(nome);
    }

    public void setBonus(int bonus) {
        bonus /= funcionarios.size();
        for(Funcionario funcionario : funcionarios.values()) {
            funcionario.setBonus(bonus);
        }
    }
    
    @ Override
    public String toString() {
    	String str = "";
        for(String chave : funcionarios.keySet()){
            str += funcionarios.get(chave) + "\n";
        }
        //substring vai servir para "cortar" a String
        //nesse caso, usei para tirar o \n
        return str.substring(0, str.length() - 1);
    }
}