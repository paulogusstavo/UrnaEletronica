import java.util.*;

public class Principal {

	public static void main(String[] args) {

		Scanner lerTeclado = new Scanner(System.in);
		
		Biblioteca bibli = new Biblioteca();
		
		System.out.println("--------------SELECIONE UMA OPÇÃO--------------");
		System.out.println("1.Cadastro de aluno");
		System.out.println("2.Cadastro de professor");
		System.out.println("3.Alunos Cadastrados");
		System.out.println("4.Professores Cadastrados");
		System.out.println("\n0. Sair");
		System.out.print("Opção: ");
		byte opcao = lerTeclado.nextByte();
		boolean sair = true;
		//----------------------------------------------------------------------
			while (sair) {
			switch (opcao) {
				case 0: 
					System.out.println("----------O PROGRAMA FOI ENCERRADO----------");
					sair = false;
					break;
				case 1: 
					System.out.println("----------CADASTRO DE ALUNO----------");
					System.out.print("Nome: ");
					String nomeAluno = lerTeclado.next();
					System.out.print("Código: ");
					int codigoAluno = lerTeclado.nextInt();
					
					Aluno a = new Aluno(nomeAluno, codigoAluno);
					bibli.cadastrarAluno(a);
					
					System.out.print("Informe uma opção: '");
					opcao = lerTeclado.nextByte();
					
					break;
					
				case 2: 
					System.out.println("----------CADASTRO DE PROFESSOR----------");
					System.out.print("Nome: ");
					String nomeProf = lerTeclado.next();
					System.out.print("Código: ");
					int codigoProf = lerTeclado.nextInt();
					
					Professor p = new Professor(nomeProf, codigoProf);
					bibli.cadastrarProfessor(p);
					
					System.out.print("Informe uma opção: '");
					opcao = lerTeclado.nextByte();
					
					break;
					
				case 3:
					for (int i=0; i<bibli.getAlunos().size(); i++) {
						System.out.println(bibli.getAlunos().get(i).getNome() + " - " + bibli.getProfessores().get(i).getCodigo());
					}
					
					System.out.print("Informe uma opção: '");
					opcao = lerTeclado.nextByte();
					break;
					
				case 4:
					for (int i=0; i<bibli.getAlunos().size(); i++) {
						System.out.println(bibli.getAlunos().get(i).getNome() + " - " + bibli.getProfessores().get(i).getCodigo());
					}
					System.out.print("Informe uma opção: '");
					opcao = lerTeclado.nextByte();
					break;
				}
			}
		//----------------------------------------------------------------------
	}

}