import java.util.*;

public class Principal {
	//Author: Paulo Gustavo Zanese
	//MARK: Description on file "Descrição.pdf"
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		
		UrnaEletronica urna = new UrnaEletronica();
		Administrador adm = new Administrador();
		
		boolean auxSenha, sairMenuAdm, sairMenu=true, inicioVotacao=false;
		byte opcao;

		urna.tipoConta();
		byte selecao = lerTeclado.nextByte();
		
		//---------------------------------------------------------------------------
		while (sairMenu) {
			switch (selecao) {
			
			case 0: //Encerrar
				System.out.println("------------------------------");
				System.out.print("O programa foi encerrado!");
				sairMenu = false;
				
				break;
			case 1: //Administrativo
				auxSenha = urna.verificarSenha(adm);
				
			if (auxSenha) {
				sairMenuAdm = true;
					urna.administrativo(inicioVotacao);
					opcao = lerTeclado.nextByte();
					
					//---------------------------------------------------------------
					while (sairMenuAdm) {
						switch (opcao) {
						case 0: //Voltar
							urna.tipoConta();
							selecao = lerTeclado.nextByte();
							sairMenuAdm = false;
							
							break;
						case 1: //CadastroPrefeito
							if (inicioVotacao == true) { //Redirecionamento
								opcao = 7; break;}
							urna.cadastrarCandidato(opcao);
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;
						case 2: //CadastroVereador
							if (inicioVotacao == true) { //Redirecionamento
								opcao = 8; break;}
							urna.cadastrarCandidato(opcao);
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;
						case 3: //CadastroEleitor
							if (inicioVotacao == true) { //Redirecionamento
								opcao = -1; break;}
							urna.cadastrarEleitor();
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;
						case 4: //RemoverPrefeito
							if (inicioVotacao == true) { //Redirecionamento
								opcao = -1; break;}
							urna.removerPessoa(opcao);
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;	
						case 5: //RemoverVereador
							if (inicioVotacao == true) { //Redirecionamento
								opcao = -1; break;}
							urna.removerPessoa(opcao);
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;
						case 6: //RemoverEleitor
							if (inicioVotacao == true) { //Redirecionamento
								opcao = -1; break;}
							urna.removerPessoa(opcao);
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;
						case 7: //Resultados
							urna.resultado();
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;
						case 8: //NovaEleição
							if (inicioVotacao == false) { //Redirecionamento
								opcao = -1; break;}
							if (urna.novaEleicao()) 
								inicioVotacao=false;
							urna.administrativo(inicioVotacao);
							opcao = lerTeclado.nextByte();
							
							break;
						default:
							System.out.print("Opção inválida, digite uma opção:");
							opcao = lerTeclado.nextByte();
							break;
						}
					}
					//---------------------------------------------------------------
				} 
			else {
				System.out.println("\nSenha Invalida!");
				urna.tipoConta();
				selecao = lerTeclado.nextByte();
				}
				break;
			case 2: //Eleitor
				if (!inicioVotacao) {
					System.out.println("--------------------AVISO--------------------");
					System.out.println("Ao iniciar a votação, não será possível"
							+ "\nremover/inserir candidatos e eleitores.");
					System.out.println("CONFIRMA INÍCIO DE VOTAÇÃO? -- 1.SIM / 2.NÃO --");
					System.out.print("Opção: ");
					byte conf = lerTeclado.nextByte();
					
					if (conf != 1) {
						System.out.println("Votação não iniciada.");
						urna.tipoConta();
						selecao = lerTeclado.nextByte();
						break;
					}
					inicioVotacao = true;
				}
				
				boolean aux, aux2;
				Eleitor eleitor = urna.verificarEleitor();
				
				if (eleitor == null) {
					inicioVotacao = false;
					urna.tipoConta();
					selecao = lerTeclado.nextByte();
					break;
				}
				
				if (!eleitor.getVotou()) {
					System.out.println("Para voto BRANCO, digite branco.");
					if (eleitor != null) {
						do {
							aux = urna.votarPrefeito();
							eleitor.setVotar();	}
						while (!aux);
						do {
							aux2 = urna.votarVereador();
							eleitor.setVotar();}
						while (!aux2);
					}
					urna.tipoConta();
					selecao = lerTeclado.nextByte();	
				}
				else{
					System.out.println("Votação não permitida! Usuário já votou.");
					urna.tipoConta();
					selecao = lerTeclado.nextByte();}
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