package ActivitatsPackage;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Activitats {
    private String nomActivitat;
    private boolean Pdi, Ptgas, Estudiants;
    private LocalDate dataIni, dataFi;


    public Activitats(String n, boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF){
        nomActivitat=n; this.Pdi=Pdi; this.Ptgas=Ptgas; Estudiants=Estud; dataIni=dataI; dataFi=dataF;
    }

    public String getNomActivitat() {
        return nomActivitat;
    }

    public void setNomActivitat(String nomActivitat) {
        this.nomActivitat = nomActivitat;
    }

    public boolean isPDI() {
        return Pdi;
    }

    public void setPDI(boolean Pdi) {
        Pdi = Pdi;
    }

    public boolean isPTGAS() {
        return Ptgas;
    }

    public void setPTGAS(boolean Ptgas) {
        Ptgas = Ptgas;
    }

    public boolean isEstudiants() {
        return Estudiants;
    }

    public void setEstudiants(boolean estudiants) {
        Estudiants = estudiants;
    }

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataINI) {
        this.dataIni = dataINI;
    }

    public LocalDate getDataFi() {
        return dataFi;
    }

    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }

    @Override
    public String toString() {
        return "Activitats [nomActivitat=" + nomActivitat + ", PDI=" + Pdi + ", PTGAS=" + Ptgas + ", Estudiants="
                + Estudiants + ", dataINI=" + dataIni + ", dataFi=" + dataFi + "]";
    }

    //falta implementar
    public Activitats copia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copia'");
    }

    //comprobar si l'activitat ha acabat
    public boolean haAcabat(){
        return LocalDate.now().isAfter(dataFi);
    }

    public Activitats copia(){
        Activitats activitat= new Activitats(this.nomActivitat, this.PDI, this.PTGAS, this.Estudiants, this.dataINI, this.dataFi);
        return activitat;
    }

    public boolean esPerA(String colectiu) { 
        boolean es=false;
        if (colectiu.equals("PDI") && this.PDI==true){
            es=true;
        }
        else if (colectiu.equals("PTGAS") && this.PTGAS==true){
            es=true;
        }
        else if (colectiu.equals("estudiants") && this.Estudiants==true){
            es=true;
        }
        return es;
    }



}
