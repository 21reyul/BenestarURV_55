import java.time.LocalDate;

public class ActivitatPeriodica extends Activitat {
    private LocalDate diaSetmana;    //TODO extensió data
    private String horari;
    private LocalDate dataInici;
    private int numSetmanes;
    private int limitPlaces;
    private double preu;
    private String nomCentre;
    private String ciutat;

    //constructor
    public ActivitatPeriodica (String nomAct, String ofertaColectiu, LocalDate dataIniciInscripcions, LocalDate dataFiInscripcions, LocalDate diaSetmana, String horari, LocalDate dataInici, int numSetmanes, int limitPlaces, double preu, String nomCentre, String ciutat){
        super(nomAct, ofertaColectiu, dataIniciInscripcions, dataFiInscripcions);
        this.diaSetmana=diaSetmana;
        this.horari=horari;
        this.dataInici=dataInici;
        this.numSetmanes=numSetmanes;
        this.limitPlaces=limitPlaces;
        this.preu=preu;
        this.nomCentre=nomCentre;
        this.ciutat=ciutat;
    }

    //getters
    public LocalDate getData(){
        return this.diaSetmana;
    }

    public String getHorari(){
        return this.horari;
    }

    public LocalDate getDataInici(){
        return this.dataInici;
    }

    public int getNumSetmanes(){
        return this.numSetmanes;
    }

    public int getLimitPlaces(){
        return this.limitPlaces;
    }

    public double getPreu(){
        return this.preu;
    } 

    public String getNomCentre(){
        return this.nomCentre;
    }

    public String getCiutat(){
        return this.ciutat;
    }

    //setters
    public void setData(LocalDate diaSetmana){
        this.diaSetmana=diaSetmana;
    }

    public void setHorari(String horari){
        this.horari=horari;
    }

    public void setDataInici(LocalDate dataInici){
        this.dataInici=dataInici;
    }

    public void setNumSetmanes(int numSetmanes){
        this.numSetmanes=numSetmanes;
    }

    public void setLimitPlaces(int limitPlaces){
        this.limitPlaces=limitPlaces;
    }

    public void setPreu(double preu){
        this.preu=preu;
    } 

    public void setNomCentre(String nomCentre){
        this.nomCentre=nomCentre;
    }

    public void setCiutat(String ciutat){
        this.ciutat=ciutat;
    }
}
