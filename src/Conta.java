import java.util.Objects;

public abstract class Conta implements IConta {
	private static int SEQUENCIAL = 1;

	protected Agencia agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Agencia agencia, Cliente cliente) {
		this.agencia = agencia;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		agencia.getBanco().addConta(this);

	}

	public Agencia getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		if (saldo >= valor)
			saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia.getId()));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia.getBanco(), cliente);
	}

	@Override
	public boolean equals(Object obj) {
		Conta outro = (Conta) obj;
		if (obj != null && obj.getClass() == getClass()) {
			if (Objects.equals(agencia.getBanco(), outro.agencia.getBanco())
					&& Objects.equals(cliente, outro.cliente)) {
				System.out.println(String.format("O cliente %s já tem esse tipo de conta registrada no %s.",
						cliente.getNome(), agencia.getBanco().getNome()));
				return true;
			}
			;
		}
		return false;
	}

}
