package ActivitatsPackage;
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
                activitatsAcabades.Afegir(activitat);
            }
        }
        return activitatsAcabades;
    }

}
