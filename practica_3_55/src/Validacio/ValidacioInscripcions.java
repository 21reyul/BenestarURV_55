package Validacio;

import java.time.LocalDate;
import java.time.LocalTime;

import ActivitatsPackage.*;
import UsuarisPackage.*;

/* Programadora: Aina Garcia Albesa */

/* VALIDACIO INSCRIPCIONS */
public class ValidacioInscripcions {
    public static void main(String[] args) throws Exception {
        ActivitatsPeriodiques actPer1 = new ActivitatsPeriodiques("Curs B2 d'angles per a estudiants", false, false, true, LocalDate.of(2025, 9, 5) , 
                                                LocalDate.of(2025, 9, 22), "dijous", "Campus Catalunya", "Tarragona", LocalTime.of(17, 30), 
                                                LocalDate.of(2025, 10, 15), 20, 25, 100.0);
            
        ActivitatsUnDia actDia2 = new ActivitatsUnDia("Senderisme", true, true, true, LocalDate.of(2025, 12, 2), 
                                                LocalDate.of(2025, 12, 9), 40, 10.0, "Amposta", LocalTime.of(10, 0)); 

        Inscripcions inscripcio1 = new Inscripcions (actPer1, 20);
        Inscripcions inscripcio2 = new Inscripcions (actDia2, 15);

        // getters
        System.out.println("Informacio inscripcio 1 inicial =>\n Places = " + inscripcio1.getNumPlaces() + 
                            "\n Activitat = " + inscripcio1.getActivitat().getNomActivitat());
        
        System.out.println("Informacio inscripcio 2 inicial =>\n Places = " + inscripcio2.getNumPlaces() + 
                            "\n Activitat = " + inscripcio2.getActivitat().getNomActivitat());
                            

        // setters
        inscripcio1.setNumPlaces(25);
        
        System.out.println("Informacio inscripcio 1 modificada =>\n Places = " + inscripcio1.getNumPlaces());

        // Creació d'usuaris per proves
        Usuaris usuari1 = new Estudiants("estudiant1", "est1@estudiants.urv.cat", "GEI", 2025);
        Usuaris usuari2 = new PDI("PDI1", "pdi1@urv.cat", "DEIM", "Sescelades");
        Usuaris usuari3 = new PDI("PDI2", "pdi2@urv.cat", "Historia", "Catalunya");
        /*Usuaris usuari4 = new PTGAS("PTGAS1", "ptgas1@urv.cat", "Bellisens");
        Usuaris usuari5 = new PTGAS("PTGAS2", "ptgas2@urv.cat", "Terres de l'Ebre");*/

        // Proves d'inscripció i control de llista d'espera
        validacioInscripcioMesLlistaEspera(inscripcio1, usuari1, usuari2);

        // Prova de baixa
        validacioEliminaDeActivitat(inscripcio1, usuari1);
        // Prova de puntuació
        validacioPuntuar(inscripcio1, usuari1, usuari2, usuari3);
    }

    private static void validacioInscripcioMesLlistaEspera(Inscripcions inscripcio1, Usuaris usuari1, Usuaris usuari2){
        System.out.println("\n=== PROVES D'INSCRIPCIÓ ===");
        
        System.out.println("Inscripció usuari 1 a activitat 1 (Curs B2)");
        inscripcio1.inscriures(usuari1);
        
        System.out.println("Inscripció usuari 2 a activitat 1");
        inscripcio1.inscriures(usuari2);

        // Prova de llista d'espera
        System.out.println("\n=== PROVA LLISTA D'ESPERA ===");
        System.out.println("Places totals a activitat 1: " + inscripcio1.getNumPlaces()); // Places = 25
        
        // Inscrivim més usuaris per omplir les places (2 ja inscrits, falten 23)
        System.out.println("Inscrivint més usuaris per omplir places (Falten 23 per les 25 places)");
        for (int i = 0; i < 23; i++) { 
            Usuaris usuariExtra = new Estudiants("estExtra" + (i+3), "estExtra"+(i+3)+"@estudiants.urv.cat", "GESST", 2022);
            inscripcio1.inscriures(usuariExtra);
        }
        
        System.out.println("Intentant inscriure un usuari extra (hauria d'anar a llista d'espera):");
        Usuaris usuariEspera = new PTGAS("PTGASEspera", "ptgasespera@urv.cat", "Sescelades");
        inscripcio1.inscriures(usuariEspera); 

        // Mostrem estat actual
        System.out.println("\nEstat actual de l'inscripció 1:");
        System.out.println("Places: " + inscripcio1.getNumPlaces());
        System.out.println("Llista inscrits: " + inscripcio1.getLlistaInscrits());
        System.out.println("Llista d'espera: " + inscripcio1.getLlistaDeEspera());
    }

    private static void validacioEliminaDeActivitat(Inscripcions inscripcio1, Usuaris usuari1){
        System.out.println("\n=== PROVA DE BAIXA ===");
        System.out.println("Donem de baixa a l'usuari 1:");
        inscripcio1.eliminaDeActivitat(usuari1); // S'executarà la baixa i es promocionarà PTGASEspera
        
        System.out.println("\nEstat després de la baixa (usuariEspera promocionat):");
        System.out.println("Llista inscrits: " + inscripcio1.getLlistaInscrits());
        System.out.println("Llista d'espera: " + inscripcio1.getLlistaDeEspera());
    }

    private static void validacioPuntuar(Inscripcions inscripcio1, Usuaris usuari1, Usuaris usuari2, Usuaris usuari3){
        System.out.println("\n=== PROVA DE PUNTUACIÓ  ===");
        
        // Estat inicial de la valoració
        System.out.println("Valoració inicial de l'activitat: " + inscripcio1.getValoracio());

        // Intent 1: Puntuació vàlida (la primera)
        inscripcio1.puntuar(8.5, usuari2); 
        System.out.println("Valoració de l'usuari2:" + inscripcio1.getValoracio() + " (Esperat: 9)"); 

        // Intent 2: Puntuació invàlida (fora de rang)
        inscripcio1.puntuar(15.0, usuari3); 
        System.out.println("Valoració de l'usuari3: " + inscripcio1.getValoracio() + " (Esperat: 9, sense canvis)"); 

        // Puntuació d'un usuari que ha estat donat de baixa (usuari1)
        inscripcio1.puntuar(9.0, usuari1); 
        System.out.println("Valoració de l'usuari 1 (donat de baixa): " + inscripcio1.getValoracio() + " (Esperat: 9, sense canvis)");   
    }
}