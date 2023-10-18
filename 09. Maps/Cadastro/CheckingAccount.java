package Cadastro;

// Classe para conta Corrente
public class CheckingAccount extends Account{
	// taxa de manutenção da conta
	protected double monthlyFee;
	
	public CheckingAccount(String clientId) {
		super(clientId, "CC");
		this.monthlyFee = 20.0;
	}
	
	@ Override
	public void updateMonthly() {
		this.balance -= this.monthlyFee;	// decrementa o saldo da conta em monthlyFee
	}
}