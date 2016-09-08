import java.util.*;
import java.util.ArrayList;

public class Impressao {
	
	ArrayList<Eleitor> listaDeEleitores = new ArrayList<Eleitor>();
	ArrayList<Candidato> listaDeCandidatos = new ArrayList<Candidato>();

//----------------------------------------------------------------------------
	public void tipoConta () {
		System.out.println("----------SELECIONE O TIPO DE CONTA----------");
		System.out.println("1.Adminstrador");
		System.out.println("2.Eleitor");
		System.out.println("0.Encerrar");
		System.out.print("\nOpção:");
}
//----------------------------------------------------------------------------	
	public void administrativo () {
		System.out.println("----------ADMINISTRADOR----------");
		System.out.println("1.Cadastro de Candidato");
		System.out.println("2.Cadastro de Eleitor");
		System.out.println("3.Resultados");
		System.out.println("0.Voltar");
		System.out.print("\nOpção:");
	}
//----------------------------------------------------------------------------
	public void senhaInvalida () {
		System.out.println("----------SENHA INVÁLIDA----------");
		System.out.println("Digite 0 para cancelar.");
		System.out.print("Digite sua senha:");
	}
//----------------------------------------------------------------------------
	public void eleitor () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------VOTAÇÃO----------");
		System.out.print("ZONA de votação: ");
		int zona = lerTeclado.nextInt();
		System.out.print("SEÇÃO de votação: ");
		int secao = lerTeclado.nextInt();
		
		for (int i=0; i<listaDeEleitores.size();i++) {
			if (listaDeEleitores.get(i).getZona() == zona && listaDeEleitores.get(i).getSecao() == secao) {
				System.out.println("----------DADOS ACEITOS----------");
				System.out.print("Número do candidato: ");
				int num = lerTeclado.nextInt();
				for (int j=0; j<listaDeCandidatos.size();j++) {
					if (listaDeCandidatos.get(i).getNumeroVotacao() == num) {
						listaDeCandidatos.get(i).adicionaVotos();
						System.out.println("----------VOTAÇÃO REALIZADA COM SUCESSO!----------");
					}
					else {
						System.out.println("Candidato não encontrado!");
					}
				}
			}
			else {
				System.out.println("ZONA E/OU SEÇÃO INVÁLIDOS.");
			}
		}
		
		System.out.println("");
	}
//----------------------------------------------------------------------------
	public void cadastroCandidato () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------CADASTRO CANDIDATO----------");
		System.out.print("Nome: ");
		String nome = lerTeclado.nextLine();
		System.out.print("Número de votação: ");
		int votacao = lerTeclado.nextInt();
		
		Candidato c = new Candidato(nome, votacao);
		listaDeCandidatos.add(c);
		System.out.println("\nCandidato cadastrado com sucesso!");
	}
//----------------------------------------------------------------------------
	public void cadastroEleitor () {
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
		System.out.println("\nEleitor cadastrado com sucesso!");
	}
//----------------------------------------------------------------------------
}