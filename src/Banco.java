import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Banco {
	private String nome;
	private Collection<Agencia> agencias = new LinkedHashSet<>();
	private Collection<Conta> contas = new LinkedHashSet<>();

	public Banco(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Collection<Agencia> getAgencias() {
		return agencias;
	}

	public void addAgencia(Agencia agencia) {
		this.agencias.add(agencia);
	}

	public Collection<Conta> getContas() {
		return contas;
	}

	public boolean addConta(Conta conta) {
		return this.contas.add(conta);
	}

	public void removeConta(Conta conta) {
		this.contas.remove(conta);
	}

	public void imprimirContas() {
		Iterator<Conta> itr = contas.iterator();
		while (itr.hasNext())
			itr.next().imprimirExtrato();
	}
	
	public void imprimirAgencias() {
		Iterator<Agencia> itr = agencias.iterator();
		while (itr.hasNext())
			System.out.println(itr.next().getId());
	}

}
