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
        boolean trobat=false;
        int i=0;
        while(!trobat){
            if(llista[i]==a){
                trobat=true;
                for(int j=i; j<numElements; j++){
                    llista[j]=llista[j+1];
                }
                numElements--;
            }
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
            if (llista[i].getNomActivitat().equals(nom)) {
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
