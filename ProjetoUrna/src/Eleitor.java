
public class Eleitor {
	
	private String nome;
	private int titulo;
	private int zona;
	private int secao;
	private boolean votou;

//-----Construtor------------------------------------------------------------
	public Eleitor (String nome,int titulo, int zona, int secao) {
		this.nome = nome;
		this.titulo = titulo;
		this.zona = zona;
		this.secao = secao;
	}
//-----GET E SET--------------------------------------------------------------
	public String getNome () { return nome; }
	public int getTitulo () {return titulo;}
	public int getZona () { return zona; }
	public int getSecao () { return secao; }
	
	public boolean getVotou() { return votou; }
	public void setVotar() { votou = true; }
//----------------------------------------------------------------------------		
}