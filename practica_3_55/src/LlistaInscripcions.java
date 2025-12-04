
public class LlistaInscripcions {
    private Inscripcions[] inscripcions;
    private int numElem;

   public LlistaInscripcions(int MAX) {
        inscripcions = new Inscripcions[MAX];
        numElem=0;
   }
    public void Afegir(Inscripcions i ){
        inscripcions[numElem]=i;
        numElem++;
    }

    public void Elimina(Inscripcions inscripcio){
        boolean trobat=false;
        int i=0;
        while(!trobat){
            if(inscripcions[i]==inscripcio){
                trobat=true;
                for(int j=i; j<numElem; j++){
                    inscripcions[j]=inscripcions[j+1];
                }
                numElem--;
            }
        }
    }
}
