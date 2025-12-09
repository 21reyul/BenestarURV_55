package ActivitatsPackage;
import UsuarisPackage.Usuaris;

public class LlistaInscripcio{
    private Inscripcions[] inscripcions;
    private int numElem;

   public LlistaInscripcio(int MAX) {
        inscripcions = new Inscripcions[MAX];
        numElem=0;
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
            inscripcions[i].afegirAActivitat(u);
        }
        else{
            inscripcions[i]= new Inscripcions(a, 100);
            inscripcions[i].afegirAActivitat(u);
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
            inscripcions[i].EliminaDeActivitat(u);;
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
}

