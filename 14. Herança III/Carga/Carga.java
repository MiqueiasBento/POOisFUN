package Carga;

import java.util.*;

public class Carga implements Pass {
    private String id;
    private float peso;

    public Carga(String id, float peso) {
        this.id   = id;
        this.peso = peso;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Carga carga)) return false;
        return Objects.equals(getId(), carga.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getId() + ":" + String.format("%.1f", peso);
    }
}