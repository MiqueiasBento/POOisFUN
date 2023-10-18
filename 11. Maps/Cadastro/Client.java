package Cadastro;

import java.util.ArrayList;

// Classe para os clientes da agência
public class Client {
    private String clientId;
    private ArrayList<Account> accounts;

    public Client( String clientId ) {
        this.clientId = clientId;
        this.accounts = new ArrayList<>();
    }
    
    // adiciona uma conta à lista de contas do cliente
    public void addAccount( Account acc ) {
        accounts.add(acc);
    }
    
    // retorna a lista de contas do cliente
    public ArrayList<Account> getAccounts() {
    	return this.accounts;
    }
    
    // retorna o id do client
    public String getClientId() {
    	return this.clientId;
    }

    @Override
    public String toString() {
    	// retorna o nome do cliente e a lista com os ids das contas no formato
        // nome [id1, id2, ...]
    	// As contas vao está na posição 0 e 1, pois são somente duas contas (CC e CP)
    	return this.clientId + " [" + this.accounts.get(0).getAccId() 
    						 + ", " + this.accounts.get(1).getAccId() + "]\n"; 
    }
}