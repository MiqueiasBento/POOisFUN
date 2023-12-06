package Matricula;

import java.util.ArrayList;
import java.util.TreeMap;

public class Sistema {
	private TreeMap<String, Discp> discps;
	private TreeMap<String, Aluno> alunos;
	
	public Sistema() {
		discps = new TreeMap<>();
		alunos = new TreeMap<>();
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.put(aluno.getId(), aluno);
	}
	
	public void addDiscp(Discp discp) {
		this.discps.put(discp.getId(), discp);
	}
	
	public ArrayList<Aluno> getAlunos(){
		ArrayList<Aluno> list = new ArrayList<>();
		for(Aluno a : alunos.values()) {
			list.add(a);
		}
		
		return list;
	}
	    
	public ArrayList<Discp> getDiscp(){
		ArrayList<Discp> list = new ArrayList<>();
		for(Discp d : discps.values()) {
			list.add(d);
		}
		
		return list;
	}
	    
	// recupera os objetos aluno e disciplina e vincula-os
	public void matricular(String idAluno, String idDiscp) throws Exception{
		if(alunos.get(idAluno) == null) {
			throw new Exception("fail: aluno nao existe");
		}
		if(discps.get(idDiscp) == null) {
			throw new Exception("fail: disciplina nao exite");
		}
		
		alunos.get(idAluno).addDiscp(discps.get(idDiscp));
		discps.get(idDiscp).addAluno(alunos.get(idAluno));
	}
	
	// desmatricula os alunos das disciplinas
	public void desmatricular(String idAluno, String idDiscp) throws Exception{
		if(alunos.get(idAluno) == null) {
			throw new Exception("fail: aluno nao existe");
		}
		if(discps.get(idDiscp) == null) {
			throw new Exception("fail: disciplina nao exite");
		}
		
		alunos.get(idAluno).rmDiscp(discps.get(idDiscp).getId());
		discps.get(idDiscp).rmAluno(alunos.get(idAluno).getId());
	}
	
	// Remove o aluno do sistema
	public void rmAluno(String idAluno) throws Exception {
		if(alunos.get(idAluno) == null) {
			throw new Exception("fail: aluno nao existe");
		}
		
		for(Discp d : discps.values()) {
			for(Aluno a : d.getAlunos()) {
				if(a.getId().equals(idAluno)) {
					d.rmAluno(idAluno);
					break;
				}
			}
		}
		alunos.remove(idAluno);
	}
	
	@ Override
	public String toString() {
		String out = "- alunos\n";
		
		for(Aluno a : alunos.values()) {
			out += a + "\n";
		}
		
		out += "- discps\n";
		for(Discp d : discps.values()) {
			out += d + "\n";
		}
		
		return out.substring(0, out.length() - 1);
	}
}