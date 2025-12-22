package e;
import ActivitatsPackage.*;

public class ExisteixActivitat extends Exception{
    public ExisteixActivitat(LlistaActivitats llistaActs, Activitats act){
        super("Aquesta activitat no existeix dins de la llista d'activitats"+llistaActs +act);
    }
}
