import java.util.*;

public class Urna 
{
	private int senha=1234;
	
	private Candidato candidato;
	private Eleitor eleitor;
	private boolean confirma;
	private boolean corrige;
	private boolean votoBranco;
	
	
	public boolean checarSenha (int senha) {	
		if (this.senha == senha) {
			return true;
		}
		else
			return false;
	}
	
	
	private void cadastroCandidato () {
		
	}
	
	private void cadastroVereador () {	
		
	}
	
	public void resuldato () {
		
	}
	
	private boolean confirmacao() {
		
		return true;
	}

}
