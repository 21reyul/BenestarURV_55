package ActivitatsPackage;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Activitats {
    private String nomActivitat;
    private boolean Pdi, Ptgas, Estudiants;
    private LocalDate dataIni, dataFi;

    /**
     * Constructor de la classe Activitats
     * @param n
     * @param PDI
     * @param PTGAS
     * @param Estud
     * @param dataI
     * @param dataF
     */
    public Activitats(String n, boolean Pdi, boolean Ptgas, boolean Estud, LocalDate dataI, LocalDate dataF){
        nomActivitat=n; this.Pdi=Pdi; this.Ptgas=Ptgas; Estudiants=Estud; dataIni=dataI; dataFi=dataF;
    }

    /**
     * Getter del nom de l'activitat
     * @return nom de l'activitat
     */
    public String getNomActivitat() {
        return nomActivitat;
    }

    /**
     * Setter del nom de l'activitat
     * @param nomActivitat
     */
    public void setNomActivitat(String nomActivitat) {
        this.nomActivitat = nomActivitat;
    }

    /**
     * Mètode que et diu si un usuari es PDI
     * @return cert si ho és, fals si no
     */
    public boolean isPDI() {
        return Pdi;
    }

    public void setPDI(boolean Pdi) {
        this.Pdi = Pdi;
    }

    /**
     * Mètode que et diu si un usuari es PTGAS
     * @return cert si ho és, fals si no
     */
    public boolean isPTGAS() {
        return Ptgas;
    }

    public void setPTGAS(boolean Ptgas) {
        this.Ptgas = Ptgas;
    }

    /**
     * Mètode que et diu si un usuari es estudiant
     * @return cert si ho és, fals si no
     */
    public boolean isEstudiants() {
        return Estudiants;
    }

    /**
     * Setter de si es estudiant
     * @param estudiants
     */
    public void setEstudiants(boolean estudiants) {
        Estudiants = estudiants;
    }

    /**
     * Getter de la data d'inici
     * @return data d'inici
     */
    public LocalDate getDataIni() {
        return dataIni;
    }

    /**
     * Setter de la data d'inici
     * @param dataINI
     */
    public void setDataIni(LocalDate dataINI) {
        this.dataIni = dataINI;
    }

    /**
     * Getter de la data de finalització
     * @return data de finalització
     */
    public LocalDate getDataFi() {
        return dataFi;
    }

    /**
     * Setter de la data de finalització
     * @param dataFi
     */
    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }
    

    /**
     * ToString de la classe Activitats
     */
    @Override
    public String toString() {
        return "Activitats [nomActivitat=" + nomActivitat + ", PDI=" + Pdi + ", PTGAS=" + Ptgas + ", Estudiants="
                + Estudiants + ", dataINI=" + dataIni + ", dataFi=" + dataFi + "]";
    }

    //comprobar si l'activitat ha acabat
    public boolean haAcabat(){
        return LocalDate.now().isAfter(dataFi);
    }

    /**
     * Mètode que et diu si una activitat a finalitzat
     * Programadora: Aina Garcia Albesa
     * @return cert si ha finalitzat, fals si no ho ha fet
     */
    public boolean haFinalitzat() {
        // Obtenim la data actual del sistema
        LocalDate dataActual = LocalDate.now();
        return this.dataFi.isBefore(dataActual);
    }
    public Activitats copia(){
        Activitats activitat= new Activitats(this.nomActivitat, this.Pdi, this.Ptgas, this.Estudiants, this.dataIni, this.dataFi);
        return activitat;
    }

    public boolean esPerA(String colectiu) { 
        boolean es=false;
        if (colectiu.equals("PDI") && this.Pdi==true){
            es=true;
        }
        else if (colectiu.equals("PTGAS") && this.Ptgas==true){
            es=true;
        }
        else if (colectiu.equals("estudiants") && this.Estudiants==true){
            es=true;
        }
        return es;
    }



}
