package ActivitatsPackage;

import java.time.LocalDate;

import UsuarisPackage.*;


public class LlistaActivitats {
    private Activitats[] llista;
    private int numElements;

    public LlistaActivitats(int mida){
        numElements=0;
        llista = new Activitats[mida];
    }

    public void afegir(Activitats a){
        llista[numElements]=a;
        numElements++;
    }

    public void elimina(Activitats a){
        boolean trobat = false;
        for (int i = 0; i < numElements; i++) {
            if (llista[i].equals(a)) {
                trobat = true;
                for (int j = i; j < numElements - 1; j++) {
                    llista[j] = llista[j + 1];
                }
                llista[numElements - 1] = null;
                numElements--;
            }
        }
        if (!trobat) {
            System.out.println("L'activitat no existeix a la llista.");
        }
    }


    public void setLlista(Activitats[] llista) {
        this.llista = llista;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public Activitats getActivitatPos(int i){
        return llista[i];
    }

    /**
     * Mètode que fa una llista amb totes les activitats acabades
     * Programadora: Aina Garcia Albesa
     * @param llista
     * @return llista de les activitats que ho estan
     */
    public LlistaActivitats actAcabades(LlistaInscripcio llista){
        LlistaActivitats activitatsAcabades= new LlistaActivitats(numElements);
        for (int i=0; i<llista.getNumElements(); i++ ){
            Inscripcions inscripcio=llista.getInscripcionsPos(i);
            if (inscripcio.getActivitat().haFinalitzat()){
                Activitats activitat=inscripcio.getActivitat();
                activitatsAcabades.afegir(activitat);
            }
        }
        return activitatsAcabades;
    /*NUEVO*/
    public Activitats trobaActivitat(String nomActivitat){
        Activitats informacioActivitat = null;
        int i=0;
        boolean trobat=false;
        while ((i<numElements) && (!trobat)){
            if (this.llista[i].getNomActivitat().equals(nomActivitat)){
                trobat=true;
                informacioActivitat=this.llista[i].copia();
            }
            i++;
        }
        return informacioActivitat;
    }

    /*NUEVO */
    public boolean hiHaActivitat(String nomActivitat){
        int i=0;
        boolean trobat=false;
        while ((i<numElements) && (!trobat)){
            if (this.llista[i].getNomActivitat().equals(nomActivitat)){
                trobat=true;
            }
            i++;
        }
        return trobat;
    }

    public Activitats getActivitatsPos(int i){
        return llista[i];
    }

    public void  setActivitatPos(int i, Activitats act){
        this.llista[i] = act;
    }

    //metode que retorna una llista d'activitats d'un dia en concret
    public LlistaActivitats activitatsAvui(LocalDate data){
        LlistaActivitats activitatsAvui = new LlistaActivitats(numElements);
        for(int i=0; i<numElements; i++){
            if(llista[i].getDataIni().isBefore(data)&&llista[i].getDataFi().isAfter(data)){
                activitatsAvui.afegir(llista[i].copia());
            }
        }
        return activitatsAvui;
    }

    //metode que retorna l'activitat segons el nom
    public Activitats getActivitatPerNom(String nom) {
        for (int i = 0; i < numElements; i++) {
            if (llista[i].getNomActivitat().equalsIgnoreCase(nom)) {
                return llista[i];
            }
        }
        return null;
    }   

    //toString de la llista
    @Override
    public String toString() {
        String resultat = "LLISTA D'ACTIVITATS:\n";
        for (int i = 0; i < numElements; i++) {
            Activitats a = llista[i];
            resultat = resultat + (i + 1) + ". " + a.getNomActivitat() 
                        + " | Data Inici: " + a.getDataIni() 
                        + " | Data Fi: " + a.getDataFi() + "\n";
        }
        if (numElements == 0) resultat = resultat + "No hi ha activitats.\n";
        return resultat;
    }




}
