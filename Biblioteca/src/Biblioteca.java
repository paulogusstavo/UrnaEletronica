import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Aluno> listaDeAlunos = new ArrayList<Aluno>();
	private ArrayList<Professor> listaDeProfessores = new ArrayList<Professor>();
	
	public void cadastrarAluno (Aluno aluno) {
		listaDeAlunos.add(aluno);
	}
	
	public void cadastrarProfessor (Professor professor) {
		listaDeProfessores.add(professor);
	}
	
	public ArrayList<Aluno> getAlunos () { return listaDeAlunos; }
	public ArrayList<Professor> getProfessores () { return listaDeProfessores; }

}