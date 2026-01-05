package GUI;

import ActivitatsPackage.LlistaActivitats;
import ActivitatsPackage.LlistaInscripcio;
import ActivitatsPackage.*;
import UsuarisPackage.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Crear dades de prova
        LlistaActivitats activitats = crearDadesProva();
        LlistaInscripcio inscripcions = crearInscripcionsProva(activitats);
        
        // 2. Mostrar el calendari
        CalendariActivitatsGUI.mostrarCalendari(activitats, inscripcions);
    }
    
    private static LlistaActivitats crearDadesProva() {
        LlistaActivitats activitats = new LlistaActivitats(10);
        LocalDate avui = LocalDate.now();
        
        // Crear diverses activitats de prova
        ActivitatsUnDia activitat1 = new ActivitatsUnDia(
            "Visita al Museu d'Història",
            true, true, true,
            avui.plusDays(1), avui.plusDays(1),
            30, 5.0, "Tarragona", java.time.LocalTime.of(10, 0)
        );
        
        ActivitatsPeriodiques activitat2 = new ActivitatsPeriodiques(
            "Curs de Java Avançat",
            true, true, true,
            avui.minusDays(5), avui.plusDays(20),
            "Dimecres", "Campus Sescelades", "Tarragona",
            java.time.LocalTime.of(16, 0), avui.minusDays(5),
            8, 25, 50.0
        );
        
        ActivitatsOnline activitat3 = new ActivitatsOnline(
            "Webinar d'Intel·ligència Artificial",
            true, false, true,
            avui.minusDays(10), avui.minusDays(5),
            "https://meet.google.com/abc-defg-hij",
            avui.minusDays(10), 5
        );
        
        ActivitatsUnDia activitat4 = new ActivitatsUnDia(
            "Excursió a PortAventura",
            false, true, true,
            avui.plusDays(7), avui.plusDays(7),
            45, 25.0, "Salou", java.time.LocalTime.of(9, 30)
        );
        
        ActivitatsPeriodiques activitat5 = new ActivitatsPeriodiques(
            "Taller d'Anglès Bàsic",
            true, true, true,
            avui.minusDays(15), avui.plusDays(30),
            "Dilluns", "Campus Catalunya", "Reus",
            java.time.LocalTime.of(18, 0), avui.minusDays(15),
            12, 20, 30.0
        );
        
        activitats.Afegir(activitat1);
        activitats.Afegir(activitat2);
        activitats.Afegir(activitat3);
        activitats.Afegir(activitat4);
        activitats.Afegir(activitat5);
        
        return activitats;
    }
    
    private static LlistaInscripcio crearInscripcionsProva(LlistaActivitats activitats) {
        LlistaInscripcio inscripcions = new LlistaInscripcio(10);
        
        // Crear usuaris de prova
        PDI professor1 = new PDI("jdoe", "john.doe", "Informàtica", "Sescelades");
        PDI professor2 = new PDI("asmith", "anna.smith", "Matemàtiques", "Campus Catalunya");
        Estudiants estudiant1 = new Estudiants("mroe", "mary.roe", "Enginyeria Informàtica", 2023);
        Estudiants estudiant2 = new Estudiants("pjones", "peter.jones", "ADE", 2024);
        PTGAS personal1 = new PTGAS("ajohn", "anna.john", "Campus Catalunya");
        
        // Inscriure usuaris a les activitats
        for (int i = 0; i < activitats.getNumElements(); i++) {
            Activitats activitat = activitats.getActivitatPos(i);
            inscripcions.Afegir(professor1, activitat);
            inscripcions.Afegir(estudiant1, activitat);
            
            // Afegir més usuaris a algunes activitats
            if (i % 2 == 0) {
                inscripcions.Afegir(professor2, activitat);
                inscripcions.Afegir(estudiant2, activitat);
                inscripcions.Afegir(personal1, activitat);
            }
        }
        
        return inscripcions;
    }
}