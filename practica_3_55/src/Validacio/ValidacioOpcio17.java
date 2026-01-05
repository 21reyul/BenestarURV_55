package Validacio;

import ActivitatsPackage.*;
import UsuarisPackage.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ValidacioOpcio17 {
     public static void main(String[] args) throws Exception {
        System.out.println("--- VALIDACIO OPCIO 17 ---");

        ActivitatsPeriodiques actPer1 = new ActivitatsPeriodiques("Curs B2 d'angles per a estudiants", false, false, true, 
            LocalDate.of(2025, 9, 5), LocalDate.of(2025, 9, 22), "dijous", "Campus Catalunya", "Tarragona", 
            LocalTime.of(17, 30), LocalDate.of(2025, 10, 15), 20, 25, 100.0);
        
        ActivitatsUnDia actDia2 = new ActivitatsUnDia("Senderisme", true, true, true, 
            LocalDate.of(2025, 12, 2), LocalDate.of(2025, 12, 9), 40, 10.0, "Amposta", LocalTime.of(10, 0));
        
        Inscripcions inscripcio1 = new Inscripcions(actPer1, 20);
        Inscripcions inscripcio2 = new Inscripcions(actDia2, 15);
        
        
        Estudiants estudiant1 = new Estudiants("Anna", "anna.g", "GEI", 2024);
        Estudiants estudiant2 = new Estudiants("Marc", "marc.b", "GES", 2023);
        PDI pdi1 = new PDI("Dr. Garcia", "garcia.p", "DEIM", "Sescelades");
        PTGAS ptgas1 = new PTGAS("Eustaquio", "eusta", "Catalunya");
        
        // Afegir usuaris a les inscripcions
        inscripcio1.inscriures(estudiant1);
        inscripcio1.inscriures(pdi1);
        inscripcio2.inscriures(estudiant2);
        inscripcio2.inscriures(ptgas1);

        validacioGetValoracioUsuari(estudiant1, estudiant2, pdi1, inscripcio1);
        validacioCalcularValoracio(estudiant1, estudiant2, pdi1, ptgas1, actPer1, actDia2);

        System.out.println("\n--- FINAL VALIDACIO OPCIO 17 ---");
     }

    private static void validacioGetValoracioUsuari(Estudiants estudiant1, Estudiants estudiant2, PDI pdi1, Inscripcions inscripcio1){
        System.out.println("--- Validacio getValoracioUsuari()");

        // Creem una llista d'usuaris.
        LlistaUsuaris llistaUsuaris = new LlistaUsuaris(10);
        llistaUsuaris.Afegir(estudiant1);
        llistaUsuaris.Afegir(estudiant2);
        llistaUsuaris.Afegir(pdi1);

        // Afegim valoracions.
        inscripcio1.puntuar(8.5, estudiant1);
        inscripcio1.puntuar(7.0, pdi1);

        // Usuari que ha valorat.
        System.out.println("Usuari que ha valorat.");
        Integer valoracioEst1 = llistaUsuaris.getValoracioUsuari(estudiant1, inscripcio1);
        System.out.println("Usuari: " + estudiant1.getAlies());
        System.out.println("Esperat: 9 (arrodonit de 8.5)");
        System.out.println("Obtingut: " + valoracioEst1);

        // Usuari que no ha valorat.
        System.out.println("Usuari que no ha valorat.");
        Integer valoracioEst2 = llistaUsuaris.getValoracioUsuari(estudiant2, inscripcio1);
        System.out.println("Usuari: " + estudiant1.getAlies());
        System.out.println("Esperat: null (no ha valorat)");
        System.out.println("Obtingut: " + valoracioEst2);

        // No hi ha inscripcio (null).
        System.out.println("No hi ha inscripcio (null)");
        Integer valoracioInscNull = llistaUsuaris.getValoracioUsuari(estudiant1, null);
        System.out.println("   Inscripció: null");
        System.out.println("   Esperat: null");
        System.out.println("   Obtingut: " + valoracioInscNull);
     }

    private static void validacioCalcularValoracio(Estudiants estudiant1, Estudiants estudiant2, PDI pdi1, PTGAS ptgas1, ActivitatsPeriodiques actPer1, ActivitatsUnDia actDia2){
        System.out.println("--- Validacio calcularValoracio()");
        
        ActivitatsUnDia activitatAcabada = new ActivitatsUnDia("Taller de Java 2024", true, true, true,
            LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 31), 25, 0.0, "Tarragona", LocalTime.of(15, 0));
        
        // Creem inscripcions per a activitats acabades
        Inscripcions inscAcabada1 = new Inscripcions(activitatAcabada, 10);
        Inscripcions inscAcabada2 = new Inscripcions(activitatAcabada, 15);
        
        // Inscrivim i valorem
        inscAcabada1.inscriures(estudiant1);
        inscAcabada1.inscriures(pdi1);
        inscAcabada1.puntuar(8.5, estudiant1);  
        inscAcabada1.puntuar(7.0, pdi1);   
        
        inscAcabada2.inscriures(estudiant2);
        inscAcabada2.inscriures(ptgas1);
        inscAcabada2.puntuar(9.5, estudiant2);
        inscAcabada2.puntuar(8.0, ptgas1);      
        
        // Creem LlistaInscripcio per a activitats acabades
        LlistaInscripcio inscripcionsAcabades = new LlistaInscripcio(10);
        inscripcionsAcabades.Afegir(estudiant1, activitatAcabada);
        inscripcionsAcabades.Afegir(estudiant2, activitatAcabada);
        
        System.out.println("Prova: Calcular valoracions d'activitats acabades");
        String[] valoracions = inscripcionsAcabades.calcularValoracio(inscripcionsAcabades);
        for (int i = 0; i < valoracions.length; i++) {
            if (valoracions[i] != null) {
                System.out.println("Resultat " + (i+1) + ": " + valoracions[i]);
            }
        }
     }
}