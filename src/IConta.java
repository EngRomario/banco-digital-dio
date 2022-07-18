
public interface IConta {
	void sacar(double valor);

	void depositar(double valor);

	void transferir(Conta contaDestino, double valor);

	void imprimirExtrato();
	@Override
	int hashCode();
	@Override
	boolean equals(Object obj);
}
