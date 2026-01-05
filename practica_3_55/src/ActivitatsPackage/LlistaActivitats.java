package ActivitatsPackage;

import java.time.LocalDate;
import java.util.Arrays;


public class LlistaActivitats {
    private Activitats[] llista;
    private int numElements;

    public LlistaActivitats(int mida){
        numElements=0;
        llista = new Activitats[mida];
    }

    public void Afegir(Activitats a ){
        llista[numElements]=a;
        numElements++;
    }

    public void Elimina(Activitats a) {
        int i = 0;
        boolean trobat = false;

        while (!trobat && i < numElements) {
            if (llista[i] == a) trobat = true;
            else i++;
        }

        if (trobat) {
            for (int j = i; j < numElements - 1; j++) {
                llista[j] = llista[j + 1];
            }
            llista[numElements - 1] = null;
            numElements--;
        }
    }

    public Activitats[] getLlista() {
        return llista;
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

    public Activitats getActivitat(int i){
        return llista[i];
    }

    public LlistaActivitats ActivitatsEnPeriode(LocalDate avui){
        LlistaActivitats activitatsActives = new LlistaActivitats(numElements);
        for(int i=0; i<numElements; i++){
            if((llista[i].getDataINI().isBefore(avui)&&llista[i].getDataFi().isAfter(avui))||llista[i].getDataFi().isEqual(avui)||llista[i].getDataINI().isEqual(avui)){
                activitatsActives.Afegir(llista[i]);
            }
        }
        return(activitatsActives);
    }

    public LlistaActivitats ActivitatsActives(LocalDate avui){
        LlistaActivitats activitatsActives = new LlistaActivitats(numElements);
        for(int i=0; i<numElements; i++){
            if((llista[i].getDataINI().isBefore(avui)&&llista[i].getDataFi().isAfter(avui))||llista[i].getDataFi().isEqual(avui)||llista[i].getDataINI().isEqual(avui)){
                activitatsActives.Afegir(llista[i]);
            }
        }
        return(activitatsActives);
    }

    public void MostrarNoms(){
        System.out.println("Les activitats que estan actives avui:");
        for(int i=0; i<numElements; i++){
            System.out.println(llista[i].getNomActivitat());
        }
    }

    @Override
    public String toString() {
        return "LlistaActivitats [llista=" + Arrays.toString(llista) + "]";
    }

    

}
