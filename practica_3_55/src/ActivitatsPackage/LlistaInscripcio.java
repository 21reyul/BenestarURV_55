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

    public int getNumElements(){
        return this.numElem;
    }

    public Inscripcions getInscripcionsPos(int i) {
        if (i >= 0 && i < numElem) {
            return inscripcions[i];
        }
        return null;
    }   

    /**
     * Getter de l'activitat en la posició determinada d'una llista
     * @param i posició
     * @return activitat
     */
    public Activitats getLlistaInscritsPos(int i){
        return this.inscripcions[i].getActivitat();
    }
    
    /**
     * Getter dels usuaris inscrits en una activitat
     * @param i
     * @return llista d'usuaris inscrits en una activitat
     */
    public LlistaUsuaris getLlistaUsuarisInscrits(int i){ 
        return this.inscripcions[i].getLlistaInscrits();
    }

    public void afegir(Usuari u, Activitats a){
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
            inscripcions[i].inscriures(u);
        }
        else{
            inscripcions[i]= new Inscripcions(a, 100);
            inscripcions[i].inscriures(u);
        }
    }
    public Inscripcions getInscripcioPos(int i){
        return inscripcions[i];
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

    /**
     * Mètode que fa un resum de les valoracions de les activitats
     * d'una llista
     * Programadora: Aina Garcia Albesa
     * @param activitats
     * @return llista amb nom de l'activitat i valoració
     */
    public String[] calcularValoracio(LlistaInscripcio activitats) {
        String[] valoracioActivitats = null;  // Únic return
        
        if (activitats != null) {
            int numActivitats = activitats.getNumElements();
            valoracioActivitats = new String[numActivitats];
            
            for (int i = 0; i < numActivitats; i++) {
                Inscripcions inscripcio = activitats.getInscripcionsPos(i);
                String valoracioString = "0.0";  // Valor per defecte
                
                if (inscripcio != null) {
                    LlistaUsuaris usuarisActivitat = inscripcio.getLlistaInscrits();
                    double total = 0;
                    int nValoracions = 0;
                    
                    // Calcular suma de valoracions
                    for (int j = 0; j < usuarisActivitat.getnUsuaris(); j++) {
                        Usuaris usuari = usuarisActivitat.getUsuarisPos(j);
                        Integer val = usuarisActivitat.getValoracioUsuari(usuari, inscripcio);
                        
                        if (val != null) {
                            total += val;
                            nValoracions++;
                        }
                    }
                    
                    // Calcular mitjana
                    double mitjana = 0;
                    if (nValoracions > 0) {
                        mitjana = total / nValoracions;
                    }
                    
                    Activitats activitat = inscripcio.getActivitat();
                    valoracioString = activitat.getNomActivitat() + ": " + String.format("%.2f", mitjana);
                }
                
                valoracioActivitats[i] = valoracioString;
            }
        }
        
        return valoracioActivitats;
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

