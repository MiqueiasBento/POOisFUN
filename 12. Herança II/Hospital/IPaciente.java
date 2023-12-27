package Hospital;

import java.util.List;

public interface IPaciente {
	public String getId();
    public void addMedico(IMedico medico);
    public void removerMedico(String idMedico);
    public List<IMedico> getMedicos();
    public String getDiagnostico();
}