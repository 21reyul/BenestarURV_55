package ActivitatsPackage;
import java.time.LocalDate;

public class ActivitatsOnline extends Activitats{
    private String enllaç;
    private int periode;

    /**
     * Constructor de la classe ActivitatsOnline
     * @param n
     * @param PDI
     * @param PTGAS
     * @param Estud
     * @param dataI
     * @param dataF
     * @param enlla
     * @param inici
     * @param perio
     */
    public ActivitatsOnline(String n, boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF, String enlla, int perio){
        super(n, PDI, PTGAS, Estud, dataI, dataF);
        enllaç=enlla;  
        this.periode=perio;
    }


    public String getEnllaç() {
        return enllaç;
    }

    public void setEnllaç(String enllaç) {
        this.enllaç = enllaç;
    }

    public LocalDate getDataIni() {
        return super.getDataIni();
    }

    public void setDataIni(LocalDate dataI) {
        super.setDataIni(dataI);
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }


    @Override
    public String toString() {
        return "ActivitatsOnline [enllaç=" + enllaç + ", periode=" + periode + ", nom:" +this.getNomActivitat() + "]";
    }
}
   
