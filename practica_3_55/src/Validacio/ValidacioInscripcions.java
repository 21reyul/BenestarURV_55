package Validacio;

import java.time.LocalDate;
import java.time.LocalTime;

import ActivitatsPackage.ActivitatsPeriodiques;
import ActivitatsPackage.ActivitatsUnDia;
import InscripcionsPackage.Inscripcions;
import UsuarisPackage.Usuaris;

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
        Inscripcions.setMAX(50); // Canviem el màxim global
        
        System.out.println("Informacio inscripcio 1 modificada =>\n Places = " + inscripcio1.getNumPlaçes() + 
                         "\n MAX = " + Inscripcions.getMAX() + "\n");

        // Creació d'usuaris per proves
        Usuaris usuari1 = new Usuaris("anna123", "Anna", "Garcia", "anna.garcia@email.com", "12345678A", "Estudiant");
        Usuaris usuari2 = new Usuaris("marc45", "Marc", "Lopez", "marc.lopez@email.com", "87654321B", "PDI");
        Usuaris usuari3 = new Usuaris("julia99", "Julia", "Martinez", "julia.m@email.com", "11223344C", "Estudiant");
        Usuaris usuari4 = new Usuaris("carlos77", "Carlos", "Sanchez", "carlos.s@email.com", "44332211D", "PAS");
        Usuaris usuari5 = new Usuaris("laura22", "Laura", "Fernandez", "laura.f@email.com", "55667788E", "Estudiant");

        // Proves d'inscripció
        System.out.println("=== PROVES D'INSCRIPCIÓ ===");
        
        // Inscriure usuaris fins a omplir places
        System.out.println("Inscripció usuari 1 a activitat 1:");
        inscripcio1.inscriures(usuari1);
        System.out.println("Llista inscrits després d'afegir usuari 1: " + inscripcio1.getLlistaInscrits());
        
        System.out.println("\nInscripció usuari 2 a activitat 1:");
        inscripcio1.inscriures(usuari2);
        System.out.println("Llista inscrits després d'afegir usuari 2: " + inscripcio1.getLlistaInscrits());

        // Inscriure més usuaris que places disponibles (prova llista d'espera)
        System.out.println("\n=== PROVA LLISTA D'ESPERA ===");
        
        // Omplim les places
        for (int i = 0; i < 18; i++) { // Ja tenim 2, afegim 18 més
            Usuaris usuariTemp = new Usuaris("temp" + i, "Nom" + i, "Cognom" + i, 
                                           "email" + i + "@test.com", "DNI" + i, "Estudiant");
            inscripcio1.inscriures(usuariTemp);
        }
        
        System.out.println("Places totals: " + inscripcio1.getNumPlaçes());
        System.out.println("Inscrits actuals: " + inscripcio1.getLlistaInscrits());
        System.out.println("Llista d'espera: " + inscripcio1.getLlistaDeEspera());

        // Prova de baixa
        System.out.println("\n=== PROVA DE BAIXA ===");
        System.out.println("Donem de baixa a l'usuari 1:");
        inscripcio1.baixa(usuari1);
        System.out.println("Inscrits després de la baixa: " + inscripcio1.getLlistaInscrits());
        System.out.println("Llista d'espera després de la baixa: " + inscripcio1.getLlistaDeEspera());

        // Prova de puntuació (necessita implementar el mètode puntuar)
        System.out.println("\n=== PROVA DE PUNTUACIÓ ===");
        // Aquest mètod pot no estar implementat completament a la classe Inscripcions
        try {
            // Provem de puntuar un usuari que està inscrit
            inscripcio1.puntuar(8.5, usuari2);
            System.out.println("Puntuació aplicada a l'usuari 2");
        } catch (Exception e) {
            System.out.println("Error en puntuar: " + e.getMessage());
        }

        // toString
        System.out.println("\n=== MÈTODE toString() ===");
        System.out.println("inscripcio1.toString():");
        System.out.println(inscripcio1.toString());
        
        System.out.println("\ninscripcio2.toString():");
        System.out.println(inscripcio2.toString());

        // Proves amb la segona inscripció
        System.out.println("\n=== PROVES AMB INSCRIPCIÓ 2 (Senderisme) ===");
        
        System.out.println("Inscripció de 3 usuaris a senderisme:");
        inscripcio2.inscriures(usuari3);
        inscripcio2.inscriures(usuari4);
        inscripcio2.inscriures(usuari5);
        
        System.out.println("Inscrits a senderisme: " + inscripcio2.getLlistaInscrits());
        System.out.println("Total places senderisme: " + inscripcio2.getNumPlaçes());
        
        // Prova de canviar l'activitat associada
        System.out.println("\n=== PROVA DE CANVI D'ACTIVITAT ===");
        ActivitatsUnDia novaActivitat = new ActivitatsUnDia("Nova activitat", false, true, false, 
                                                          LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 10), 
                                                          30, 5.0, "Reus", LocalTime.of(16, 0));
        inscripcio2.setA(novaActivitat);
        System.out.println("Nova activitat associada: " + inscripcio2.getA().getNomActivitat());
    }
}
        }
}
