import java.util.*;
import java.util.ArrayList;

public class UrnaEletronica {
	private String senhaMaster;
	private int brancoPrefeito;
	private int brancoVereador;
	
	ArrayList<Eleitor> listaDeEleitores = new ArrayList<Eleitor>();
	ArrayList<Prefeito> listaDePrefeitos = new ArrayList<Prefeito>();
	ArrayList<Vereador> listaDeVereadores = new ArrayList<Vereador>();
		
//-----SET E GET--------------------------------------------------------------	
	public void addBrancoPrefeito () { brancoPrefeito++; }
	public int getBrancoPrefeito () { return brancoPrefeito; }
	
	public void addBrancoVereador () { brancoVereador++; }
	public int getBrancoVereador () { return brancoVereador; }
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
		System.out.println("1.Cadastro de Prefeito");
		System.out.println("2.Cadastro de Vereador");
		System.out.println("3.Cadastro de Eleitor");
		System.out.println("4.Resultados");
		System.out.println("\n0.Voltar");
		System.out.print("Opção:");
	}
//----------------------------------------------------------------------------
	public boolean verificaSenha () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		if (this.senhaMaster == null) {
			System.out.println("----------1º ACESSO----------");
			System.out.print("Informe uma senha: ");
			this.senhaMaster = lerTeclado.nextLine();
			return true;
		}
		else {
			System.out.print("Digite sua senha: ");
			String senhaTemp = lerTeclado.nextLine();
			if(senhaMaster.equals(senhaTemp)) {
				return true;
			} else {
				return false; }
		}
	}
//----------------------------------------------------------------------------
	public void resultado () {
		System.out.println("----------RESULTADO FINAL----------");
		System.out.println(">>> PREFEITOS");
		if (listaDePrefeitos.size() == 0)
			System.out.println("Nenhum prefeito cadastrado.\n");
		else {
			for (int i=0; i<listaDePrefeitos.size();i++) {
			System.out.println((i+1) + "." + listaDePrefeitos.get(i).getNome() 
					+ " - Votos: " + listaDePrefeitos.get(i).getVotos());
			}
			System.out.println("\nVotos BRANCOS: " + getBrancoPrefeito());
		}
		System.out.println("\n>>> VEREADORES");
		if (listaDeVereadores.size() == 0)
			System.out.println("Nenhum vereador cadastrado.\n");
		else {
			for (int z=0; z<listaDeVereadores.size();z++) {
			System.out.println((z+1) + "." + listaDeVereadores.get(z).getNome() 
					+ " - Votos: " + listaDeVereadores.get(z).getVotos());
			}
			System.out.println("\nVotos BRANCOS: " + getBrancoVereador());
		}
		
	}
//----------------------------------------------------------------------------
	public void eleitor () {
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
				if (listaDeEleitores.get(i).getZona() == zona 
						&& listaDeEleitores.get(i).getSecao() == secao) {
					System.out.println("\nOlá, " + listaDeEleitores.get(i).getNome() + ".\n");
					System.out.println("Para voto BRANCO, digite branco.");
					System.out.print("Número do Prefeito: ");
					String userVoto = lerTeclado.next();
//TODO: Votação para Vereador.
					if (userVoto.equals("branco")) {
						addBrancoPrefeito();
						continue;
					}
					for (int j=0; j<listaDePrefeitos.size();j++) {
						if (listaDePrefeitos.get(j).getNumeroVotacao().equals(userVoto)) {
							listaDePrefeitos.get(j).adicionaVotos();
							System.out.println("\n-------VOTAÇÃO REALIZADA COM SUCESSO!-------\n");
							return;
						}
						
					}
					System.out.println("\nCANDIDATO NÃO ENCONTRADO.");
				}
				else {
					System.out.println("ZONA E/OU SEÇÃO INVÁLIDOS.");
				}
			}
		}
	}
//----------------------------------------------------------------------------
	public void cadastroPrefeito () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------CADASTRO PREFEITO----------");
		System.out.print("Nome: ");
		String nomePrefeito = lerTeclado.nextLine();
		System.out.print("Número de votação: ");
		String votPrefeito = lerTeclado.nextLine();
		
		Prefeito p = new Prefeito(nomePrefeito, votPrefeito);
		listaDePrefeitos.add(p);
		System.out.println("\nCandidato cadastrado com sucesso!");
	}
//----------------------------------------------------------------------------
	public void cadastroVereador () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------CADASTRO VEREADOR----------");
		System.out.print("Nome: ");
		String nomeVereador = lerTeclado.nextLine();
		System.out.print("Número de votação: ");
		String votVereador = lerTeclado.nextLine();
		
		Vereador v = new Vereador(nomeVereador, votVereador);
		listaDeVereadores.add(v);
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