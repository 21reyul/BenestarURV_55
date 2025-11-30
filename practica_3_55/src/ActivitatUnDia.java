import java.time.LocalDate;

public class ActivitatUnDia extends Activitat{
    private LocalDate data;
    private String horari;
    private int limitPlaces;
    private double preu;
    private String ciutat;

    //constructor
    public ActivitatUnDia (String nomAct, String ofertaColectiu, LocalDate dataIniciInscripcions, LocalDate dataFiInscripcions, LocalDate data, String horari, int limitPlaces, double preu, String ciutat){
        super(nomAct, ofertaColectiu, dataIniciInscripcions, dataFiInscripcions);
        this.data=data;
        this.horari=horari;
        this.limitPlaces=limitPlaces;
        this.preu=preu;
        this.ciutat=ciutat;
    }

    //getters
    public LocalDate getData(){
        return this.data;
    }

    public String getHorari(){
        return this.horari;
    }

    public int getLimitPlaces(){
        return this.limitPlaces;
    }

    public double getPreu(){
        return this.preu;
    }

    public String getCiutat(){
        return this.ciutat;
    }

    //setters
    public void setData(LocalDate data){
        this.data=data;
    }

    public void setHorari(String horari){
        this.horari=horari;
    }

    public void setLimitPlaces(int limitPlaces){
        this.limitPlaces=limitPlaces;
    }

    public void setPreu(double preu){
        this.preu=preu;
    }

    public void setCiutat(String ciutat){
        this.ciutat=ciutat;
    }
}
