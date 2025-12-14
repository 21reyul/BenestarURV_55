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

    public void inscriures(Usuaris u){
        if(numInscrits<numPlaces){
            inscrits.Afegir(u);
            numInscrits++;
        }
        else{
            espera.Afegir(u);
            numEspera++;
        }
    }
    public void eliminaDeActivitat(Usuaris u){
        inscrits.Elimina(u);
        Usuaris a = espera.getUsuarisPos(0);
        inscrits.Afegir(a);
        espera.Elimina(a);
    }

    public void puntuar(double puntuacio, Usuaris usuari){
        
        // Comprovem que la puntuació sigui vàlida
        boolean puntuacioValida = puntuacio >= 0 && puntuacio <= 10;

        if (puntuacioValida) {
            boolean isInscrit = false;
            int i = 0;
            
            // Bucle de cerca de l'usuari
            while (i < inscrits.getnUsuaris() && !isInscrit) {
                if (inscrits.getUsuarisPos(i) == usuari) {
                    isInscrit = true;
                }
                i++;
            }
            
            if (isInscrit) {
                    this.valoracio = (int) (puntuacio + 0.5);
            }
        }
    }

    //getters y setters
    public Activitats getActivitat() {
        return activitat;
    }

    public void setActivitat(Activitats activitat) {
        this.activitat = activitat;
    }

    public int getNumPlaces(){
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces){
        this.numPlaces=numPlaces;
    }

    public Integer getValoracio() {
        return valoracio;
    }

    public void setValoracio(Integer valoracio) {
        this.valoracio = valoracio;
    } 
    
    public LlistaUsuaris getLlistaInscrits() {
        return inscrits;
    }

    public LlistaUsuaris getLlistaDeEspera() {
        return espera;
    }

    public int getNumEspera(){
        return numEspera; //No té un setter perquè es modifica automàticament
    }

}
