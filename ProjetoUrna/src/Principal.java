import java.util.*;

public class Principal {
		
	public static void main(String[] args) 
	{	
		@SuppressWarnings("resource")
		
		Scanner lerTeclado = new Scanner(System.in);
		
		UrnaEletronica urna = new UrnaEletronica(null);
		Administrador adm = new Administrador(urna);
	//	Eleitor eleitor = new Eleitor();

		
		boolean sair=true, sair2=true;
		byte opcao;

		urna.tipoConta();
		byte selecao = lerTeclado.nextByte();
		
		//---------------------------------------------------------------------------
		while (sair) {
			switch (selecao) {
			
			case 0: //Encerrar
				System.out.println("------------------------------");
				System.out.print("O programa foi encerrado!");
				sair = false;
				
				break;
			case 1: //Administrativo
			//	auxSenha = urna.verificaSenha();
				
			//	if (auxSenha) {
					sair2 = true;
					urna.administrativo();
					opcao = lerTeclado.nextByte();
					
					//---------------------------------------------------------------
					while (sair2) {
						switch (opcao) {
						case 0: //Voltar
							urna.tipoConta();
							selecao = lerTeclado.nextByte();
							sair2 = false;
							
							break;
						case 1: //CadastroPrefeito
							urna.inserirPrefeito(adm.cadastroCandidadto(opcao));
							urna.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						case 2: //CadastroVereador
							urna.inserirVereador(adm.cadastroCandidadto(opcao));
							urna.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						case 3: //CadastroEleitor
							urna.inserirEleitor(adm.cadastroEleitor());
							urna.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						case 4: //Resultados
							urna.resultado();
							urna.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						default:
							System.out.print("Opção inválida, digite uma opção:");
							opcao = lerTeclado.nextByte();
							break;
						}
					}
					//---------------------------------------------------------------
				//} 
			//else {
			//	System.out.println("\nSenha Invalida!");
			//	urna.tipoConta();
			//	selecao = lerTeclado.nextByte();
			//	}
			//	break;
			case 2: //Eleitor
				boolean aux, aux2;
				Eleitor eleitor = urna.eleitor();
				
				if (eleitor != null) {
					do {
						aux = eleitor.votarPrefeito(); }
					while (!aux);
					do {
						aux2 = eleitor.votarVereador(); }
					while (!aux2);
				}
				urna.tipoConta();
				selecao = lerTeclado.nextByte();
				break;
				
			default: 
				System.out.print("Opção inválida, digite uma opção:");
				selecao = lerTeclado.nextByte();
				break;
			}
		}
		//---------------------------------------------------------------------------
	}
}