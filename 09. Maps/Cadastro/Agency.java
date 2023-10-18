package Cadastro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Agency {
    private Map<Integer, Account> accounts;
    private Map<String, Client> clients;

    public Agency() {
        this.accounts = new HashMap<Integer,Account>();
        // this.clients = new HashMap<String,Client>();
        this.clients = new LinkedHashMap<String,Client>();
    }
    
    
    // Retorna a conta de acordo com o Id passado
    private Account getAccount(int accountId) throws Exception {
    	// O "containsKey" retorna se a chave esta no mapa
    	if(!this.accounts.containsKey(accountId)) {
    		throw new Exception("fail: conta nao encontrada");
    	}
    	
    	return this.accounts.get(accountId);
    }
    
    // cria uma conta para o cliente
    // cria um objeto cliente e insere no mapa de clientes
    // cria uma conta corrente e uma conta poupança e insere no mapa de contas
    // faz o vínculo cruzado colocando as contas dentro do objeto do cliente
    public void addClient(String clientId) {
    	Client c = new Client(clientId);
    	this.clients.put(clientId, c);
    	
    	Account cc = new CheckingAccount(clientId);
    	Account cp = new SavingsAccount(clientId);
    	this.accounts.put(cc.getAccId(), cc);
    	this.accounts.put(cp.getAccId(), cp);
    	
    	c.addAccount(cc);
    	c.addAccount(cp);
    }

    // procura pela conta usando o getAccount e realiza a operação de depósito
    // utiliza o método deposit da classe Account
    public void deposit(int accId, double value) throws Exception{
    	this.getAccount(accId).deposit(value);
    }

    // procura pela conta e realiza a operação de saque
    // utiliza o método withdraw da classe Account
    public void withdraw(int accId, double value) throws Exception{
    	this.getAccount(accId).withdraw(value);
    }

    // procura pela conta e realiza a operação de transferência
    // utiliza o método transfer da classe Account
    public void transfer(int fromAccId, int toAccId, double value)  throws Exception{
    	getAccount(fromAccId).transfer(this.getAccount(toAccId), value);
    }

    // realiza a operação de atualização mensal em todas as contas
    public void updateMonthly() {
    	for(Account acc : this.accounts.values()) {
    		acc.updateMonthly();
    	}
    }

    @Override
    public String toString() {
        String out = "- Clients\n";
        for ( Client client : this.clients.values() ) {
            out += client;
        }
        out += "- Accounts\n";
        for ( Account acc : this.accounts.values() ) {
            out += acc;
        }
        return out;
    }
}