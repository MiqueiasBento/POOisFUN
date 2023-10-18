package Cadastro;

import java.text.DecimalFormat;

// Classe para criar a conta para o cliente
public abstract class Account {
    protected double balance;
    private static int nextAccountId = 0;
    protected int accId;
    protected String clientId;
    protected String typeId;

    public Account( String clientId, String typeId ) {
    	this.clientId = clientId;
    	this.typeId = typeId;
    	this.balance = 0;
    	this.accId = nextAccountId++;
    }

    public void deposit( double value ) {
    	this.balance += value;
    }

    public void withdraw( double value ) throws Exception {
    	if(value > this.balance) {
    		throw new Exception("fail: saldo insuficiente");
    	}
    	
    	this.balance -= value;
    }

    public void transfer( Account other, double value ) throws Exception{
    	this.withdraw(value);
    	other.deposit(value);
    }


    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00"); //double x = 4.3; System.out.println( d.format(x) ); //4.30
        return this.accId + ":" + this.clientId 
				 		  + ":" + d.format(this.balance)
				 		  + ":" + this.typeId + "\n";
    }

    public double getBalance() {
		return balance;
    }
    public int getAccId() {
		return accId;
    }
    public String getClientId() {
		return clientId;
    }
    public String getTypeId() {
		return typeId;
    }
    // método abstrato que realiza a atualização mensal da conta
    // o método deve ser implementado nas subclasses
    public abstract void updateMonthly();
}