import java.util.*;
import java.util.ArrayList;

public class Impressao {
	
	ArrayList<Eleitor> listaDeEleitores = new ArrayList<Eleitor>();
	ArrayList<Candidato> listaDeCandidatos = new ArrayList<Candidato>();

//----------------------------------------------------------------------------
	public void tipoConta () {
		System.out.println("----------SELECIONE A CONTA----------");
		System.out.println("1.Adminstrador");
		System.out.println("2.Eleitor");
		System.out.println("\n0.Encerrar");
		System.out.print("Opção:");
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
	public void resultado () {
		System.out.println("----------RESULTADO FINAL----------");
		if (listaDeCandidatos.size() == 0)
			System.out.println("Nenhum candidato cadastrado.\n");
		else
			for (int i=0; i<listaDeCandidatos.size();i++) {
			System.out.println((i+1) + "." + listaDeCandidatos.get(i).getNome() + " - Votos: " + listaDeCandidatos.get(i).getVotos());
			}
	}
//----------------------------------------------------------------------------
	public void eleitor () 
	{
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------VOTAÇÃO----------");
		if (listaDeEleitores.size() == 0)
			System.out.println("Nenhum eleitor cadastrado.\n");
		else {
			System.out.print("ZONA de votação: ");
			int zona = lerTeclado.nextInt();
			System.out.print("SEÇÃO de votação: ");
			int secao = lerTeclado.nextInt();
			
			for (int i=0; i<listaDeEleitores.size();i++) {
				if (listaDeEleitores.get(i).getZona() == zona && listaDeEleitores.get(i).getSecao() == secao) {
					System.out.println("\nDADOS ACEITOS");
					System.out.print("Número do candidato: ");
					int num = lerTeclado.nextInt();
					
					for (int j=0; j<listaDeCandidatos.size();j++) {
						if (listaDeCandidatos.get(j).getNumeroVotacao() == num) {
							listaDeCandidatos.get(j).adicionaVotos();
							System.out.println("\n-------VOTAÇÃO REALIZADA COM SUCESSO!-------\n");
							continue;
						}
					}
				}
				else {
					System.out.println("ZONA E/OU SEÇÃO INVÁLIDOS.");
				}
			}
		}
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