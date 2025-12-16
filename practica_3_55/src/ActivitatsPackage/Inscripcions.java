package ActivitatsPackage;
import UsuarisPackage.*;
import java.io.Serializable;


//programador: Aroa Galvez Diaz;
public class Inscripcions implements Serializable {

    private Activitats activitat;
    private Integer valoracio; // null si no ha valorat
    private int numPlaces, numInscrits, numEspera;
    private LlistaUsuaris inscrits;
    private LlistaUsuaris espera;

    public Inscripcions(Activitats a, int numPlaces) {
        this.activitat = a;
        this.valoracio = null;
        inscrits = new LlistaUsuaris(numPlaces);
        espera = new LlistaUsuaris(100);
        numInscrits=0;
        numEspera=0;
    }

    public void afegirActivitat(Usuaris u){
        if(numInscrits<numPlaces){
            inscrits.Afegir(u);
            numInscrits++;
        }
        else{
            espera.Afegir(u);
            numEspera++;
        }
    }
    public void EliminaDeActivitat(Usuaris u){
        inscrits.Elimina(u);
        Usuaris a = espera.getUsuarisPos(0);
        inscrits.Afegir(a);
        espera.Elimina(a);
    }
    
    //getters y setters
    public Activitats getActivitat() {
        return activitat;
    }

    public void setActivitat(Activitats activitat) {
        this.activitat = activitat;
    }

    public Integer getValoracio() {
        return valoracio;
    }

    public void setValoracio(Integer valoracio) {
        this.valoracio = valoracio;
    }

    public LlistaUsuaris getInscrits() {
        return inscrits;
    }

    public void setInscrits(LlistaUsuaris inscrits) {
        this.inscrits = inscrits;
    }

    public LlistaUsuaris getEspera() {
        return espera;
    }

    public void setEspera(LlistaUsuaris espera) {
        this.espera = espera;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public int getNumInscrits() {
        return numInscrits;
    }

    public void setNumInscrits(int numInscrits) {
        this.numInscrits = numInscrits;
    }

    public int getNumEspera() {
        return numEspera;
    }

    public void setNumEspera(int numEspera) {
        this.numEspera = numEspera;
    } 
}
