import java.time.LocalDate;

public class ActivitatOnline extends Activitat {
    private LocalDate dataInici;
    private int periodeVisualitzacio;
    private String enllac;

    public ActivitatOnline(String nomAct, String ofertaColectiu, LocalDate dataIniciInscripcions, LocalDate dataFiInscripcions,LocalDate dataInici, int periodeVisualitzacio, String enllac){
        super(nomAct, ofertaColectiu, dataIniciInscripcions, dataFiInscripcions);
        this.dataInici = dataInici;
        this.periodeVisualitzacio = periodeVisualitzacio;
        this.enllac = enllac;
    }

    //getters
    public LocalDate getDataIniciActivitat() { 
        return this.dataInici; 
    }

    public int getPeriodeVisualitzacio() { 
        return this.periodeVisualitzacio; 
    }

     public String getEnllac() { 
        return this.enllac; 
    }

    //setters
    public void setDataIniciActivitat(LocalDate dataInici) { 
        this.dataInici = dataInici; 
    }

    public void setPeriodeVisualitzacio(int periodeVisualitzacio) { 
        this.periodeVisualitzacio = periodeVisualitzacio; 
    }

    public void setEnllac(String enllac) { 
        this.enllac = enllac; 
    }
}
