package ActivitatsPackage;
import java.time.LocalDate;

public abstract class Activitats {
     private String nomActivitat;
     private boolean PDI, PTGAS, Estudiants;
     private LocalDate dataINI, dataFi;


    public Activitats(String n, boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF){
        nomActivitat=n; this.PDI=PDI; this.PTGAS=PTGAS; Estudiants=Estud; dataINI=dataI; dataFi=dataF;
    }

    public String getNomActivitat() {
        return nomActivitat;
    }

    public void setNomActivitat(String nomActivitat) {
        this.nomActivitat = nomActivitat;
    }

    public boolean isPDI() {
        return PDI;
    }

    public void setPDI(boolean pDI) {
        PDI = pDI;
    }

    public boolean isPTGAS() {
        return PTGAS;
    }

    public void setPTGAS(boolean pTGAS) {
        PTGAS = pTGAS;
    }

    public boolean isEstudiants() {
        return Estudiants;
    }

    public void setEstudiants(boolean estudiants) {
        Estudiants = estudiants;
    }

    public LocalDate getDataINI() {
        return dataINI;
    }

    public void setDataINI(LocalDate dataINI) {
        this.dataINI = dataINI;
    }

    public LocalDate getDataFi() {
        return dataFi;
    }

    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }

    @Override
    public String toString() {
        return "Activitats [nomActivitat=" + nomActivitat + ", PDI=" + PDI + ", PTGAS=" + PTGAS + ", Estudiants="
                + Estudiants + ", dataINI=" + dataINI + ", dataFi=" + dataFi + "]";
    }


}
