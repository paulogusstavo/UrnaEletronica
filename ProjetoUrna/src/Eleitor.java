import java.util.Scanner;

public class Eleitor {
	
	private String nome;
	private int zona;
	private int secao;
	private UrnaEletronica urna;

	Scanner lerTeclado = new Scanner(System.in);

//-----Construtor-------------------------------------------------------------
	public Eleitor (String nome, int zona, int secao, UrnaEletronica urna) {
		this.urna = urna;
		this.nome = nome;
		this.zona = zona;
		this.secao = secao;
	}
//-----GET E SET--------------------------------------------------------------
	public String getNome () { return nome; }
	public int getZona () { return zona; }
	public int getSecao () { return secao; }
//----------------------------------------------------------------------------
	public boolean votarPrefeito () {
		System.out.println(">>>Prefeito");
		System.out.print("Número do candidato: ");
		String userVoto = lerTeclado.next();

		if (userVoto.equals("branco")) {
			urna.addBrancoPrefeito();
			return true;
		}
		
		for (int j=0; j<urna.getListaDePrefeitos().size();j++) {
			if (urna.getListaDePrefeitos().get(j).getNumeroVotacao().equals(userVoto)) {
				urna.getListaDePrefeitos().get(j).adicionaVotos();
				return true;
			}
			
		}
		System.out.println("\nCANDIDATO NÃO ENCONTRADO.");
		return false;
	}
	
//----------------------------------------------------------------------------
	public boolean votarVereador () {
		//@SuppressWarnings("resource")
		
		System.out.println(">>>Vereador");
		System.out.print("Número do candidato: ");
		String userVoto = lerTeclado.next();
		
		if (userVoto.equals("branco")) {
			urna.addBrancoVereador();
			System.out.println("\n-------VOTAÇÃO REALIZADA COM SUCESSO!-------\n");
			return true;
		}
		
		for (int j=0; j<urna.getListaDeVereadores().size();j++) {
			if (urna.getListaDeVereadores().get(j).getNumeroVotacao().equals(userVoto)) {
				urna.getListaDeVereadores().get(j).adicionaVotos();
				System.out.println("\n-------VOTAÇÃO REALIZADA COM SUCESSO!-------\n");
				return true;
			}
		}
		System.out.println("\nCANDIDATO NÃO ENCONTRADO.");
		return false;
	}

}