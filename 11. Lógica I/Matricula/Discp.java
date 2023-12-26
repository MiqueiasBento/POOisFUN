package Matricula;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Discp {
	private String id;
	private TreeMap<String, Aluno> alunos;
	
	public Discp(String id) {
		this.id = id;
		this.alunos = new TreeMap<>();
	}
	
	// cria o vínculo bidirecional aluno disciplina
    public void addAluno(Aluno aluno) {
    	alunos.put(aluno.getId(), aluno);
    }
    
    // remove o vinculo do aluno e a disciplina
    public void rmAluno(String alunoId) {
    	alunos.remove(alunoId);
    }
	
	public String getId() {
		return this.id;
	}
	
	public List<Aluno> getAlunos(){
		List<Aluno> list = new ArrayList<>();
		
		for(Aluno a : alunos.values()) {
			list.add(a);
		}
		
		return list;
	}
	
	@ Override
	public String toString() {
		String out = this.id + " [";
		
		if(this.alunos.size() == 0) {
			out += "]";
		} else {
			for(Aluno a : alunos.values()) {
				out += a.getId() + ", ";
			}
			
			out = out.substring(0, out.length() - 2) + "]";
		}
		return out;
	}
}