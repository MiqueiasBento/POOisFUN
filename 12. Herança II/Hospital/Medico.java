package Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Medico implements IMedico {
	private String sender;
    private String classe;
    private TreeMap<String, IPaciente> pacientes;
    
    public Medico(String sender, String classe) {
    	this.sender = sender;
    	this.classe = classe;
    	this.pacientes = new TreeMap<>();
    }

    public String getId() {
    	return this.sender;
	}

    public void addPaciente(IPaciente paciente) {
    	this.pacientes.put(paciente.getId(), paciente);
	}

    public void removerPaciente(String idPaciente) {
    	this.pacientes.remove(idPaciente);
	}

    public List<IPaciente> getPacientes() {
    	List<IPaciente> list = new ArrayList<>();
    	
    	for(IPaciente p : this.pacientes.values())
    		list.add(p);
    	
    	return list;
	}

    public String getClasse() {
    	return this.classe;
	}
    
    @ Override
    public String toString() {
    	String out = "Med: " + String.format("%-16s", (this.sender + ":" + this.classe)) + " Pacs: [";
    	
    	for(IPaciente p : this.pacientes.values())
    		out += p.getId() + ", ";
    	
    	out = ((!this.pacientes.isEmpty()) ? out.substring(0, out.length() - 2): out) + "]";
    	return out;
	}
}