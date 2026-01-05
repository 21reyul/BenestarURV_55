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

    private String[] usuarisValorats;
    private int[] valors;
    private int nValoracions;

    public Inscripcions(Activitats a, int numPlaces) {
        this.activitat = a;
        this.valoracio = null;
        this.numPlaces=numPlaces;
        inscrits = new LlistaUsuaris(numPlaces);
        espera = new LlistaUsuaris(100);
        numInscrits=0;
        numEspera=0;

        usuarisValorats = new String[numPlaces + 200];
        valors = new int[numPlaces + 200];
        nValoracions = 0;
    }

    public void inscriures(Usuari u){
        if(numInscrits<numPlaces){
            inscrits.afegir(u);
            numInscrits++;
        }
        else{
            espera.afegir(u);
            numEspera++;
        }
    }
    public void eliminaDeActivitat(Usuari u){
        inscrits.elimina(u);
        if (numInscrits > 0) numInscrits--;

        if (numEspera > 0) {
            Usuari primer = espera.getUsuarisPos(0);
            espera.elimina(primer);
            numEspera--;

            inscrits.afegir(primer);
            numInscrits++;
        }
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

    public void setValoracioUsuari(Usuari u, int valoracio) {
        String id = u.getAlies();
        for (int i = 0; i < nValoracions; i++) {
            if (usuarisValorats[i].equalsIgnoreCase(id)) {
                valors[i] = valoracio;
                return;
            }
        }
        if (nValoracions < usuarisValorats.length) {
            usuarisValorats[nValoracions] = id;
            valors[nValoracions] = valoracio;
            nValoracions++;
        }
    }

    public Integer getValoracioUsuari(Usuari u) {
        String id = u.getAlies();
        for (int i = 0; i < nValoracions; i++) {
            if (usuarisValorats[i].equalsIgnoreCase(id)) {
                return valors[i];
            }
        }
        return null; // no ha valorat o no existeix
    }

    @Override
    public String toString() {
    String result = "Activitat: " + this.getActivitat().getNomActivitat() + "\n";
    result += "-> Inscrits (" + this.getNumInscrits() + "): ";
    for (int i = 0; i < this.getNumInscrits(); i++) {
        result += this.getInscrit(i).getAlies();
        if (i < this.getNumInscrits() - 1) result += ", ";
    }
    result += "\n-> En espera (" + this.getNumEspera() + "): ";
    for (int i = 0; i < this.getNumEspera(); i++) {
        result += this.getEspera(i).getAlies();
        if (i < this.getNumEspera() - 1) result += ", ";
    }
    result += "\n";
    return result;
    }
}
