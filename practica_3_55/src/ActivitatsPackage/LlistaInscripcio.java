package ActivitatsPackage;
import java.time.LocalDate;

import UsuarisPackage.LlistaUsuaris;
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
            inscripcions[i].afegirActivitat(u);
        }
        else{
            inscripcions[i]= new Inscripcions(a, 100);
            inscripcions[i].afegirActivitat(u);
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



    public LlistaActivitats ActivitatsPertanyUsuari(Usuaris u){
      LlistaUsuaris apuntats;
      LlistaActivitats activitatsApuntat = new LlistaActivitats(numElem);
      for(int i=0; i<numElem; i++){
        apuntats=inscripcions[i].getInscrits();
        boolean trobat = apuntats.BuscarUsuari(u);
        if(trobat){
            activitatsApuntat.Afegir(inscripcions[i].getActivitat());
        }
      }
      return activitatsApuntat; 
    }

    public void DonarDeBaixaActivitat(){
        LocalDate avui = LocalDate.now();
        for(int i=numElem-1; i>=0; i--){
            boolean inscripcioAcabada = avui.isAfter(inscripcions[i].getActivitat().getDataFi());
            boolean heDeDonarseDeBaixa = false;
            if(inscripcioAcabada){
                if(!(inscripcions[i].getActivitat() instanceof ActivitatsOnline)){
                    double percentatgeAssolit = (double) inscripcions[i].getNumInscrits()/inscripcions[i].getNumPlaces();
                    if(percentatgeAssolit<0.10){
                        heDeDonarseDeBaixa=true;
                    }
                }
                if(inscripcions[i].getActivitat() instanceof ActivitatsOnline){
                    if(inscripcions[i].getNumInscrits()<20){
                        heDeDonarseDeBaixa=true;
                    }
                }
                if(heDeDonarseDeBaixa){
                    this.Elimina(inscripcions[i]);;
                }
            }
        }
    }
}

