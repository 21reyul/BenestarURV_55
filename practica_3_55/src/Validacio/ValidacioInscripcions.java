package Validacio;

import java.time.LocalDate;
import java.time.LocalTime;

import ActivitatsPackage.*;
import UsuarisPackage.Usuaris;

/* Programadora: Aina Garcia Albesa */

/* VALIDACIO INSCRIPCIONS */
public class ValidacioInscripcions {
    public static void main(String[] args) throws Exception {
        ActivitatsPeriodiques actPer1 = new ActivitatsPeriodiques("Curs B2 d'angles per a estudiants", false, false, true, LocalDate.of(2025, 9, 5) , 
                                                LocalDate.of(2025, 9, 22), "dijous", "Campus Catalunya", "Tarragona", LocalTime.of(17, 30), 
                                                LocalDate.of(2025, 10, 15), 20, 25, 100.0);
            
        ActivitatsUnDia actDia2 = new ActivitatsUnDia("Senderisme", true, true, true, LocalDate.of(2025, 12, 2), 
                                                LocalDate.of(2025, 12, 9), 40, 10.0, "Amposta", LocalTime.of(10, 0)); 

        Inscripcions inscripcio1 = new Inscripcions (20, actPer1);
        Inscripcions inscripcio2 = new Inscripcions (15, actDia2);

        // getters
        System.out.println("Informacio inscripcio 1 inicial =>\n Places = " + inscripcio1.getNumPlaçes() + 
                            "\n Activitat = " + inscripcio1.getA().getNomActivitat() +
                            "\n MAX = " + Inscripcions.getMAX() + "\n");
        
        System.out.println("Informacio inscripcio 2 inicial =>\n Places = " + inscripcio2.getNumPlaçes() + 
                            "\n Activitat = " + inscripcio2.getA().getNomActivitat() +
                            "\n MAX = " + Inscripcions.getMAX() + "\n");

        // setters
        inscripcio1.setNumPlaçes(25);
        Inscripcions.setMAX(50); 
        
        System.out.println("Informacio inscripcio 1 modificada =>\n Places = " + inscripcio1.getNumPlaçes() + 
                         "\n MAX = " + Inscripcions.getMAX() + "\n");

        // Creació d'usuaris per proves
        Usuaris usuari1 = new Usuaris("anna123", "anna.garcia@estudiants.urv.cat");
        Usuaris usuari2 = new Usuaris("marc45", "marc.lopez@estudiants.urv.cat");
        Usuaris usuari3 = new Usuaris("julia99", "julia.martinez@estudiants.urv.cat");
        Usuaris usuari4 = new Usuaris("carlos77", "carlos.sarria@urv.cat");
        Usuaris usuari5 = new Usuaris("laura22", "laura.fernandez@urv.cat");

       // Proves d'inscripció
        System.out.println("\n=== PROVES D'INSCRIPCIÓ ===");
        
        System.out.println("Inscripció usuari 1 a activitat 1 (Curs B2):");
        inscripcio1.inscriures(usuari1);
        System.out.println("Usuari inscrit: " + usuari1.getAlies());
        
        System.out.println("\nInscripció usuari 2 a activitat 1:");
        inscripcio1.inscriures(usuari2);
        System.out.println("Usuari inscrit: " + usuari2.getAlies());

        // Prova de llista d'espera
        System.out.println("\n=== PROVA LLISTA D'ESPERA ===");
        System.out.println("Places totals a activitat 1: " + inscripcio1.getNumPlaçes());
        
        // Inscrivim més usuaris per omplir les places
        System.out.println("\nInscrivint més usuaris per omplir places:");
        for (int i = 0; i < 18; i++) { // Ja tenim 2, en falta 18 per arribar a 20
            Usuaris usuariExtra = new Usuaris("extra" + i, "extra" + i + "@urv.cat");
            inscripcio1.inscriures(usuariExtra);
            System.out.println("Usuari extra" + i + " inscrit");
        }
        
        System.out.println("\nIntentant inscriure un usuari extra (hauria d'anar a llista d'espera):");
        Usuaris usuariEspera = new Usuaris("espera1", "espera@urv.cat");
        inscripcio1.inscriures(usuariEspera);
        System.out.println("Usuari " + usuariEspera.getAlies() + " afegit a llista d'espera");

        // Mostrem estat actual
        System.out.println("\nEstat actual de l'inscripció 1:");
        System.out.println("Places: " + inscripcio1.getNumPlaçes());
        System.out.println("Llista inscrits: " + inscripcio1.getLlistaInscrits());
        System.out.println("Llista d'espera: " + inscripcio1.getLlistaDeEspera());

        // Prova de baixa
        System.out.println("\n=== PROVA DE BAIXA ===");
        System.out.println("Donem de baixa a l'usuari 1:");
        inscripcio1.baixa(usuari1);
        System.out.println("Baixa realitzada per a: " + usuari1.getAlies());
        
        System.out.println("\nEstat després de la baixa:");
        System.out.println("Llista inscrits: " + inscripcio1.getLlistaInscrits());
        System.out.println("Llista d'espera: " + inscripcio1.getLlistaDeEspera());

        // Prova de puntuació
        System.out.println("\n=== PROVA DE PUNTUACIÓ ===");
        inscripcio1.puntuar(8.5, usuari2);
        System.out.println("Puntuació 8.5 aplicada a l'usuari " + usuari2.getAlies());
        
    }
}
