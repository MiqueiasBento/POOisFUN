package Carga;

import java.util.List;

public interface Vagao {
    List<Pass> getElementos();
    void embarcar(Pass pass) throws Exception;

    void desembarcar(String idPass);

    boolean exists(Pass pass);
}