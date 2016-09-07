
public class Eleitor {
	private String nome;
	private int zona;
	private int secao;

	public Eleitor (String nome, int zona, int secao) {
		this.nome = nome;
		this.zona = zona;
		this.secao = secao;
	}
	
	public String getNome () { return nome; }
	
	public int getZona () { return zona; }
	
	public int getSecao () { return secao; }

}