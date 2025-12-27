package Validacio;

import ActivitatsPackage.*;
import UsuarisPackage.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ValidacioOpcio10 {

    public static void main(String[] args) {
        System.out.println("--- INICI VALIDACIÓ MÈTODES OPCIÓ 10 ---");

        ActivitatsUnDia taller = new ActivitatsUnDia("Taller Java", true, true, true, 
                                    LocalDate.now(), LocalDate.now().plusDays(1), 
                                    1, 10.0, "Reus", LocalTime.of(10, 0));
        
        Estudiants usuari1 = new Estudiants("Joan88", "joan@urv.cat", "GEI", 2024);
        Estudiants usuari2 = new Estudiants("Marta99", "marta@urv.cat", "GEI", 2024);

        Inscripcions ins = new Inscripcions(taller, 1);

        // Mirem si l'usuari existeix i si és així l'inscrivim si hi ha places.
        System.out.println("\nVerificant si " + usuari1.getAlies() + " està inscrit...");
        
        if (estaInscrit(ins, usuari1)) {
            System.out.println("L'usuari ja inscrit.");
        } else {
            System.out.println("L'usuari no esta inscrit. Procedim a inscriure.");
            
            
            int nInscritsAbans = ins.getLlistaInscrits().getnUsuaris();
            
            ins.inscriures(usuari1);
            
            if (ins.getLlistaInscrits().getnUsuaris() > nInscritsAbans) {
                System.out.println("L'usuari s'ha inscrit.");
            }
        }

        // Comprovem que si no hi ha plaça s'afegeixi a la llista d'espera.
        System.out.println("\nPlaces exhaurides");
        
        if (!estaInscrit(ins, usuari2)) {
            int nInscritsAbans = ins.getLlistaInscrits().getnUsuaris();
            int nEsperaAbans = ins.getNumEspera();
            
            ins.inscriures(usuari2);
            
            if (ins.getLlistaInscrits().getnUsuaris() > nInscritsAbans) {
                System.out.println("RESULTAT: L'usuari "+usuari2.getAlies()+" s'ha inscrit (Error: no hauria de passar)");
            } else if (ins.getNumEspera() > nEsperaAbans) {
                System.out.println("RESULTAT: L'usuari "+usuari2.getAlies()+" ha entrat a la llista d'espera");
            }
        }

        // Provem d'inscriure un usuari que ja ho està
        System.out.println("\nIntentant inscriure de nou a " + usuari1.getAlies() + "...");
        if (estaInscrit(ins, usuari1)) {
            System.out.println("L'usuari "+usuari1.getAlies()+" ja esta inscrit.");
        }

        System.out.println("\n--- FINAL VALIDACIO OPCIO 10 ---");
    }

    
    private static boolean estaInscrit(Inscripcions ins, Usuaris u) {
        return (buscarAliesEnLlista(ins.getLlistaInscrits(), u.getAlies()) || 
                buscarAliesEnLlista(ins.getLlistaDeEspera(), u.getAlies()));
    }

    private static boolean buscarAliesEnLlista(LlistaUsuaris llista, String alies) {
        boolean trobat = false;
        int i = 0;
        while (i < llista.getnUsuaris() && !trobat) {
            if (llista.getUsuarisPos(i).getAlies().equals(alies)) {
                trobat = true;
            }
            i++;
        }
        return trobat;
    }
}