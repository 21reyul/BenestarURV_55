import UsuarisPackage.Usuari;

public class Inscripcio {
     private LlistaUsuaris llistaInscrits;
     private LlistaUsuaris llistaDeEspera;
     private int numPlaces, nApuntats, nEspera;
     private Activitat a;
     private double puntuacio;
     private static int MAX =30;


     public Inscripcio(int numPlaçes, Activitat a) {
        numPlaces = numPlaçes;
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

     public int getNumPlaces() {
         return numPlaces;
     }

     public void setNumPlaçes(int numPlaçes) {
         numPlaces = numPlaçes;
     }

     public Activitat getA() {
         return a;
     }

     public void setA(Activitat a) {
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
                + numPlaces + ", nApuntats=" + nApuntats + ", nEspera=" + nEspera + ", a=" + a + "]";
    }

    public void inscriures(Usuari a){
        if(nApuntats<numPlaces){
            llistaInscrits.Afegir(a);
            nApuntats++;
        }
        else{
            llistaDeEspera.Afegir(a);
            nEspera++;
        }
    }

    public void baixa(Usuari a){
        llistaInscrits.elimina(a);
        Usuari afegirEnLlista = llistaDeEspera.getUsuarisPos(0);
        llistaDeEspera.Elimina(afegirEnLlista);
        llistaInscrits.Afegir(afegirEnLlista);
    }

    public void puntuar(double pun, Usuari u){
        boolean trobat=false;
        int i=0;
        while(!trobat&&i<numPlaces){
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
