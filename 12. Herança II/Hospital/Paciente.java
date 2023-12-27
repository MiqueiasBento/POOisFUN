package Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Paciente implements IPaciente {
	private String sender;
    private String diagnostico;
    private TreeMap<String, IMedico> medicos;
    
    public Paciente(String sender, String diagnostico) {
    	this.sender = sender;
        this.diagnostico = diagnostico;
    	this.medicos = new TreeMap<>();
    }
    public String getId() {
    	return this.sender;
	}

    public void addMedico(IMedico medico){
    	this.medicos.put(medico.getId(), medico);
	}

    public void removerMedico(String idMedico) {
    	this.medicos.remove(idMedico);
	}

    public List<IMedico> getMedicos() {
    	List<IMedico> list = new ArrayList<>();
    	
    	for(IMedico m : this.medicos.values())
    		list.add(m);
    	
    	return list;
	}

    public String getDiagnostico() {
    	return this.diagnostico;
	}
    
    @ Override
    public String toString() {
    	String out = "Pac: " + String.format("%-16s", (this.sender + ":" + this.diagnostico)) + " Meds: [";
    	
    	for(IMedico m : this.medicos.values())
    		out += m.getId() + ", ";
    	
    	out = ((!this.medicos.isEmpty()) ? out.substring(0, out.length() - 2): out) + "]";
    	return out;
	}
}