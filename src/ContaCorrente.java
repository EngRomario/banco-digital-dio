import java.util.Objects;

public class ContaCorrente extends Conta {

	public ContaCorrente(Agencia agencia, Cliente cliente) {
		super(agencia, cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	@Override
	public boolean equals(Object obj) {
		Conta outro = (Conta) obj;
		if (obj != null && obj.getClass() == getClass()) {
			if (Objects.equals(agencia.getBanco(), outro.agencia.getBanco())
					&& Objects.equals(cliente, outro.cliente)) {
				System.out.println(String.format("O cliente %s já possui Conta Corrente registrada no %s.",
						cliente.getNome(), agencia.getBanco().getNome()));
				return true;
			}
			;
		}
		return false;
	}
}
