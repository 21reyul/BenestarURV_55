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
    public void afegirAActivitat(Usuaris u){
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
}
