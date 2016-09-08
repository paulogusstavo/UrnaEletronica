
public class Candidato {
	private String nome;
	private int numeroVotacao;
	private int votos;

	public Candidato (String nome, int numeroVotacao ) {
		this.nome = nome;
		this.numeroVotacao = numeroVotacao;	
	}
	
	public void adicionaVotos () { votos++; }
	
	public int getVotos () { return votos; } 
	
	public String getNome () { return nome; }
	
	public int getNumeroVotacao () { return numeroVotacao; }

}