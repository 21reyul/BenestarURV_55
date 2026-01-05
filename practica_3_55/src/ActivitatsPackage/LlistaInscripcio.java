package ActivitatsPackage;
import UsuarisPackage.*;

public class LlistaInscripcio{
    private Inscripcions[] inscripcions;
    private int numElem;

    public int getNumElem() {
        return numElem;
    }

    public void setNumElem(int numElem) {
        this.numElem = numElem;
    }

    public LlistaInscripcio(int MAX) {
        inscripcions = new Inscripcions[MAX];
        numElem=0;
   }
    public void Afegir(Usuari u, Activitats a){
        int i=0;
        boolean trobat=false;
        while(!trobat&&i<inscripcions.length){
            if(inscripcions[i].getActivitat()==a){
                trobat=true;
            }
            else{
                i++;
            }
        }
        if(trobat){
            inscripcions[i].afegirActivitat(u);
        }
        else{
            inscripcions[i]= new Inscripcions(a, 100);
            inscripcions[i].afegirActivitat(u);
        }
    }
    public Inscripcions getInscripcioPos(int i){
        return inscripcions[i];
    }

    public void afegir(Usuari u, Activitats a){
        // Primer, buscar si ja existeix una inscripció per aquesta activitat
        for(int i = 0; i < numElem; i++){
            if(inscripcions[i].getActivitat() == a){
                inscripcions[i].afegirActivitat(u);
                return; // ja inscrit, sortim
            }
        }

        // Si no existeix, afegim una nova inscripció si hi ha espai
        if(numElem < inscripcions.length){
            inscripcions[numElem] = new Inscripcions(a, 100);
            inscripcions[numElem].afegirActivitat(u);
            numElem++;
        } else {
            System.out.println("No hi ha espai per afegir més inscripcions.");
        }
    }

    //metode que elimina un usuari d'una activitat
    public void eliminar(Usuari u, Activitats a){
        for(int i = 0; i < numElem; i++){
            if(inscripcions[i] != null && inscripcions[i].getActivitat().equals(a)){
                inscripcions[i].EliminaDeActivitat(u);

                if(inscripcions[i].getNumInscrits() == 0 && inscripcions[i].getNumEspera() == 0){
                    //eliminem l'element i movem tots els elements una posicio endavant
                    for(int j = i; j < numElem - 1; j++){
                        inscripcions[j] = inscripcions[j+1];
                    }
                    inscripcions[numElem-1] = null;
                    numElem--;
                    i--; 
                }
            }
        }
    }

    public Inscripcions[] getInscripcio(){
        return this.inscripcions;
    }

    public int getNumElements(){
        return numElem;
    }
     
    //metode per obtenir les inscripcions d'una activitat
    public Inscripcions getIncripcionsFromActivitat(Activitats act){
        Inscripcions inscripcio = null;
        boolean trobat=false;
        int i=0;
        while (!trobat && i<numElem){
            Activitats aux = inscripcions[i].getActivitat();
            if(aux.getNomActivitat().equals(act.getNomActivitat())){
                trobat=true;
                inscripcio=inscripcions[i];
            }else{
                i++;
            }
        }
        return inscripcio;
    }

    //metode que retorna la llista d'espera d'una activitat
    public LlistaInscripcio getLlistaEspera(Activitats act){
        // Crear una nueva lista para la espera
        LlistaInscripcio espera = new LlistaInscripcio(inscripcions.length);

        // Recorrer todas las inscripciones
        for(int i = 0; i < numElem; i++){
            Inscripcions incs = inscripcions[i];

            // Solo nos interesan las inscripciones de la actividad indicada
            if(incs.getActivitat().getNomActivitat().equals(act.getNomActivitat())){
                // Añadir todos los usuarios en espera
                for(int j = 0; j < incs.getNumEspera(); j++){
                    Usuari u = incs.getEspera(j);
                    espera.afegir(u, act); // Añadimos a la lista de espera
                }
            }
        }

        return espera;
    }
        
    //toString de la llista d'inscripcions
    @Override
    public String toString() {
        if(numElem == 0) return "La llista d'inscripcions està buida\n";

        StringBuilder sb = new StringBuilder("LLISTA D'INSCRIPCIONS;\n");
        for(int i = 0; i < numElem; i++) {
            if(inscripcions[i] != null) {
                sb.append(i + 1).append(". ").append(inscripcions[i].toString());
            }
        }
        return sb.toString();
    }
}

