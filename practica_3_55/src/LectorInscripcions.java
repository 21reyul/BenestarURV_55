import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ActivitatsPackage.*;
import UsuarisPackage.*;

public class LectorInscripcions {

    public static void llegirFitxer(
            LlistaInscripcio llistaIns,
            LlistaActivitats llistaAct,
            LlistaUsuaris llistaUsu) {

        File fitxer = new File("\\C:\\Users\\aroag\\Desktop\\BenestarURV_55\\practica_3_55\\src\\Inscripcions.txt\\");

        try (Scanner sc = new Scanner(fitxer)) {

            int liniaNum = 0;

            while (sc.hasNextLine()) {
                liniaNum++;
                String linia = sc.nextLine().trim();

                if (linia.isEmpty() || linia.startsWith("#")) continue;

                String[] parts = linia.split(";");
                if (parts.length < 2) {
                    System.err.println("Línia " + liniaNum + " incorrecta");
                    continue;
                }

                String nomAct = parts[0].trim();
                String aliesUsu = parts[1].trim();
                String valoracioTxt = (parts.length >= 3) ? parts[2].trim() : "-";

                Activitats act = buscarActivitat(llistaAct, nomAct);
                if (act == null) {
                    System.err.println("Línia " + liniaNum + ": activitat no trobada -> " + nomAct);
                    continue;
                }

                Usuari usu = buscarUsuari(llistaUsu, aliesUsu);
                if (usu == null) {
                    usu = new Usuari(aliesUsu, "senseCorreu");
                    llistaUsu.afegir(usu);
                }

                llistaIns.afegir(usu, act);


                if (!valoracioTxt.equals("-")) {
                    try {
                        int v = Integer.parseInt(valoracioTxt);
                        if (v < 0 || v > 10) {
                            System.err.println("Línia " + liniaNum + ": valoració fora de rang");
                            continue;
                        }
                        llistaIns.posarValoracio(act, usu, v);
                    } catch (NumberFormatException e) {
                        System.err.println("Línia " + liniaNum + ": valoració incorrecta");
                    }
                }
            }

            System.out.println("Inscripcions llegides correctament.");

        } catch (FileNotFoundException e) {
            System.err.println("No s'ha trobat Inscripcions.txt");
        }
    }

    private static Activitats buscarActivitat(LlistaActivitats llista, String nom) {
        for (int i = 0; i < llista.getNumElements(); i++) {
            Activitats a = llista.getActivitat(i);
            if (a.getNomActivitat().equalsIgnoreCase(nom)) return a;
        }
        return null;
    }

    private static Usuari buscarUsuari(LlistaUsuaris llista, String alies) {
        for (int i = 0; i < llista.getnUsuaris(); i++) {
            Usuari u = llista.getUsuarisPos(i);
            if (u.getAlies().equalsIgnoreCase(alies)) return u;
        }
        return null;
    }
}

