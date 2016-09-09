
public class Prefeito {
	private String nome;
	private String numeroVotacao;
	private int votos; 

	public Prefeito (String nome, String numeroVotacao ) {
		this.nome = nome;
		this.numeroVotacao = numeroVotacao;	
	}
	
	public void adicionaVotos () { votos++; }
	
	public int getVotos () { return votos; }
	
	public String getNome () { return nome; }
	
	public String getNumeroVotacao () { return numeroVotacao; }

}