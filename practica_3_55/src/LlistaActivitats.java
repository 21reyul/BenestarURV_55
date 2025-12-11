public class LlistaActivitats {
    private Activitat[] llista;
    private int numElements;

    public LlistaActivitats(int mida){
        numElements=0;
        llista = new Activitat[mida];
    }

    public void Afegir(Activitat[] act ){
        llista[numElements]=act;
        numElements++;
    }

    public void Elimina(Activitat a){
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
    public Activitat[] getLlista() {
        return llista;
    }

    public void setLlista(Activitat[] llista) {
        this.llista = llista;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

}
