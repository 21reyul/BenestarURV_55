package ActivitatsPackage;
import java.time.LocalDate;

public abstract class Activitats {
    private String nomActivitat;
    private boolean PDI, PTGAS, Estudiants;
    private LocalDate dataINI, dataFi;

    /**
     * Constructor de la classe Activitats
     * @param n
     * @param PDI
     * @param PTGAS
     * @param Estud
     * @param dataI
     * @param dataF
     */
    public Activitats(String n, boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF){
        nomActivitat=n; this.PDI=PDI; this.PTGAS=PTGAS; Estudiants=Estud; dataINI=dataI; dataFi=dataF;
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
        return PDI;
    }

    /**
     * Setter de si és PDI
     * @param pDI
     */
    public void setPDI(boolean pDI) {
        PDI = pDI;
    }

    /**
     * Mètode que et diu si un usuari es PTGAS
     * @return cert si ho és, fals si no
     */
    public boolean isPTGAS() {
        return PTGAS;
    }

    /**
     * Setter de si és PTGAS
     * @param pTGAS
     */
    public void setPTGAS(boolean pTGAS) {
        PTGAS = pTGAS;
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
    public LocalDate getDataINI() {
        return dataINI;
    }

    /**
     * Setter de la data d'inici
     * @param dataINI
     */
    public void setDataINI(LocalDate dataINI) {
        this.dataINI = dataINI;
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
        return "Activitats [nomActivitat=" + nomActivitat + ", PDI=" + PDI + ", PTGAS=" + PTGAS + ", Estudiants="
                + Estudiants + ", dataINI=" + dataINI + ", dataFi=" + dataFi + "]";
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

}
