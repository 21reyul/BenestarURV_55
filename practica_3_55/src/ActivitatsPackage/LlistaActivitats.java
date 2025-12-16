package ActivitatsPackage;

import java.time.LocalDate;

import UsuarisPackage.Usuaris;

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

    public void Elimina(Activitats a){
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

    public LlistaActivitats ActivitatsEncaraActives(){
        LocalDate avui = LocalDate.now();
        LlistaActivitats activitatsActives = new LlistaActivitats(numElements);
        for(int i=0; i<numElements; i++){
            if(avui.isBefore(llista[i].getDataFi())){
                activitatsActives.Afegir(llista[i]);
            }
        }
        return(activitatsActives);
    }

    public LlistaActivitats ActivitatsActives(){
        LocalDate avui = LocalDate.now();
        LlistaActivitats activitatsActives = new LlistaActivitats(numElements);
        for(int i=0; i<numElements; i++){
            if((llista[i].getDataINI().isBefore(avui)&&llista[i].getDataFi().isAfter(avui))||llista[i].getDataFi().isEqual(avui)||llista[i].getDataINI().isEqual(avui)){
                activitatsActives.Afegir(llista[i]);
            }
        }
        return(activitatsActives);
    }

    

}
