package Hospital;

import java.util.List;

public interface IMedico {
	public String getId();
    public void addPaciente(IPaciente paciente) throws Exception;
    public void removerPaciente(String idPaciente) throws Exception;
    public List<IPaciente> getPacientes();
    public String getClasse();
}