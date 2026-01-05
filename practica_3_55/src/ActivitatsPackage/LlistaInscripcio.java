package ActivitatsPackage;
import java.time.LocalDate;

import UsuarisPackage.*;

public class LlistaInscripcio {
    private Inscripcions[] inscripcions;
    private int numElem;

    public LlistaInscripcio(int MAX) {
        inscripcions = new Inscripcions[MAX];
        numElem = 0;
    }

    private int posicioActivitat(Activitats a) {
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i].getActivitat() == a) return i;
        }
        return -1;
    }

    public void afegir(Usuari u, Activitats a) {
        int pos = posicioActivitat(a);

        if (pos != -1) {
            inscripcions[pos].inscriures(u);
            return;
        }

        // no existeix inscripció per aquesta activitat
        inscripcions[numElem] = new Inscripcions(a, 100);
        inscripcions[numElem].inscriures(u);
        numElem++;
    }

    public void eliminar(Usuari u, Activitats a) {
        int pos = posicioActivitat(a);
        if (pos != -1) {
            inscripcions[pos].eliminaDeActivitat(u);
        }
    }

    public void Elimina(Inscripcions inscripcio) {
        int pos = -1;
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i] == inscripcio) { pos = i; break; }
        }
        if (pos == -1) return;

        for (int j = pos; j < numElem - 1; j++) {
            inscripcions[j] = inscripcions[j + 1];
        }
        inscripcions[numElem - 1] = null;
        numElem--;
    }

    public LlistaActivitats ActivitatsPertanyUsuari(Usuari u) {
        LlistaActivitats activitats = new LlistaActivitats(numElem);

        for (int i = 0; i < numElem; i++) {
            LlistaUsuaris apuntats = inscripcions[i].getInscrits();
            boolean trobat = apuntats.BuscarUsuari(u);
            if (trobat) activitats.afegir(inscripcions[i].getActivitat());
        }
        return activitats;
    }

    public void DonarDeBaixaActivitat(LocalDate dataAvui) {
        LocalDate avui = dataAvui;

        for (int i = numElem - 1; i >= 0; i--) {
            boolean acabada = avui.isAfter(inscripcions[i].getActivitat().getDataFi());
            if (!acabada) continue;

            boolean donarBaixa = false;

            if (!(inscripcions[i].getActivitat() instanceof ActivitatsOnline)) {
                double percentatge = (double) inscripcions[i].getNumInscrits() / inscripcions[i].getNumPlaces();
                if (percentatge < 0.10) donarBaixa = true;
            } else {
                if (inscripcions[i].getNumInscrits() < 20) donarBaixa = true;
            }

            if (donarBaixa) Elimina(inscripcions[i]);
        }
    }

    public boolean tePlaces(Activitats a) {
        // Online: sempre places segons enunciat
        if (a instanceof ActivitatsOnline) return true;

        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i] != null && inscripcions[i].getActivitat() == a) {
                return inscripcions[i].getNumInscrits() < inscripcions[i].getNumPlaces();
            }
        }

        // Si encara no hi ha "Inscripcions" creada per aquesta activitat,
        // vol dir que ningú s'hi ha inscrit: per tant hi ha places
        return true;
    }
    public Inscripcions getInscripcioPos(int i){
        return inscripcions[i];
    }



    public void posarValoracio(Activitats act, Usuari u, int valoracio) {
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i].getActivitat() == act) {
                inscripcions[i].setValoracioUsuari(u, valoracio);
                return;
            }
        }
    }

    public Integer getValoracioUsuariEnActivitat(Activitats act, Usuari u) {
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i].getActivitat() == act) {
                return inscripcions[i].getValoracioUsuari(u);
            }
        }
        return null;
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
                Inscripcions inscripcio = activitats.getInscripcioPos(i);
                String valoracioString = "0.0";  // Valor per defecte
                
                if (inscripcio != null) {
                    LlistaUsuaris usuarisActivitat = inscripcio.getLlistaInscrits();
                    double total = 0;
                    int nValoracions = 0;
                    
                    // Calcular suma de valoracions
                    for (int j = 0; j < usuarisActivitat.getnUsuaris(); j++) {
                        Usuari usuari = usuarisActivitat.getUsuarisPos(j);
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

    public void AfegirInscripcio(Inscripcions ins) {
        inscripcions[numElem] = ins; numElem++;
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


