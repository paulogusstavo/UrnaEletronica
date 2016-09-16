import java.util.*;

public class DadosCadastrais {

	public static void main(String[] args) {

		ArrayList<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
		
		@SuppressWarnings("resource")
		Scanner lerTeclado = new Scanner(System.in);
		byte selecao;
//-------------------------------------------------------------------------
		do{
		System.out.print("Informe seu nome: ");
		String nome = lerTeclado.next();
		System.out.print("Informe seu email: ");
		String email = lerTeclado.next();
		
		Pessoa p = new Pessoa(nome, email);
		listaDePessoas.add(p);
		
		System.out.println("----------Usuário cadastrado----------");
		System.out.println("Cadastrar novo usuário? 1.SIM 2.Buscar");
		System.out.print("Opção: ");
		selecao = lerTeclado.nextByte();
		
		} while (selecao == 1);
//-------------------------------------------------------------------------		
		if (selecao == 2) {
			System.out.print("Nome para buscar: ");
			String nome = lerTeclado.next();
	
			for (int j=0; j<listaDePessoas.size();j++) {
				if (listaDePessoas.get(j).getNome().equals(nome)) {
					
					System.out.println("Email = " + listaDePessoas.get(j).getMail());
				}
			}
		}
//-------------------------------------------------------------------------	
	}
}