import java.util.Objects;

public class Agencia {
	private int id;
	private Banco banco;

	public Agencia(Banco banco, int id) {
		this.banco = banco;
		this.id = id;
		banco.addAgencia(this);
	}

	public int getId() {
		return id;
	}

	public Banco getBanco() {
		return banco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(banco, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Agencia outro = (Agencia) obj;
			if (Objects.equals(banco, outro.getBanco()) && Objects.equals(id, outro.getId())) {
				System.out.println(String.format("A agência %d já está registrada no %s.", id, banco.getNome()));
				return true;
			}
		}
		return false;
	}
}
