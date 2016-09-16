import java.util.*;

public class UrnaEletronica {
	
	private ArrayList<Candidato> listaDePrefeitos = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaDeVereadores = new ArrayList<Candidato>();
	private ArrayList<Eleitor> listaDeEleitores = new ArrayList<Eleitor>();
	
	private int brancoPrefeito;
	private int brancoVereador;
	
//-----SET E GET---------------------------------------------------------------------------	
	public ArrayList<Candidato> getListaDePrefeitos() { return listaDePrefeitos; }
	public ArrayList<Candidato> getListaDeVereadores() { return listaDeVereadores; }
	public ArrayList<Eleitor> getListaDeEleitores() { return listaDeEleitores; }
	
	public void addBrancoPrefeito () { brancoPrefeito++; }
	public int getBrancoPrefeito () { return brancoPrefeito; }
	
	public void addBrancoVereador () { brancoVereador++; }
	public int getBrancoVereador () { return brancoVereador; }
//-----------------------------------------------------------------------------------------
	public void tipoConta () {
		System.out.println("----------SELECIONE A CONTA----------");
		System.out.println("1.Adminstrador");
		System.out.println("2.Eleitor");
		System.out.println("\n0.Encerrar");
		System.out.print("Opção:");
}
//-----------------------------------------------------------------------------------------
	public void administrativo () {
		System.out.println("----------ADMINISTRADOR----------");
		System.out.println("1.Cadastro de Prefeito");
		System.out.println("2.Cadastro de Vereador");
		System.out.println("3.Cadastro de Eleitor");
		System.out.println("4.Resultados");
		System.out.println("\n0.Voltar");
		System.out.print("Opção:");
	}
//-----------------------------------------------------------------------------------------
	public boolean verificaSenha (Administrador adm) {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		if (adm.getSenha() == null) {
			System.out.println("--------------1º ACESSO--------------");
			System.out.print("Informe uma senha: ");
			String senha = lerTeclado.nextLine();
			adm.setSenha(senha);
			return true;
		}
		else {
			System.out.print("Digite sua senha: ");
			String senhaTemp = lerTeclado.nextLine();
			if(adm.getSenha().equals(senhaTemp)) {
				return true;
			} else {
				return false; }
		}
	} 
//-----------------------------------------------------------------------------------------
	public void cadastroCandidadto (byte tipo) {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		if (tipo == 1) { //Prefeito
			System.out.println("----------CADASTRO PREFEITO----------");
			System.out.print("Nome: ");
			String nomePrefeito = lerTeclado.nextLine();
			System.out.print("Partido: ");
			String partidoPrefeito = lerTeclado.nextLine();
			System.out.print("Número de votação: ");
			String votPrefeito = lerTeclado.nextLine();
			
			Candidato p = new Candidato(nomePrefeito, votPrefeito, partidoPrefeito);
			listaDePrefeitos.add(p);
			System.out.println("\nCandidato cadastrado com sucesso!");
		} else if (tipo == 2) { //Vereador
			System.out.println("----------CADASTRO VEREADOR----------");
			System.out.print("Nome: ");
			String nomeVereador = lerTeclado.nextLine();
			System.out.print("Partido: ");
			String partidoVereador = lerTeclado.nextLine();
			System.out.print("Número de votação: ");
			String votVereador = lerTeclado.nextLine();
			
			Candidato v = new Candidato(nomeVereador, votVereador, partidoVereador);
			listaDeVereadores.add(v);
			System.out.println("\nCandidato cadastrado com sucesso!");
		}
	}
//-----------------------------------------------------------------------------------------	
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
//-----------------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------------------
	public boolean votarPrefeito () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println(">>>Prefeito");
		System.out.print("Número do candidato: ");
		String userVoto = lerTeclado.next();

		if (userVoto.equals("branco")) {
			System.out.println("Confirma voto BRANCO? -- 1.SIM / 2.CORRIGE --");
			System.out.print("Opção: ");
			byte confirmacao = lerTeclado.nextByte();
			if (confirmacao == 1) {
				addBrancoPrefeito();
				return true;
			}
			else if (confirmacao == 2)
				votarPrefeito();
		}
		
		for (int j=0; j<listaDePrefeitos.size();j++) {
			if (listaDePrefeitos.get(j).getNumeroVotacao().equals(userVoto)) {
				System.out.println("Candidato: " + listaDePrefeitos.get(j).getNome() + " - " + listaDePrefeitos.get(j).getPartido());
				System.out.println("Confirma VOTO? -- 1.SIM / 2.CORRIGE --");
				System.out.print("Opção: ");
				byte confirmacao = lerTeclado.nextByte();
				if (confirmacao == 1) {
					listaDePrefeitos.get(j).adicionaVotos();
					return true;
				}
				else
					votarPrefeito();
				
				return true;
			}
			
		}
		System.out.println("\nCANDIDATO NÃO ENCONTRADO.");
		return false;
	}
	
//-----------------------------------------------------------------------------------------
	public boolean votarVereador () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		
		System.out.println(">>>Vereador");
		System.out.print("Número do candidato: ");
		String userVoto = lerTeclado.next();
		
		if (userVoto.equals("branco")) {
			System.out.println("Confirma voto BRANCO? -- 1.SIM / 2.CORRIGE --");
			System.out.print("Opção: ");
			byte confirmacao = lerTeclado.nextByte();
			if (confirmacao == 1) {
				addBrancoVereador();
				System.out.println("\n-------VOTAÇÃO REALIZADA COM SUCESSO!-------\n");
				return true;
			}
			else if (confirmacao == 2)
				votarVereador();
		}
		
		for (int j=0; j<listaDeVereadores.size();j++) {
			if (listaDeVereadores.get(j).getNumeroVotacao().equals(userVoto)) {
				System.out.println("Candidato: " + listaDeVereadores.get(j).getNome() + " - " + listaDeVereadores.get(j).getPartido());
				System.out.println("Confirma VOTO? -- 1.SIM / 2.CORRIGE --");
				System.out.print("Opção: ");
				byte confirmacao = lerTeclado.nextByte();
				if (confirmacao == 1) {
					listaDeVereadores.get(j).adicionaVotos();
					return true;
				}
				else
					votarVereador();
				
				return true;
			}
		}
		System.out.println("\nCANDIDATO NÃO ENCONTRADO.");
		return false;
	}
//-----------------------------------------------------------------------------------------
	public Eleitor eleitor () {
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		System.out.println("----------VOTAÇÃO----------");
		if (listaDeEleitores.isEmpty()) {
			System.out.println("Nenhum eleitor cadastrado.\n");
			return null;
		} else if (listaDePrefeitos.isEmpty()){
			System.out.println("Nenhum Prefeito cadastrado.\n");
			return null;
		} else if (listaDeVereadores.isEmpty()) {
			System.out.println("Nenhum Vereador cadastrado.\n");
			return null;
		}
		else {
			System.out.print("ZONA de votação: ");
			int zona = lerTeclado.nextInt();
			System.out.print("SEÇÃO de votação: ");
			int secao = lerTeclado.nextInt();
			
			for (int i=0; i<listaDeEleitores.size();) {
				if (listaDeEleitores.get(i).getZona() == zona 
						&& listaDeEleitores.get(i).getSecao() == secao) {
					System.out.println("\nOlá, " + listaDeEleitores.get(i).getNome() + ".\n");
					return listaDeEleitores.get(i);
				}
				else {
					System.out.println("\nZONA E/OU SEÇÃO INVÁLIDOS.");
					return null;
				}
			}
		}
		return null;
	}
//-----------------------------------------------------------------------------------------
}