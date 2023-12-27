package Hospital;

import java.util.TreeMap;

public class Hospital {
	private TreeMap<String, IPaciente> pacientes = new TreeMap<>();
	private TreeMap<String, IMedico> medicos = new TreeMap<>();

	public Hospital() {
		this.pacientes = new TreeMap<>();
		this.medicos = new TreeMap<>();
	}

	public void removerPaciente(String sender) throws Exception {
		if (!this.pacientes.containsKey(sender))
			throw new Exception("fail: " + sender + " nao existe");

		this.pacientes.remove(sender);
	}

	public void removerMedico(String sender) throws Exception {
		if (!this.medicos.containsKey(sender))
			throw new Exception("fail: " + sender + " nao existe");

		this.medicos.remove(sender);
	}

	public void addPaciente(IPaciente paciente) throws Exception {
		if (this.pacientes.containsKey(paciente.getId()))
			throw new Exception("fail: paciente " + paciente.getId() + " ja cadastrado");

		this.pacientes.put(paciente.getId(), paciente);
	}

	public void addMedico(IMedico medico) throws Exception {
		if (this.pacientes.containsKey(medico.getId()))
			throw new Exception("fail: paciente " + medico.getId() + " ja cadastrado");

		this.medicos.put(medico.getId(), medico);
	}

	public void vincular(String nomeMedico, String nomePaciente) throws Exception {
		if(!this.pacientes.containsKey(nomePaciente))
			throw new Exception("fail: paciente " + nomePaciente + " nao cadastrado");
			
		if(!this.medicos.containsKey(nomeMedico))
			throw new Exception("fail: medico " + nomeMedico + " nao cadastrado");
		
		for(IMedico m : this.pacientes.get(nomePaciente).getMedicos()) {
			if(this.medicos.get(nomeMedico).getClasse().equals(m.getClasse())) {
				throw new Exception("fail: ja existe outro medico da especialidade " + m.getClasse());
			}
		}
		
		this.pacientes.get(nomePaciente).addMedico(this.medicos.get(nomeMedico));
		this.medicos.get(nomeMedico).addPaciente(this.pacientes.get(nomePaciente));
	}

	@Override
	public String toString() {
		String out = "";
		
		for(IPaciente p : this.pacientes.values())
			out += p + "\n";
		
		for(IMedico m : this.medicos.values())
			out += m + "\n";
		
		return out.substring(0, out.length() - 1);
	}
}