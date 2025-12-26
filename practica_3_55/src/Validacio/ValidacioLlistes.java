package Validacio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import ActivitatsPackage.*;
import UsuarisPackage.*;

public class ValidacioLlistes {
    /*Programadora: Cristina Cozma */
    public static void main(String[] args) throws Exception {
        Scanner readScanner = new Scanner(System.in);
        //Crear llistes
        LlistaActivitats llistaActs = new LlistaActivitats(10);
        LlistaInscripcio llistaIns = new LlistaInscripcio(10);
        LlistaUsuaris llistaUsu = new LlistaUsuaris(10);
            
        //Crear activitats per a la llista
        Activitats act1 = new ActivitatsUnDia("Taller de Ceramica", true, true, true, LocalDate.now(), LocalDate.now(),12, 25.0, "Tarragona", LocalTime.of(14,0));
        Activitats act2 = new ActivitatsOnline("Pilates Online", true, true, true, LocalDate.now(), LocalDate.now().plusDays(7), "https://zoom.com/pilates", LocalDate.now(), 7);
        Activitats act3 = new ActivitatsPeriodiques("Gimnas Setmanal", true, false, true, LocalDate.now(), LocalDate.now().plusWeeks(4), "Dilluns", "Centre A", "Barcelona", LocalTime.of(18,0), LocalDate.now(), 4, 20, 50.0);
        Activitats act4 = new ActivitatsUnDia("Taller de Cuina", true, true, true, LocalDate.now(), LocalDate.now(), 15, 30.0, "Girona", LocalTime.of(10,0));
        Activitats act5 = new ActivitatsOnline("Running", false, true, true, LocalDate.now(), LocalDate.now().plusDays(6), "https://zoom.com/cardio", LocalDate.now(), 6);
        Activitats act6 = new ActivitatsPeriodiques("Natació Setmanal", true, false, true,LocalDate.now(), LocalDate.now().plusWeeks(5),"Dimecres", "Centre B", "Barcelona",LocalTime.of(17,0),LocalDate.now(), 5, 15, 45.0);
        Activitats act7 = new ActivitatsUnDia("Taller de Fotografia", true, true, true, LocalDate.now(), LocalDate.now(), 12, 25.0, "Tarragona", LocalTime.of(14,0));

        //Crear usuaris per a la llista
        Usuari us1= new Pdi("Alex", "alex.bru", "Informatica", "Sescelades");
        Usuari us2 = new Ptgas("Joan", "joan.granell", "Catalunya");
        Usuari us3 = new Estudiants("Rachel", "rachel.green", "ADE", 2022);
        Usuari us4 = new Pdi("Monica", "monica.geller", "Quimica", "Sescelades");
        Usuari us5 = new Ptgas("Joey", "joey.tribbiani", "Terres de l'Ebre");
        Usuari us6 = new Estudiants("Benito", "benito.badbu", "Grau en Enginyieria Informatica", 2025);

        //afegir les activitats a la llista
        llistaActs.afegir(act2);
        llistaActs.afegir(act1);
        llistaActs.afegir(act3);
        llistaActs.afegir(act4);
        llistaActs.afegir(act5);
        llistaActs.afegir(act6);
        llistaActs.afegir(act7);

        //afegir els usuaris a la llista
        llistaUsu.afegir(us1);
        llistaUsu.afegir(us2);
        llistaUsu.afegir(us3);
        llistaUsu.afegir(us4);
        llistaUsu.afegir(us5);
        llistaUsu.afegir(us6);

        //inscriure els usuaris a la llista d'inscripcions
        llistaIns.afegir(us1, act7);
        llistaIns.afegir(us2, act6);
        llistaIns.afegir(us3, act5);
        llistaIns.afegir(us4, act4);
        llistaIns.afegir(us5, act3);
        llistaIns.afegir(us6, act2);
        llistaIns.afegir(us2, act1);
        llistaIns.afegir(us3, act2);
        llistaIns.afegir(us6, act3);
        llistaIns.afegir(us4, act4);

        //mostrar les llistes
        System.out.println(llistaActs.toString());
        System.out.println(llistaIns.toString());
        System.out.println(llistaUsu.toString());
        
        //eliminar algun element de la llista, no fem controls d'error exhaustius, donem per suposat que l'activitat/alies/nom existeix
        System.out.println("De quina llista vols eliminar l'element: (usuaris/inscripcions/activitats)");
        String tipus = readScanner.nextLine();
        System.out.println("Escriu el nom/alies de l'element a eliminar");
        String nom = readScanner.nextLine();
        Usuari u = llistaUsu.getUsuariPerAlies(nom);

        switch (tipus.toLowerCase()) {
            case "usuari":
                llistaUsu.elimina(u);
                System.out.println("Usuari eliminat correctament");
                break;
            case "inscripcions":
                System.out.println("De quina activitat vols eliminar l'usuari:\s"+nom);
                String nomAct = readScanner.nextLine();
                Activitats a = llistaActs.getActivitatPerNom(nomAct);
                llistaIns.eliminar(u, a);
                System.out.println("Usuari eliminat correctament");
                break;
            case "activitats":
                System.out.println("Quina activitat vols eliminar?");
                String nomA = readScanner.nextLine();
                Activitats ac = llistaActs.getActivitatPerNom(nomA);
                llistaActs.elimina(ac);
                System.out.println("Usuari eliminat correctament");
                break;
            default:
                System.out.println("No existeix aquesta opcio");
                break;
        }  

        //mostrem les llistes després d'eliminar per veure si s'ha eliminat
        System.out.println(llistaActs.toString());
        System.out.println(llistaIns.toString());
        System.out.println(llistaUsu.toString()); 


        //obtenir alguna activitat
        System.out.println("OBTENIR ACTIVITAT DE LA LLISTA SEGONS EL SEU NOM");
        System.out.println("Quina activitat es vol mostrar?");
        String act = readScanner.nextLine();
        Activitats a = llistaActs.getActivitatPerNom(act);
        System.out.println(a.toString());


        //obtenir l'activitat segons la posicio
        System.out.println("OBTENIR ACTIVITAT DE LA LLISTA SEGONS UNA POSICIO");
        System.out.println("Introdueix la posicio");
        int i = readScanner.nextInt();
        System.out.println(llistaActs.getActivitatsPos(i-1).toString());

        //obtenir la llista d'inscripcio d'una activitat
        System.out.println("OBTENIR LA LLISTA D'INSCRIPCIONS D'UNA ACTIVITAT SEGONS EL NOM");
        System.out.println("De quina activitat vols obtenir la inscripció?");
        String n = readScanner.nextLine();
        Activitats a2 = llistaActs.getActivitatPerNom(n);
        System.out.println(llistaIns.getIncripcionsFromActivitat(a2).toString());

        //obtenir la inscripcio segons una posicio
        System.out.println("OBTENIR LA LLISTA D'INSCRIPCIONS D'UNA ACTIVITAT SEGONS UNA POSICIO");
        System.out.println("De quina activitat vols obtenir la inscripció?");
        int p2 = readScanner.nextInt();
        Activitats a3 = llistaActs.getActivitatsPos(p2);
        System.out.println(llistaIns.getIncripcionsFromActivitat(a3).toString());


        //obtenir la llista d'espera segons una activitat
        System.out.println("OBTENIR LA LLISTA D'ESPERA D'UNA ACTIVITAT SEGONS EL SEU NOM");
        System.out.println("De quina activitat vols obtenir la llista d'espera?");
        String n2 = readScanner.nextLine();
        Activitats a4 = llistaActs.getActivitatPerNom(n2);
        LlistaInscripcio i1 = llistaIns.getLlistaEspera(a4);
        System.out.println(i1.toString());

        //tractament de la llista d'usuaris
        System.out.println("OBTENIR UN USUARI SEGONS EL SEU ALIES");
        System.out.println("Introdueix l'alies d el'usuari");
        String alies = readScanner.nextLine();
        Usuari u2 = llistaUsu.getUsuariPerAlies(alies);
        System.out.println(u2.toString());

        System.out.println("OBTENIR UN USUARI SEGONS LA POSICIO");
        System.out.println("Introdueix la poscio");
        int p3 = readScanner.nextInt();
        Usuari u3 = llistaUsu.getUsuarisPos(p3);
        System.out.println(u3.toString());

        System.out.println("OBTENIR UN ALIES SEGONS LA POSICIO");
        System.out.println("Introdueix ls posicio");
        int p4 = readScanner.nextInt();
        String alies1 = llistaUsu.getUsuarisAliesPos(p4);
        System.out.println(alies1.toString());

        //tancar el scanner
        readScanner.close();
    }
}
