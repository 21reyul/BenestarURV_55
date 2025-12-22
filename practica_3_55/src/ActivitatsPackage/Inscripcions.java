package ActivitatsPackage;
import UsuarisPackage.*;
import java.io.Serializable;


//programador: Aroa Galvez Diaz;
public class Inscripcions implements Serializable {
    private Activitats activitat;
    private Integer valoracio; // null si no ha valorat
    private int numPlaces, numInscrits, numEspera;
   
    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public int getNumEspera() {
        return numEspera;
    }

    public void setNumEspera(int numEspera) {
        this.numEspera = numEspera;
    }

    public int getNumInscrits() {
        return numInscrits;
    }

    public void setNumInscrits(int numInscrits) {
        this.numInscrits = numInscrits;
    }

    //Retorna l'inscrit en la posicio i
    public Usuari getInscrit(int i) {
        Usuari inscrit = new Usuari(null, null);
        if (i >= 0 && i < inscrits.getnUsuaris()) {
            return inscrits.getUsuarisPos(i);
        }
        return null; // o lanzar excepción si prefieres
    }

    // Retorna l'inscrit en la posicio i de la llisat d'espera
    public Usuari getEspera(int i) {
        if (i >= 0 && i < espera.getnUsuaris()) {
            return espera.getUsuarisPos(i);
        }
        return null;
    }

    private LlistaUsuaris inscrits;
   
    public LlistaUsuaris getLlistaInscrits() {
        return inscrits;
    }

    public void setLlistaInscrits(LlistaUsuaris inscrits) {
        this.inscrits = inscrits;
    }

    private LlistaUsuaris espera;

    public Inscripcions(Activitats a, int numPlaces) {
        this.activitat = a;
        this.valoracio = null;
        this.numPlaces = numPlaces;
        inscrits = new LlistaUsuaris(numPlaces);
        espera = new LlistaUsuaris(100);
        numInscrits=0;
        numEspera=0;
    }

    public void afegirActivitat(Usuari u){
        if(numInscrits<numPlaces){
            inscrits.Afegir(u);
            numInscrits++;
        }
        else{
            espera.Afegir(u);
            numEspera++;
        }
    }
    public void EliminaDeActivitat(Usuari u){
        inscrits.Elimina(u);
        Usuari a = espera.getUsuarisPos(0);
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
    

    



}
