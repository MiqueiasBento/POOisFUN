package Cadastro;

// Classe para conta Poupança
public class SavingsAccount extends Account{
	// taxa de rendimento mensal
	protected double monthlyInterest;
	
	public SavingsAccount(String clientId) {
		super(clientId, "CP");
		this.monthlyInterest = 0.01;
	}
	
	// incrementa o saldo da conta em monthlyInterest %
	@ Override
	public void updateMonthly() {
		this.balance += this.monthlyInterest * this.balance;
	}
}