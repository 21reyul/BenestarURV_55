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

   public Activitats getLlistaInscritsPos(int i){
        return this.inscripcions[i].getActivitat();
    }
    
    public LlistaUsuaris getLlistaUsuarisInscrits(int i){ //Usuaris inscrits en una act
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

    // Programadora: Aina Garcia Albesa
    public String[] calcularValoracio(LlistaInscripcio activitats){
        double valoracio, total=0;
        int nValoracions;
        LlistaUsuaris usuarisActivitat;
        int numActivitats=activitats.getNumElements();
        String [] valoracioActivitats= new String[numActivitats];
        ;
        for (int i=0; i<numActivitats; i++){
            Inscripcions inscripcio = activitats.getInscripcionsPos(i);
            usuarisActivitat = activitats.getLlistaUsuarisInscrits(i); // Llista usuaris de l'activitat
            
            for (int j=0; j<usuarisActivitat.getNumElements(); j++){
                total= total + usuarisActivitat.getUsuarisPos(j).getValoracio();
                nValoracions++;
            }
            valoracio= total/nValoracions;
            valoracioActivitats[i]= activitats[i]+":"+valoracio;
        }
        
        return valoracioActivitats;
    }
}

