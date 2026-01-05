import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import ActivitatsPackage.Activitats;
import ActivitatsPackage.ActivitatsOnline;
import ActivitatsPackage.ActivitatsPeriodiques;
import ActivitatsPackage.ActivitatsUnDia;
import ActivitatsPackage.LlistaActivitats;
import ActivitatsPackage.LlistaInscripcio;
import Exception.DataIncorrectaException;
import Exception.GestorDates;
import UsuarisPackage.Estudiants;
import UsuarisPackage.LlistaUsuaris;
import UsuarisPackage.PDI;
import UsuarisPackage.PTGAS;
import UsuarisPackage.Usuaris;

public class App {
    static Scanner teclat = new Scanner(System.in);
    static LlistaActivitats a;
    static LlistaInscripcio i;
    static LlistaUsuaris u;
    public static void main(String[] args) throws FileNotFoundException{
        boolean fi=false; 
        Scanner teclat = new Scanner(System.in);

        a= new LlistaActivitats(100);
        i= new LlistaInscripcio(100);
        u= new LlistaUsuaris(100);

        LectorActivitats.llegirFitxer(a);
        LectorUsuaris.llegirFitxer(u);
        LectorInscripcions.llegirFitxer(i, a, u);

        while (!fi){
            System.out.println("Tria una opcio\n");
            int opcio=Integer.parseInt(teclat.nextLine());
            switch(opcio) {
                case 1:
                    opcio1();
                    break;

                case 2:
                    opcio2(teclat, a, u);
                    break;

                case 3:
                    opcio3(a, i);
                    break;

                case 4:
                    opcio4();
                    break;

                case 5:
                    opcio5(a);
                    break;

                case 6:
                    opcio6();
                    break;

                case 7:
                    opcio7();
                    break;

                case 8:
                    opcio8();
                    break;

                case 9:
                    opcio9(teclat, i, u);
                    break;

                case 10:
                    opcio10();
                    break;

                case 11:
                    opcio11();
                    break;

                case 12:
                    opcio12(teclat, i, a, u);
                    break;

                case 13:
                    opcio13();
                    break;

                case 14:
                    opcio14();
                    break;

                case 15:
                    opcio15();
                    break;

                case 16:
                    opcio16();
                    break;

                case 17:
                    opcio17();
                    break;

                case 18:
                    opcio18(teclat, i, a, u);
                    break;

                case 19:
                    opcio19();
                    break;

                case 20:
                    opcio20();
                    break;

                case 21:
                    opcio21(teclat, i);
                    break;

                case 22:
                    fi=true;
                    System.out.println("Sortint del programa");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private static void opcio1(){

    }

    private static void opcio2(Scanner  teclat, LlistaActivitats acts, LlistaUsuaris usus) {
        try {
            System.out.println("1) Activitats");
            System.out.println("2) Usuaris");
            System.out.print("Opció: ");
            int op = Integer.parseInt(teclat.nextLine());

            if (op == 1) {
                System.out.println("1) Totes");
                System.out.println("2) Un dia");
                System.out.println("3) Periòdiques");
                System.out.println("4) Online");
                System.out.print("Filtre: ");
                int f = Integer.parseInt(teclat.nextLine());

                for (int i = 0; i < acts.getNumElements(); i++) {
                    Activitats a = acts.getActivitat(i);

                    boolean mostrar =
                            (f == 1) ||
                            (f == 2 && a instanceof ActivitatsUnDia) ||
                            (f == 3 && a instanceof ActivitatsPeriodiques) ||
                            (f == 4 && a instanceof ActivitatsOnline);

                    if (mostrar) System.out.println(a);
                }

            } else if (op == 2) {
                System.out.println("1) Tots");
                System.out.println("2) PDI");
                System.out.println("3) PTGAS");
                System.out.println("4) Estudiants");
                System.out.print("Filtre: ");
                int f = Integer.parseInt(teclat.nextLine());

                for (int i = 0; i < usus.getnUsuaris(); i++) {
                    Usuaris u = usus.getUsuarisPos(i);

                    boolean mostrar =
                            (f == 1) ||
                            (f == 2 && u instanceof PDI) ||
                            (f == 3 && u instanceof PTGAS) ||
                            (f == 4 && u instanceof Estudiants);

                    if (mostrar) System.out.println(u);
                }
            } else {
                System.out.println("Opció incorrecta.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Has d'introduir números.");
        }
    }
    

   private static void opcio3(LlistaActivitats a, LlistaInscripcio ins) {
        LocalDate avui = demanarData();
        LlistaActivitats enTermini = a.ActivitatsEnPeriode(avui);


        if (enTermini.getNumElements() == 0) {
            System.out.println("No hi ha activitats en període d'inscripció.");
            return;
        }

        System.out.println("Activitats en període d'inscripció (" + avui + "):");
        for (int i = 0; i < enTermini.getNumElements(); i++) {
            Activitats act = enTermini.getActivitat(i);
            boolean places = ins.tePlaces(act);

            System.out.println("- " + act.getNomActivitat() + " | " + (places ? "Places disponibles" : "Places plenes"));
        }
    }
    

    private static void opcio4(){

    }

    private static void opcio5(LlistaActivitats a){
        LocalDate avui = demanarData();
        LlistaActivitats actives = a.ActivitatsActives(avui);
        actives.MostrarNoms();
    }

    private static void opcio6(){

    }

    private static void opcio7(){

    }

    private static void opcio8(){

    }

    private static void opcio9(Scanner teclat, LlistaInscripcio ins, LlistaUsuaris usus){
        try {
            System.out.print("DNI/Alies usuari: ");
            String id = teclat.nextLine().trim();

            Usuaris u = buscarUsuariPerAlies(usus, id);
            if (u == null) {
                System.out.println("Usuari no trobat.");
                return;
            }

            LlistaActivitats l = ins.ActivitatsPertanyUsuari(u);

            if (l.getNumElements() == 0) {
                System.out.println("Aquest usuari no està apuntat a cap activitat.");
                return;
            }

            System.out.println("Activitats on està apuntat " + u.getAlies() + ":");
            for (int i = 0; i < l.getNumElements(); i++) {
                System.out.println("- " + l.getActivitat(i).getNomActivitat());
            }

        } catch (Exception e) {
            System.out.println("Error opció 9.");
        }
    }

    

    private static void opcio10(){ //TODO 1 importar fitxer per usuari
        /*System.out.println("Activitats disponibles");
        LlistaActivitats activitats = new LlistaActivitats();
        String activitat;
        for (int i=0; i<activitats.length; i++) //TODO 2 posar el nom de la llista
        {
            System.out.println(activitats[i].getActivitat);
        }
        System.out.println("A quina activitat et vols inscriure?");
        activitat=teclat.nextLine(); //TODO 3 definir Scanner teclat
        activitat.inscriures(usuari); */
    }

    private static void opcio11(){

    }

    private static void opcio12(Scanner teclat, LlistaInscripcio ins, LlistaActivitats acts, LlistaUsuaris usus){
        try {
            System.out.println("Nom activitat: ");
            String nomAct = teclat.nextLine().trim();

            Activitats a = buscarActivitatPerNom(acts, nomAct);
            if (a == null) {
                System.out.println("Activitat no trobada.");
                return;
            }

            System.out.print("DNI/Alies usuari a eliminar: ");
            String id = teclat.nextLine().trim();

            Usuaris u = buscarUsuariPerAlies(usus, id);
            if (u == null) {
                System.out.println("Usuari no trobat.");
                return;
            }

            ins.eliminar(u, a);
            System.out.println("Usuari eliminat de l'activitat (si hi havia espera, s'ha mogut el primer).");

        } catch (Exception e) {
            System.out.println("Error opció 12.");
        }
    }

    

    private static void opcio13(){

    }

    private static void opcio14(){

    }

    private static void opcio15(){

    }

    private static void opcio16(){

    }

    private static void opcio17(){

    }

    private static void opcio18(Scanner teclat, LlistaInscripcio ins, LlistaActivitats acts, LlistaUsuaris usus){
        try {
            System.out.print("DNI/Alies usuari: ");
            String id = teclat.nextLine();

            Usuaris u = null;
            for (int i = 0; i < usus.getnUsuaris(); i++) {
                if (usus.getUsuarisPos(i).getAlies().equalsIgnoreCase(id)) {
                    u = usus.getUsuarisPos(i);
                    break;
                }
            }

            if (u == null) {
                System.out.println("Usuari no trobat.");
                return;
            }

            System.out.println("Valoracions de " + u.getAlies() + ":");
            boolean alguna = false;

            for (int i = 0; i < acts.getNumElements(); i++) {
                Activitats a = acts.getActivitat(i);
                Integer v = ins.getValoracioUsuariEnActivitat(a, u);

                if (v != null) {
                    System.out.println("- " + a.getNomActivitat() + ": " + v);
                    alguna = true;
                }
            }

            if (!alguna) {
                System.out.println("Aquest usuari no ha fet cap valoració.");
            }

        } catch (Exception e) {
            System.out.println("Error en mostrar valoracions.");
        }
    }

    private static void opcio19(){

    }

    private static void opcio20(){

    }

    private static void opcio21(Scanner teclat, LlistaInscripcio ins){
        LocalDate avui = demanarData();
        try {
            ins.DonarDeBaixaActivitat(avui);
            System.out.println("S'ha aplicat la baixa d'activitats segons criteris (punt 21).");
        } catch (Exception e) {
            System.out.println("Error opció 21.");
        }
    }

    


    /*funcions auxiliars */
    private static LocalDate demanarData(){
        LocalDate data = null;
        boolean correcte = false;

        while (!correcte) {
            System.out.print("Introdueix una data (dd/MM/yyyy): ");
            String text = teclat.nextLine();

            try {
                data = GestorDates.convertir(text);
                correcte = true;
            } catch (DataIncorrectaException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Data introduïda correctament: " + data);
        return data;

    }
    private static Activitats buscarActivitatPerNom(LlistaActivitats acts, String nom) {
        for (int i = 0; i < acts.getNumElements(); i++) {
            Activitats a = acts.getActivitat(i);
            if (a != null && a.getNomActivitat().equalsIgnoreCase(nom)) return a;
        }
        return null;
    }

    private static Usuaris buscarUsuariPerAlies(LlistaUsuaris usus, String alies) {
        for (int i = 0; i < usus.getnUsuaris(); i++) {
            Usuaris u = usus.getUsuarisPos(i);
            if (u != null && u.getAlies() != null && u.getAlies().equalsIgnoreCase(alies)) return u;
        }
        return null;
    }
}


