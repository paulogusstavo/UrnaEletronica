import java.util.*;

public class Principal {

	public static void main(String[] args) 
	{	
		@SuppressWarnings("resource")
		
		Scanner lerTeclado = new Scanner(System.in);
		Impressao menu = new Impressao();
		
		boolean sair=true, sair2=true;
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
				/*	System.out.print("Digite sua senha:");
				int senhaTemp = lerTeclado.nextInt();
				
				if (urna.checarSenha(senhaTemp)) { */
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
							
						case 1: //CadastroCandidato
							menu.cadastroCandidato();
							menu.administrativo();
							opcao = lerTeclado.nextByte();
							break;

						case 2: //CadastroEleitos
							menu.cadastroEleitor();
							menu.administrativo();
							opcao = lerTeclado.nextByte();
							break;
							
						case 3: //Resultados
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
				//}
			/*	else {
					//TODO: Senha invalida.
					menu.senhaInvalida();
					senhaTemp = lerTeclado.nextInt();
					if (senhaTemp == 0)
						selecao = 0;
				} */
				break;
			case 2: //Eleitor
				menu.eleitor();
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