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
    private int[] valoracions;
    int numValoracions;

    public Inscripcions(Activitats a, int numPlaces) {
        this.activitat = a;
        this.valoracio = 0;
        this.numPlaces = numPlaces;
        inscrits = new LlistaUsuaris(numPlaces);
        espera = new LlistaUsuaris(100);
        numInscrits=0;
        numEspera=0;
        this.valoracions=new int[100];
        this.numValoracions = 0;
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
        Usuari a = espera.getUsuarisPos(0);
        inscrits.afegir(a);
        espera.elimina(a);
    }

    public void puntuar(double puntuacio, Usuari usuari){
        
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

    public Integer getValoracio() {
        return valoracio;
    }

    public void setValoracio(Integer valoracio) {
        this.valoracio = valoracio;
    } 


    public LlistaUsuaris getLlistaDeEspera() {
        return espera;
    }

    public int[] getValoracions() {
        int[] copia = new int[numInscrits];
        for (int i = 0; i < numInscrits; i++) {
            copia[i] = valoracions[i];
        }
        return copia;
    }

    /**
     * Mètode que et dona la valoració d'un usuari
     * Programadora: Aina Garcia Albesa
     * @param usuari
     * @return valoració d'un usuari (entera)
     */
    public Integer getValoracioUsuari(Usuari usuari) {
        Integer resultat = null;
        
        if (usuari != null && inscrits != null) {
            int i = 0;
            boolean trobat = false;
            
            // Buscar si l'usuari està inscrit
            while (i < inscrits.getnUsuaris() && !trobat) {
                Usuari u = inscrits.getUsuarisPos(i);
                if (u != null && u.getAlies().equals(usuari.getAlies())) {
                    trobat = true;
                }
                i++;
            }
            
            // Si està inscrit, retornar la valoració
            if (trobat) {
                resultat = this.valoracio;
            }
        }
        
        return resultat; 
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