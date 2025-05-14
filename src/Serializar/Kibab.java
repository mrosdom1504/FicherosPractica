package Serializar;

import java.io.Serializable;

public class Kibab implements Serializable {
    private String tipoCarne;
    private String tipoSalsa;

    public Kibab() {
    }

    public Kibab(String tipoCarne, String tipoSalsa) {
        this.tipoCarne = tipoCarne;
        this.tipoSalsa = tipoSalsa;
    }

    public String getTipoCarne() {
        return tipoCarne;
    }

    public void setTipoCarne(String tipoCarne) {
        this.tipoCarne = tipoCarne;
    }

    public String getTipoSalsa() {
        return tipoSalsa;
    }

    public void setTipoSalsa(String tipoSalsa) {
        this.tipoSalsa = tipoSalsa;
    }

    @Override
    public String toString() {
        return "Kibab{" +
                "tipoCarne='" + tipoCarne + '\'' +
                ", tipoSalsa='" + tipoSalsa + '\'' +
                '}';
    }
}
