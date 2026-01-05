package Exception;
import ActivitatsPackage.*;

public class NoExisteixActivitat extends Exception{
    public NoExisteixActivitat(String nomAct){
        super("L'activitat" +nomAct + "no existeix a la llista");
    }
}
