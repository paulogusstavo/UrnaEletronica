import java.util.*;

public class Impressao {

//----------------------------------------------------------------------------
	public void tipoConta () {
		System.out.println("----------SELECIONE O TIPO DE CONTA----------");
		System.out.println("1.Adminstrativo");
		System.out.println("2.Usuário");
		System.out.println("0.Encerrar");
		System.out.print("\nOpção:");
}
//----------------------------------------------------------------------------	
	public void administrativo () {
		System.out.println("----------ADMINISTRATIVO----------");
		System.out.println("1.Cadastro de Candidato");
		System.out.println("2.Cadastro de Eleitor");
		System.out.println("3.Relatório");
		System.out.println("0.Voltar");
		System.out.print("\nOpção:");
	}
//----------------------------------------------------------------------------
	public void usuario () {
		System.out.println("----------VOTAÇÃO----------");
		System.out.print("Informe a zona de votação:");
		System.out.print("Informe a seccao de votação:");
		System.out.println("");
	}
//----------------------------------------------------------------------------
	public void senhaInvalida () {
		System.out.println("----------SENHA INVÁLIDA----------");
		System.out.println("Digite 0 para cancelar.");
		System.out.print("Digite sua senha:");
	}
//----------------------------------------------------------------------------
	public void cadastroCandidato () {
		ArrayList<Candidato> listaDeCandidatos = new ArrayList<>(100);
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------CADASTRO CANDIDATO----------");
		System.out.print("Nome: ");
		String nome = lerTeclado.nextLine();
		System.out.print("Número de votação: ");
		int votacao = lerTeclado.nextInt();
		
		Candidato c = new Candidato(nome, votacao);
		listaDeCandidatos.add(c);
		System.out.println("Candidato cadastrado com sucesso!");
	}
//----------------------------------------------------------------------------
	public void cadastroEleitor () {
		ArrayList<Eleitor> listaDeEleitores = new ArrayList<>(100);
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------CADASTRO ELEITORES----------");
		System.out.print("Nome: ");
		String nome = lerTeclado.nextLine();
		System.out.print("ZONA: ");
		int zona = lerTeclado.nextInt();
		System.out.print("SEÇÃO: ");
		int secao = lerTeclado.nextInt();
		
		Eleitor e = new Eleitor(nome, zona, secao);
		listaDeEleitores.add(e);
		System.out.println("Eleitor cadastrado com sucesso!");
	}
//----------------------------------------------------------------------------
}