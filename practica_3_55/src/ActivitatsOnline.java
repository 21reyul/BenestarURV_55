import java.time.LocalDate;

public class ActivitatsOnline extends Activitats{
    private String enllaç;
    private LocalDate dataIni;
    private int periode;

    public ActivitatsOnline(String n, boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF, String enlla, LocalDate inici, int perio){
        super(n, PDI, PTGAS, Estud, dataI, dataF);
        enllaç=enlla; 
        inici=dataIni; 
        this.periode=perio;
    }

    public String getEnllaç() {
        return enllaç;
    }

    public void setEnllaç(String enllaç) {
        this.enllaç = enllaç;
    }

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIni) {
        this.dataIni = dataIni;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return "ActivitatsOnline [enllaç=" + enllaç + ", dataIni=" + dataIni + ", periode=" + periode
                + ", NomActivitat=" + getNomActivitat() + "]";
    }
}
