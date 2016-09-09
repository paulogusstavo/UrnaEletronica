import java.util.*;

public class Principal {

	public static void main(String[] args) 
	{	
		@SuppressWarnings("resource")
		
		Scanner lerTeclado = new Scanner(System.in);
		UrnaEletronica menu = new UrnaEletronica();
		
		boolean auxSenha, sair=true, sair2=true;
		byte opcao;

		menu.tipoConta();
		byte selecao = lerTeclado.nextByte();
		
		//---------------------------------------------------------------------------
		while (sair) {
			switch (selecao) 
			{
			case 0: //Encerrar
				System.out.println("------------------------------");
				System.out.print("O programa foi encerrado!");
				sair = false;
				break;
			case 1: //Administrativo
				auxSenha = menu.verificaSenha();
				
				if (auxSenha) {
					sair2 = true;
					menu.administrativo();
					opcao = lerTeclado.nextByte();
					
					//---------------------------------------------------------------
					while (sair2) {
						switch (opcao) {
						case 0: //Voltar
							menu.tipoConta();
							selecao = lerTeclado.nextByte();
							sair2 = false;
							
							break;
						case 1: //CadastroPrefeito
							menu.cadastroPrefeito();
							menu.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						case 2: //CadastroVereador
							menu.cadastroVereador();
							menu.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						case 3: //CadastroEleitor
							menu.cadastroEleitor();
							menu.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						case 4: //Resultados
							menu.resultado();
							menu.administrativo();
							opcao = lerTeclado.nextByte();
							
							break;
						default:
							System.out.print("Opção inválida, digite uma opção:");
							opcao = lerTeclado.nextByte();
							break;
						}
					}
					//---------------------------------------------------------------
				} else {
				System.out.println("\nSenha Invalida!");
				menu.tipoConta();
				selecao = lerTeclado.nextByte();
				}
				break;
			case 2: //Eleitor
				boolean aux, aux2;
				if (menu.eleitor()) {
					do {
						aux = menu.votarPrefeito(); }
					while (!aux);
					do {
						aux2 = menu.votarVereador(); }
					while (!aux2);
				}
				menu.tipoConta();
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