
public class Candidato {
	private String nome;
	private String numeroVotacao;
	private String partido;
	private int votos; 

//-----Construtor--------------------------------------------------------
	public Candidato (String nome, String numeroVotacao, String partido) {
		this.nome = nome;
		this.numeroVotacao = numeroVotacao;
		this.partido = partido;
	}
//-----SET E GET---------------------------------------------------------
	public void adicionaVotos () { votos++; }
	public int getVotos () { return votos; }
	
	public String getNome () { return nome; }
	public String getNumeroVotacao () { return numeroVotacao; }
	public String getPartido() { return partido; }
//-----------------------------------------------------------------------
}