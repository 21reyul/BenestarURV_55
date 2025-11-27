import java.time.LocalDate;
import java.time.LocalTime;

public class ActivitatsUnDia extends Activitats{
    private LocalTime hora;
    private int places;
    private double preu;
    private String ciutat;

    public ActivitatsUnDia(String n, Boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF, int plac, double p, String ciu, LocalTime h){
        super(n, PDI, PTGAS, Estud, dataI, dataF);
        places =plac; preu=p; ciutat=ciu; hora=h;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
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
        return "ActivitatsUnDia [hora=" + hora + ", places=" + places + ", preu=" + preu + ", ciutat=" + ciutat
                + ", NomActivitat()=" + getNomActivitat() + ", Data()=" + getDataINI() + "]";
    }

}
