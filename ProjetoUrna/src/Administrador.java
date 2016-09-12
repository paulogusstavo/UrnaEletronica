import java.util.Scanner;

public class Administrador {
	
	private String senhaMaster;
	
	Scanner lerTeclado = new Scanner(System.in);
	
//-----SET E GET---------------------------------------------------------	
	public String getSenha () { return senhaMaster; }
	public void setSenha (String senha) { senha = senhaMaster; }
//-----------------------------------------------------------------------		
	public Candidato cadastroCandidadto (byte tipo) {
		if (tipo == 1) { //Prefeito
			System.out.println("----------CADASTRO PREFEITO----------");
			System.out.print("Nome: ");
			String nomePrefeito = lerTeclado.nextLine();
			System.out.print("Número de votação: ");
			String votPrefeito = lerTeclado.nextLine();
			
			Candidato p = new Candidato(nomePrefeito, votPrefeito);
			System.out.println("\nCandidato cadastrado com sucesso!");
			return p;
		} else if (tipo == 2) { //Vereador
			System.out.println("----------CADASTRO VEREADOR----------");
			System.out.print("Nome: ");
			String nomeVereador = lerTeclado.nextLine();
			System.out.print("Número de votação: ");
			String votVereador = lerTeclado.nextLine();
			
			Candidato v = new Candidato(nomeVereador, votVereador);
			System.out.println("\nCandidato cadastrado com sucesso!");
			return v;
		}
		return null;
	}
//-----------------------------------------------------------------------	
	public Eleitor cadastroEleitor () {
		System.out.println("----------CADASTRO ELEITORES----------");
		System.out.print("Nome: ");
		String nome = lerTeclado.nextLine();
		System.out.print("ZONA: ");
		int zona = lerTeclado.nextInt();
		System.out.print("SEÇÃO: ");
		int secao = lerTeclado.nextInt();
		
		Eleitor e = new Eleitor(nome, zona, secao);
		System.out.println("\nEleitor cadastrado com sucesso!");
		return e;
	}
//-----------------------------------------------------------------------	
}