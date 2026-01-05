package GUI;

import ActivitatsPackage.*;
import Lectors.*;
import UsuarisPackage.*;

public class Main {
    public static void main(String[] args) {
        LlistaActivitats a;
        LlistaInscripcio i;
        LlistaUsuaris u;
        a= new LlistaActivitats(100);
        i= new LlistaInscripcio(100);
        u= new LlistaUsuaris(100);

        LectorActivitats.llegirFitxer(a);
        LectorUsuaris.llegirFitxer(u);
        LectorInscripcions.llegirFitxer(i, a, u);
        
        // Mostrar el calendari
        CalendariActivitatsGUI.mostrarCalendari(a, i);
    }
}