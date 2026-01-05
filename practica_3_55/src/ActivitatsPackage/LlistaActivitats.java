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

    public String toString(){
        String aux=null;
        for (int i=0; i<numElements; i++){
            aux+=llista[i].toString();
        }
        return aux;
    }

}
