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
            if(inscripcions[i] != null && inscripcions[i].getActivitat() == a){
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
        String resultat = "LLISTA D'INSCRIPCIONS;\n";
        for (int i = 0; i < numElem; i++) {
            Inscripcions ins = inscripcions[i];
            resultat = resultat + (i + 1) + ". Activitat: " + ins.getActivitat().getNomActivitat() + "\n";
            resultat = resultat + "   -> Inscrits (" + ins.getNumInscrits() + "): ";
            for (int j = 0; j < ins.getNumInscrits(); j++) {
                resultat = resultat + ins.getInscrit(j).getAlies();
                if (j < ins.getNumInscrits() - 1) resultat = resultat + ", ";
            }
            resultat = resultat + "\n";
            resultat = resultat + "   -> En espera (" + ins.getNumEspera() + "): ";
            for (int j = 0; j < ins.getNumEspera(); j++) {
                resultat = resultat + ins.getEspera(j).getAlies();
                if (j < ins.getNumEspera() - 1) resultat = resultat + ", ";
            }
            resultat = resultat + "\n";
        }
        if (numElem == 0) resultat = resultat + "La llista d'inscripcions esta buida\n";
        return resultat;
    }

}

