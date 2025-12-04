package ActivitatsPackage;
import UsuarisPackage.*;

public class Inscripcions {
     private LlistaUsuaris llistaInscrits;
     private LlistaUsuaris llistaDeEspera;
     private int NumPlaçes, nApuntats, nEspera;
     private Activitats a;
     private double puntuacio;
     private static int MAX =30;


     public Inscripcions(int numPlaçes, Activitats a) {
        NumPlaçes = numPlaçes;
        llistaInscrits = new LlistaUsuaris(numPlaçes);
        llistaDeEspera = new LlistaUsuaris(MAX);
        nApuntats=0;
        nEspera=0;
        this.a = a;
     }
     
     public LlistaUsuaris getLlistaInscrits() {
        return llistaInscrits;
    }

     public void setLlistaInscrits(LlistaUsuaris llistaInscrits) {
         this.llistaInscrits = llistaInscrits;
     }

     public LlistaUsuaris getLlistaDeEspera() {
         return llistaDeEspera;
     }

     public void setLlistaDeEspera(LlistaUsuaris llistaDeEspera) {
         this.llistaDeEspera = llistaDeEspera;
     }

     public int getNumPlaçes() {
         return NumPlaçes;
     }

     public void setNumPlaçes(int numPlaçes) {
         NumPlaçes = numPlaçes;
     }

     public Activitats getA() {
         return a;
     }

     public void setA(Activitats a) {
         this.a = a;
     }

     public static int getMAX() {
         return MAX;
     }

     public static void setMAX(int mAX) {
         MAX = mAX;
     }

   
    public String toString() {
        return "Inscripcions [llistaInscrits=" + llistaInscrits + ", llistaDeEspera=" + llistaDeEspera + ", NumPlaçes="
                + NumPlaçes + ", nApuntats=" + nApuntats + ", nEspera=" + nEspera + ", a=" + a + "]";
    }

    public void inscriures(Usuaris a){
        if(nApuntats<NumPlaçes){
            llistaInscrits.Afegir(a);
            nApuntats++;
        }
        else{
            llistaDeEspera.Afegir(a);
            nEspera++;
        }
    }

    public void baixa(Usuaris a){
        llistaInscrits.Elimina(a);
        Usuaris afegirEnLlista = llistaDeEspera.getUsuarisPos(0);
        llistaDeEspera.Elimina(afegirEnLlista);
        llistaInscrits.Afegir(afegirEnLlista);
    }

    public void puntuar(double pun, Usuaris u){
        boolean trobat=false;
        int i=0;
        while(!trobat&&i<NumPlaçes){
            if(u.getAlies().equals(llistaInscrits.getUsuarisAliesPos(i))){
                trobat=true;
            }
            else{
                i++;
            }
        }
        if(trobat&&pun<11&&pun>0){
            this.puntuacio=pun;
        }
    }

     
}
