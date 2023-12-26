package Matricula;

import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class Aluno {
	private String id;
	private TreeMap<String, Discp> discps;
	
	public Aluno(String id) {
		this.id = id;
		this.discps = new TreeMap<>();
	}
	
	// cria o vínculo bidirecional aluno disciplina
    public void addDiscp(Discp discp) {
    	discps.put(discp.getId(), discp);
    }
    
    // remove o vinculo do aluno e a disciplina
    public void rmDiscp(String discp) {
    	discps.remove(discp);
    }
	
	public String getId() {
		return this.id;
	}
	
	public List<Discp> getDiscps(){
		List<Discp> list = new ArrayList<>();
		
		for(Discp d : discps.values()) {
			list.add(d);
		}
		
		return list;
	}
	
	@ Override
	public String toString() {
		String out = this.id + " ";
		
		if(this.discps.size() == 0) {
			out += "[]";
		} else {
			out += "[";
			for(Discp d : getDiscps()) {
				out += d.getId() + ", ";
			}
			out = out.substring(0, out.length() - 2) + "]";
		}
		return out;
	}
}