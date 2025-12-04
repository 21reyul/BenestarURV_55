package ActivitatsPackage;
import java.time.LocalDate;
import java.time.LocalTime;

public class ActivitatsUnDia extends Activitats{
    private LocalTime hora;
    private int limitplaces;
    private double preu;
    private String ciutat;

    public ActivitatsUnDia(String n, boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF, int plac, double p, String ciu, LocalTime h){
        super(n, PDI, PTGAS, Estud, dataI, dataF);
        limitplaces =plac; preu=p; ciutat=ciu; hora=h;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getLimitPlaces() {
        return limitplaces;
    }

    public void setPlaces(int places) {
        this.limitplaces = places;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    @Override
    public String toString() {
        return "ActivitatsUnDia [hora=" + hora + ", places=" + Limitplaces + ", preu=" + preu + ", ciutat=" + ciutat
                + ", NomActivitat()=" + getNomActivitat() + ", Data()=" + getDataINI() + "]";
    }

}
