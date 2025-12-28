package ActivitatsPackage;
import UsuarisPackage.LlistaUsuaris;
import UsuarisPackage.Usuaris;

public class LlistaInscripcio{
    private Inscripcions[] inscripcions;
    private int numElem;

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

    public void Afegir(Usuaris u, Activitats a){
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
    public void eliminar(Usuaris u, Activitats a){
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
            inscripcions[i].eliminaDeActivitat(u);;
        }
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

}

