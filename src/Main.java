public class Main {

	public static void main(String[] args) {
		Banco BB = new Banco("BB");

		System.out.println("----------TESTE 1----------");
		Agencia gyn = new Agencia(BB, 4);
		Agencia pitu = new Agencia(BB, 4);

		pitu = new Agencia(BB, 14);
		Cliente venilton = new Cliente("Venilton");

		System.out.println("----------TESTE 2----------");
		Conta cc = new ContaCorrente(gyn, venilton);
		Conta cc2 = new ContaCorrente(pitu, venilton);
		
		System.out.println("----------TESTE 3----------");
		Conta poupanca = new ContaPoupanca(gyn, venilton);
		Conta poupanca2 = new ContaPoupanca(pitu, venilton);

		System.out.println("----------TESTE 4----------");
		BB.imprimirContas();
		
		System.out.println("----------TESTE 5----------");
		BB.imprimirAgencias();
 
		System.out.println("----------TESTE 6----------");
		cc.depositar(450);
		cc.transferir(poupanca, 300);
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}
}
