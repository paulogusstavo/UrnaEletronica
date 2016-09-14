import java.util.*;

public class UrnaEletronica {
	
//	private ArrayList<Administrador> listaDeAdministradores = new ArrayList<Administrador>();
	private ArrayList<Candidato> listaDePrefeitos = new ArrayList<Candidato>();
	private ArrayList<Candidato> listaDeVereadores = new ArrayList<Candidato>();
	private ArrayList<Eleitor> listaDeEleitores = new ArrayList<Eleitor>();
	
	private int brancoPrefeito;
	private int brancoVereador;
	private Administrador adm;
	
	Scanner lerTeclado = new Scanner(System.in);
	
	public UrnaEletronica (Administrador adm) {
		this.adm = adm;
	}
	
//-----SET E GET--------------------------------------------------------------
	public void inserirAdministrador (Administrador a) { this.adm = a; }
	
	public void inserirPrefeito (Candidato p) { listaDePrefeitos.add(p); }
	public void inserirVereador (Candidato v) { listaDeVereadores.add(v); }
	public void inserirEleitor (Eleitor e) { listaDeEleitores.add(e); }

	public ArrayList<Candidato> getListaDePrefeitos() { return listaDePrefeitos; }
	public ArrayList<Candidato> getListaDeVereadores() { return listaDeVereadores; }
	public ArrayList<Eleitor> getListaDeEleitores() { return listaDeEleitores; }
	
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
		if (adm.getSenha() == null) {
			System.out.println("----------1º ACESSO----------");
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
	public Eleitor eleitor () {
		System.out.println("----------VOTAÇÃO----------");
		if (listaDeEleitores.size() == 0) {
			System.out.println("Nenhum eleitor cadastrado.\n");
			return null;
		} else if (listaDePrefeitos.size() == 0){
			System.out.println("Nenhum Prefeito cadastrado.\n");
			return null;
		} else if (listaDeVereadores.size() == 0) {
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
					System.out.println("Para voto BRANCO, digite branco.");
					return listaDeEleitores.get(i);
				}
				else {
					System.out.println("ZONA E/OU SEÇÃO INVÁLIDOS.");
					return null;
				}
			}
		}
		return null;
	}
//----------------------------------------------------------------------------
}