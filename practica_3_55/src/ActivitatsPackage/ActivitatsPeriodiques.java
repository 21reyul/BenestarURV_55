package ActivitatsPackage;
import java.time.LocalDate;
import java.time.LocalTime;

public class ActivitatsPeriodiques extends Activitats{
    private String diaDeLaSemana, nomCentre, ciutat;
    private LocalTime hora;
    private LocalDate dataIni;
    private int numSetmanes, limitPlaces;
    private double preu;

    public ActivitatsPeriodiques(String n, Boolean PDI, boolean PTGAS, boolean Estud, LocalDate dataI, LocalDate dataF, String diaDeLaSemana, String nomCentre, String ciutat, LocalTime hora,
            LocalDate dataIni, int numSetmanes, int limitPlaces, double preu) {
        super(n, PDI, PTGAS, Estud, dataI, dataF);
        this.diaDeLaSemana = diaDeLaSemana;
        this.nomCentre = nomCentre;
        this.ciutat = ciutat;
        this.hora = hora;
        this.dataIni = dataIni;
        this.numSetmanes = numSetmanes;
        this.limitPlaces = limitPlaces;
        this.preu = preu;
    }

    public String getDiaDeLaSemana() {
        return diaDeLaSemana;
    }

    public void setDiaDeLaSemana(String diaDeLaSemana) {
        this.diaDeLaSemana = diaDeLaSemana;
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIni) {
        this.dataIni = dataIni;
    }

    public int getNumSetmanes() {
        return numSetmanes;
    }

    public void setNumSetmanes(int numSetmanes) {
        this.numSetmanes = numSetmanes;
    }

    public int getLimitPlaces() {
        return limitPlaces;
    }

    public void setLimitPlaces(int limitPlaces) {
        this.limitPlaces = limitPlaces;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "ActivitatsPeriodiques [diaDeLaSemana=" + diaDeLaSemana + ", nomCentre=" + nomCentre + ", ciutat="
                + ciutat + ", hora=" + hora + ", dataIni=" + dataIni + ", numSetmanes=" + numSetmanes + ", limitPlaces="
                + limitPlaces + ", preu=" + preu + ", Nom Activitat()=" + getNomActivitat() + "]";
    }
}