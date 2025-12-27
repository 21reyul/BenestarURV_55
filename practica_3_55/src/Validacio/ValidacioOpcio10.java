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
        System.out.println("\n[PAS 1] Verificant si " + usuari1.getAlies() + " està inscrit...");
        
        if (estaInscrit(ins, usuari1)) {
            System.out.println("L'usuari ja està a la llista.");
        } else {
            System.out.println("L'usuari no hi és. Procedim a inscriure.");
            
            
            int nInscritsAbans = ins.getLlistaInscrits().getnUsuaris();
            
            ins.inscriures(usuari1);
            
            if (ins.getLlistaInscrits().getnUsuaris() > nInscritsAbans) {
                System.out.println("RESULTAT: " + usuari1.getAlies() + " ha ocupat una plaça PRINCIPAL.");
            }
        }

        // Comprovem que si no hi ha plaça s'afegeixi a la llista d'espera.
        System.out.println("\n[PAS 2] Intentant inscriure a " + usuari2.getAlies() + " (Places plenes)...");
        
        if (!estaInscrit(ins, usuari2)) {
            int nInscritsAbans = ins.getLlistaInscrits().getnUsuaris();
            int nEsperaAbans = ins.getNumEspera();
            
            ins.inscriures(usuari2);
            
            if (ins.getLlistaInscrits().getnUsuaris() > nInscritsAbans) {
                System.out.println("RESULTAT: Ha entrat a la principal (Error: no hauria de passar)");
            } else if (ins.getNumEspera() > nEsperaAbans) {
                System.out.println("RESULTAT: " + usuari2.getAlies() + " ha anat correctament a la LLISTA D'ESPERA.");
            }
        }

        // Provem d'inscriure un usuari que ja ho està
        System.out.println("\n[PAS 3] Intentant inscriure de nou a " + usuari1.getAlies() + "...");
        if (estaInscrit(ins, usuari1)) {
            System.out.println("L'usuari "+usuari1.getAlies()+" ja esta inscrit.");
        }

        System.out.println("\n--- FINAL VALIDACIÓ OPCIÓ 10 ---");
    }

    /**
     * Replicació del mètode de l'App (Un sol return)
     */
    private static boolean estaInscrit(Inscripcions ins, Usuaris u) {
        return (buscarAliesEnLlista(ins.getLlistaInscrits(), u.getAlies()) || 
                buscarAliesEnLlista(ins.getLlistaDeEspera(), u.getAlies()));
    }

    /**
     * Cercador d'àlies (Mètode que l'App fa servir internament)
     */
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