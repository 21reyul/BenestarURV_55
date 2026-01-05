import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import ActivitatsPackage.*;
import Exception.*;
import Lectors.LectorActivitats;
import Lectors.LectorInscripcions;
import Lectors.LectorUsuaris;
import UsuarisPackage.*;

public class App {
    static Scanner teclat = new Scanner(System.in);
    static LlistaActivitats a;
    static LlistaInscripcio i;
    static LlistaUsuaris u;
    private static LocalDate data = LocalDate.now();
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
                    opcio4(a, i);
                    break;

                case 5:
                    opcio5(a);
                    break;

                case 6:
                    opcio6();
                    break;

                case 7:
                    opcio7(a);
                    break;

                case 8:
                    opcio8();
                    break;

                case 9:
                    opcio9(teclat, i, u);
                    break;

                case 10:
                    opcio10(a, i, null);
                    break;

                case 11:
                    opcio11();
                    break;

                case 12:
                    opcio12(teclat, i, a, u);
                    break;

                case 13:
                    opcio13(a);
                    break;

                case 14:
                    opcio14(a);
                    break;

                case 15:
                    opcio15(a);
                    break;

                case 16:
                    opcio16(a, i);
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
                    opcio20(i);
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


/**
 * Indica la data del dia en el que estem, aquesta inicialment sera la del servidor
 * Conté l'opcio de modificar la data per poder elaborar els diferents jocs de proves
 */
public static void opcio1(){
    
    Scanner teclat = new Scanner(System.in);
    //La data inicial sera la del servidor
    System.out.println("la data de avui es:\n" + data.getDayOfMonth() + "/" + data.getMonthValue() + "/"+ data.getYear());
    System.out.println("Si vols modificar la data introdueix: OK");
    String resposta=teclat.nextLine();//llegim la resposta de teclat, si es que si, entrem en un bucle per modificar la data
    try{
        if(resposta.equalsIgnoreCase("OK")){
            System.out.println("Introdueix el nou any:");
            int anyNou=Integer.parseInt(teclat.nextLine());
                        
            System.out.println("Introdueix el nou mes:");
            int mesNou=Integer.parseInt(teclat.nextLine());

            System.out.println("Introdueix el nou dia:");
            int diaNou=Integer.parseInt(teclat.nextLine());

            if(diaNou >= 1 && diaNou <= 31 && mesNou >= 1 && mesNou <= 12 && anyNou>0){
                data = LocalDate.of(anyNou, mesNou, diaNou);
                System.out.println("Data actualitzada:\n" + data.getDayOfMonth() + "/" + data.getMonth() + "/" + data.getYear());
            }else{
                System.out.println("Data incorrecta");
            }
        }else{
            System.out.println("No s'ha modificat la data,  la data del dia d'avui es:\n" + data.getDayOfMonth() + "/" + data.getMonthValue() + "/"+ data.getYear());
        }
    }catch(NumberFormatException e){
        System.out.println("Les dades introduïdes han de ser enters");
    }catch(DateTimeException e){
        System.out.println("El format de la data es incorrecte");
    }
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
                    Usuari u = usus.getUsuarisPos(i);

                    boolean mostrar =
                            (f == 1) ||
                            (f == 2 && u instanceof Pdi) ||
                            (f == 3 && u instanceof Ptgas) ||
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
    

    /**
     * Mostrar la informació de les activitats que tenen classe en la data d'avui, 
     * En aquest metode no tracto cpa excepcio perquè es un metode de consulta,
     * no es fa cap operació. 
    */
    private static void opcio4(LlistaActivitats llistaActs, LlistaInscripcio llistaIns){
        boolean ple=false;
        boolean hiHaEspera=false;
        int compt=0;

        
        //canviar a les intàncies generals, sol son de prova
        LlistaActivitats actsAvui = llistaActs.activitatsAvui(data);
        actsAvui.toString();
        for(int i=0; i<actsAvui.getNumElements(); i++){
            Activitats a = actsAvui.getActivitatsPos(i);
            Inscripcions ins = llistaIns.getIncripcionsFromActivitat(a);
            if(ins.getNumEspera()>0){
                hiHaEspera=true;
                System.out.println("Per aquesta activitat hi ha una llista d'espera de "+ins.getNumEspera()+"persones");
            }
            if(ins.getNumInscrits()>ins.getNumPlaces()){
                ple=true;
                System.out.println("No queden places disponibles per aquesta activitat");
            }
        }
    }

    private static void opcio5(LlistaActivitats a){
        LocalDate avui = demanarData();
        LlistaActivitats actives = a.ActivitatsActives(avui);
        actives.MostrarNoms();
    }

    //mostrar el nom de les activitats amb places disponibles
    private static void opcio6(){
        //instancies provisionals, cal canviarles en implementar el codi
        LlistaActivitats llistaActs = new LlistaActivitats(10);
        LlistaInscripcio llistaIns = new LlistaInscripcio(10);
        LlistaActivitats activitatsDisponibles = new LlistaActivitats(10);
            
        for(int i=0; i<llistaActs.getNumElements(); i++){
            Activitats a = llistaActs.getActivitatsPos(i);
            Inscripcions ins = llistaIns.getIncripcionsFromActivitat(a);
            if(ins.getNumInscrits()<ins.getNumPlaces()){
                activitatsDisponibles.afegir(a);
            }
        }
        //De la llista d'activtats dispobibles imprimim el nom
        for(int i=0; i<activitatsDisponibles.getNumElements();i++){
            System.out.println(activitatsDisponibles.getActivitatsPos(i).getNomActivitat());
        }
    }
  
    /**
     * OPCIO 7:
     * Mostrar el detall d’informació d’una activitat a partir del seu nom.
     * Es pregunta per teclat el nom de l'activitat que es vol obtenir l'informació
     * S'imprimeix l'informacio de l'activitat per pantalla
     * Si no es troba informacio de l'activitat s'avisa per teclat
     * @param llistaActivitatsOpcio7 llista on es troben registrades les activitats pasades per fitxer
     */
    private static void opcio7(LlistaActivitats llistaActivitatsOpcio7){
            System.out.println("Quina activitat voleu la informacio: ");
            String nomActivitat = teclat.nextLine();
            Activitats informacioActivita = llistaActivitatsOpcio7.trobaActivitat(nomActivitat);
            if (informacioActivita!=null) { 
                System.out.println("\n" + informacioActivita.toString()); 
            }
            else { 
                System.out.println("No s'ha trobat informacio de l'activitat "+ nomActivitat); 
            }

    }

    /**
     * Mostrar un usuari sgeons el nom
     * No es controla cap excepcio perquè es un metode de consulta 
     */
    private static void opcio8(){
            LlistaUsuaris llistaUsu = new LlistaUsuaris(10);//tempoal, canviar per la permanent
            Usuari u=null;
            boolean trobat=false;

            Scanner sc = new Scanner(System.in);
            System.out.println("Introdueix el nom de l'usuari del qual vols consultar les dades");
            String nom = sc.nextLine();   //llegim el nom per pantalla
            
            int i=0;
            while(!trobat && i<llistaUsu.getnUsuaris()){
                if(llistaUsu.getUsuarisAliesPos(i).equals(nom)){
                    trobat=true;
                    u=llistaUsu.getUsuarisPos(i);
                }else{
                    i++;
                }
            }
        u.toString();
    }

    private static void opcio9(Scanner teclat, LlistaInscripcio ins, LlistaUsuaris usus){
        try {
            System.out.print("DNI/Alies usuari: ");
            String id = teclat.nextLine().trim();

            Usuari u = buscarUsuariPerAlies(usus, id);
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

    

    /**
     * Opció 10: inscriure a un usuari
     * Programadora: Aina Garcia Albesa
     * @param usuari
     */
    private static void opcio10(LlistaActivitats llistaActivitats, LlistaInscripcio llistaInscripcio, Usuari usuari){ //TODO 1 importar fitxer per usuari
        System.out.println("--- INSCRIPCIO A ALGUNA ACTIVITAT ---");

        Activitats[] activitats = mostrarActDisponiblesUsuari(llistaActivitats, usuari);

        if (activitats.length==0){
            System.out.println("No hi ha cap activitat disponible en aquest moment.");
            return;
        }else{
            System.out.println("Activitats disponibles:");
            for (int i=0; i<activitats.length; i++) 
            {
                System.out.println((i+1)+": "+activitats[i].getNomActivitat());
            }

            System.out.println("A quina activitat et vols inscriure?");
            int tria = teclat.nextInt(); teclat.nextLine();
            do{
                System.out.println("Numero d'activitat incorrecte.");
                System.out.print("Selecciona una activitat: ");
                tria = teclat.nextInt(); teclat.nextLine();
            }while(tria < 1 || tria > activitats.length);

            Activitats act = activitats[tria - 1];

            // Buscar l'objecte Inscripcions d'aquella activitat
            Inscripcions ins = null;
            for (int i = 0; i < llistaInscripcio.getNumElements(); i++) {
                if (llistaInscripcio.getInscripcioPos(i).getActivitat().getNomActivitat().equals(act.getNomActivitat())) {
                    ins = llistaInscripcio.getInscripcioPos(i);
                    break;
                }
            }

            if (ins != null) {
                // Comprovar si ja hi és
                if (estaInscrit(ins, usuari)){
                    System.out.println("Ja hi estàs inscrit.");
                } else {
                
                    int inscritsAbans = ins.getLlistaInscrits().getnUsuaris();
                    ins.inscriures(usuari);
                    
                    if (ins.getLlistaInscrits().getnUsuaris() > inscritsAbans) {
                        System.out.println("Inscripció confirmada!");
                    } else {
                        System.out.println("Places plenes. Has entrat a la llista d'espera.");
                    }
                }
            }
        }
    }

    //Mostrar llista d'inscripcions per activitat
    private static void opcio11(){
        try{
            System.out.println("De quina activitat vols obtenir la llista d'incripcions");
            String nomAct= teclat.nextLine();//llegim el nom de l'activitat per teclat
            
            //Crear instancies de les llistes
            LlistaActivitats llistaActs = new LlistaActivitats(10);
            LlistaInscripcio llistaIns = new LlistaInscripcio(10);
            
            Activitats act = llistaActs.getActivitatPerNom(nomAct);
            //si no es troba l'activitat llençem l'excepcio
            if(act==null){
                throw new NoExisteixActivitat(nomAct);
            }
            Inscripcions ins = llistaIns.getIncripcionsFromActivitat(act);

            //imprimim llista d'inscrits
            System.out.println("\nUsuaris inscrits:");
            for(int i=0; i<ins.getNumInscrits();i++){
                System.out.println(ins.getInscrit(i));
            }
            //imprimim la llista d'espera
            if(ins.getNumEspera()==0){
                System.out.println("No hi ha perosnes en la llista d'espera");
            }else{
                System.out.println("\nUsuaris en espera:");
                for(int i=0; i<ins.getNumEspera(); i++){
                    System.out.println(ins.getEspera(i));
                }
            }
        }catch(NoExisteixActivitat e){
            System.out.println("L'activitat no existeix");
        }
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

            Usuari u = buscarUsuariPerAlies(usus, id);
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

    

    /**
     * OPCIO 13
     * Afegir una nova activitat d’un dia.
     * BLA BLBA BLS
     * @param llistaActivitatsOpcio13
     */
    private static void opcio13(LlistaActivitats llistaActivitatsOpcio13){
        String nom13=introduirNomActivitat(llistaActivitatsOpcio13);

        System.out.print("Indica si voleu que s'hi puguin incriure PDI: ");
        String pdiString13=teclat.nextLine();
        Boolean pdiBoolea13=siONo(pdiString13);

        System.out.print("Indica si voleu que s'hi puguin incriure PTGAS: ");
        String ptgasString13=teclat.nextLine();
        Boolean ptgasBoolea13=siONo(ptgasString13);

        System.out.print("Indica si voleu que s'hi puguin incriure estudiants: ");
        String estudiantsString13=teclat.nextLine();
        Boolean estudiantsBoolea13=siONo(estudiantsString13);
        
        System.out.println("Introduiu la data Inicial");
        LocalDate dataIn13=introduirData();

        Boolean datacorrecta13=false;
        LocalDate dataFi13=null;
        do{
            System.out.println("Introduiu la data Final");
            dataFi13=introduirData();
            if (dataFi13.isAfter(dataIn13)){
                datacorrecta13=true;
            }
            else{ System.out.println("ERROR; la data de fi a de ser posterior a la de inici"); }

        }while (!datacorrecta13);

        boolean correcte13=false;
        int nPlaces13=0;
        while(!correcte13){
            try{
                System.out.print("Indica el nº de places: ");
                nPlaces13=Integer.parseInt(teclat.nextLine());
                if (nPlaces13>0){
                    correcte13=true;
                }
                else{
                    System.out.println("ERROR; places negatiu");
                }
            }
            catch(NumberFormatException exceptions){
                System.out.println("ERROR; Ha de ser un valor numeric " + exceptions);
            }
        }

        correcte13=false;
        int preu13=0;
        while(!correcte13){
            try{
                System.out.print("Indica el preu: ");
                preu13=Integer.parseInt(teclat.nextLine());
                if (preu13>=0){
                    correcte13=true;
                }
                else{
                    System.out.println("ERROR; preu negatiu");
                }
           }
            catch(NumberFormatException exceptions){
                System.out.println("ERROR; Ha de ser un valor numeric " + exceptions);
            }
        }

        System.out.print("Indica nom del lloc: ");
        String lloc13=teclat.nextLine();

        System.out.println("Introduiex l'hora:");
        LocalTime temps13=introduirTemps();

        ActivitatsUnDia actUnDiaOpccio13 = new ActivitatsUnDia(nom13, pdiBoolea13, ptgasBoolea13, estudiantsBoolea13, dataIn13, dataFi13, nPlaces13, preu13, lloc13, temps13);
        llistaActivitatsOpcio13.afegir(actUnDiaOpccio13);
    }

    /**
     * OPCIO 14
     * Afegir una nova activitat periòdica 
     * bla vla bla
     * @param llistaActivitatsOpcio14
     */
    private static void opcio14(LlistaActivitats llistaActivitatsOpcio14){
        String nom14=introduirNomActivitat(llistaActivitatsOpcio14);

        System.out.print("Indica si voleu que s'hi puguin incriure PDI: ");
        String pdiString14=teclat.nextLine();
        Boolean pdiBoolea14=siONo(pdiString14);

        System.out.print("Indica si voleu que s'hi puguin incriure PTGAS: ");
        String ptgasString14=teclat.nextLine();
        Boolean ptgasBoolea14=siONo(ptgasString14);

        System.out.print("Indica si voleu que s'hi puguin incriure estudiants: ");
        String estudiantsString14=teclat.nextLine();
        Boolean estudiantsBoolea14=siONo(estudiantsString14);

        System.out.println("Introduiu la data Inicial");
        LocalDate dataIn14=introduirData();

        Boolean datacorrecta14=false;
        LocalDate dataFi14=null;
        do{
            System.out.println("Introduiu la data Final");
            dataFi14=introduirData();
            if (dataFi14.isAfter(dataIn14)){
                datacorrecta14=true;
            }
            else{ System.out.println("ERROR; la data de fi a de ser posterior a la de inici"); }

        }while (!datacorrecta14);

        System.out.println("\nIndica el dia de la setmana: ");
        String diasetmana14=teclat.nextLine();

        System.out.print("\nIndica nom del centre: ");
        String nomCentre14=teclat.nextLine();

        System.out.print("\nIndica nom del lloc: ");
        String lloc14=teclat.nextLine();

        System.out.println("Introduiex l'hora:");
        LocalTime temps14=introduirTemps();

        boolean correcte14=false;
        int nSetmanes14=0;
        while(!correcte14){
            try{
                System.out.print("\nIndica el nº de setmanes: ");
                nSetmanes14=Integer.parseInt(teclat.nextLine());
                if (nSetmanes14>0){
                    correcte14=true;
                }
                else{
                    System.out.println("ERROR; nº de setmanes negatiu");
                }
            } 
            catch(NumberFormatException exceptions){
                    System.out.println("ERROR; Ha de ser un valor numeric " + exceptions);
            }
        }

        correcte14=false;
        int nPlaces14=0;
        while(!correcte14){
            try{
                System.out.print("\nIndica el nº de places: ");
                nPlaces14=Integer.parseInt(teclat.nextLine());
                if (nPlaces14>0){
                    correcte14=true;
                }
                else{
                    System.out.println("ERROR; places negatiu");
                }
            } 
            catch(NumberFormatException exceptions){
                    System.out.println("ERROR; Ha de ser un valor numeric " + exceptions);
            }
        }

        correcte14=false;

        double preu14=0;
        while(!correcte14){
            try{
                System.out.println("\nIndica el preu: ");
                preu14=Integer.parseInt(teclat.nextLine());
                if (preu14>=0){
                    correcte14=true;
                }
                else{
                    System.out.println("ERROR; preu negatiu");
                }
            } 
            catch(NumberFormatException exceptions){
                    System.out.println("ERROR; Ha de ser un valor numeric " + exceptions);
            }
        }        

        ActivitatsPeriodiques actUnDiaOpccio14 = new ActivitatsPeriodiques(nom14, pdiBoolea14, ptgasBoolea14, estudiantsBoolea14, dataIn14, dataFi14, diasetmana14, nomCentre14, lloc14, temps14, nSetmanes14, nPlaces14, preu14);
        llistaActivitatsOpcio14.afegir(actUnDiaOpccio14);

    }

    /**
     * OPCIO 15
     * Afegir una nova activitat en línia
     * BLA BLA 
     * @param llistaActivitatsOpcio15
     */
    private static void opcio15(LlistaActivitats llistaActivitatsOpcio15){
        String nom15=introduirNomActivitat(llistaActivitatsOpcio15);

        System.out.print("Indica si voleu que s'hi puguin incriure PDI: ");
        String pdiString15=teclat.nextLine();
        Boolean pdiBoolea15=siONo(pdiString15);

        System.out.print("Indica si voleu que s'hi puguin incriure PTGAS: ");
        String ptgasString15=teclat.nextLine();
        Boolean ptgasBoolea15=siONo(ptgasString15);

        System.out.print("Indica si voleu que s'hi puguin incriure estudiants: ");
        String estudiantsString15=teclat.nextLine();
        Boolean estudiantsBoolea15=siONo(estudiantsString15);

        System.out.println("Introduiu la data Inicial");
        LocalDate dataIn15=introduirData();

        Boolean datacorrecta15=false;
        LocalDate dataFi15=null;
        do{
            System.out.println("Introduiu la data Final");
            dataFi15=introduirData();
            if (dataFi15.isAfter(dataIn15)){
                datacorrecta15=true;
            }
            else{ System.out.println("ERROR; la data de fi a de ser posterior a la de inici"); }

        }while (!datacorrecta15);

        /*ENLLAÇ */
        System.err.print("Introduiu l'enllaç (fins abans de l'arroba): ");
        String enllaç15=teclat.nextLine();

        /*Inici correjir */

        boolean correcte15=false;
        int periode15=0;
        while(!correcte15){
            try{
                System.out.println("\nIndica el preu: ");
                periode15=Integer.parseInt(teclat.nextLine());
                if (periode15>0){
                    correcte15=true;
                }
                else{
                    System.out.println("ERROR; preu negatiu");
                }
            } 
            catch(NumberFormatException exceptions){
                    System.out.println("ERROR; Ha de ser un valor numeric " + exceptions);
            }
        }        

        ActivitatsOnline actOnlineOpcio15 = new ActivitatsOnline(nom15, pdiBoolea15, ptgasBoolea15, estudiantsBoolea15, dataIn15, dataFi15, enllaç15, periode15);
        llistaActivitatsOpcio15.afegir(actOnlineOpcio15);
    }

    //valorar l'activitat per part de l'asistent
    private static void opcio16(LlistaActivitats llistaActs, LlistaInscripcio llistaIns){
        try{
            System.out.println("Quina activitat vols valorar?");
            String nomAct= teclat.nextLine();//llegim el nom de l'activitat per teclat
            Activitats act = llistaActs.getActivitatPerNom(nomAct);
            if(act==null){
                throw new NoExisteixActivitat(nomAct);
            }
            Inscripcions ins = llistaIns.getIncripcionsFromActivitat(act);

            System.out.println("Introdueix la valoracio de l'activitat");
            int puntuacio = teclat.nextInt();
            if(puntuacio<0 || puntuacio>10){
                throw new ForaDeRang(puntuacio, 0, 10);
            }
            ins.setValoracio(puntuacio);
            System.out.println("La valoració per aquesta activitat es de:"+ ins.getValoracio());
        }catch(NoExisteixActivitat e){
            System.out.println("No existeix l'activitat");
        }catch(ForaDeRang e){
            System.out.println("El valor esta fora de rang");
        }
    }
  
    /**
     * Opció 17: Obtenir un resum de les valoracions de les activitats acabades.
     * Programadora: Aina Garcia Albesa
     */
    private static void opcio17(){
        LlistaInscripcio llistaInscripcions = new LlistaInscripcio(100);

        // Obtenir la llista d'inscripcions de les activitats acabades
        LlistaInscripcio inscripcionsAcabades = new LlistaInscripcio(100);
        for (int i = 0; i < llistaInscripcions.getNumElements(); i++) {
            Inscripcions inscripcio = llistaInscripcions.getInscripcioPos(i);
            if (inscripcio != null && inscripcio.getActivitat().haFinalitzat()) {
                inscripcionsAcabades.afegir(null, inscripcio.getActivitat()); // Es necessita un usuari, però el mètode no ho utilitza
            }
        }

        String[] valoracioActivitats = inscripcionsAcabades.calcularValoracio(inscripcionsAcabades);

        System.out.println("--- RESUM DE LES VALORACIONS DE LES ACTIVITATS ACABADES ---");
        for (int i = 0; i < valoracioActivitats.length; i++) {
            if (valoracioActivitats[i] != null) {
                System.out.println(valoracioActivitats[i]);
            }
        }
    }

    private static void opcio18(Scanner teclat, LlistaInscripcio ins, LlistaActivitats acts, LlistaUsuaris usus){
        try {
            System.out.print("DNI/Alies usuari: ");
            String id = teclat.nextLine();

            Usuari u = null;
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

    //calcular i mostrar la mitja de valoracions que han fet els usuaris de cada col·lectiu
    /**recorrer totes les inscripcions de totes les activitats
     * agrupar les valoracions per colectius
     * calcular la mitja per cada col·lectiu i mostrar-la
    **/
    private static void opcio19(){
        String[] colectius = {"Estudiants", "Pdi", "Ptgas"};
        int sumaEstudiants=0, sumaPdi=0, sumaPtgas=0;
        int indexEstudiants=0, indexPdi=0, indexPtgas=0;

        LlistaActivitats llistaActs = new LlistaActivitats(10);
        LlistaInscripcio llistaIns = new LlistaInscripcio(10);
            
            
        for(int i=0; i<llistaActs.getNumElements();i++){
            for(int j=0; j<llistaIns.getNumElements();j++){
                Inscripcions ins = llistaIns.getInscripcioPos(i);
                int v = ins.getValoracio();
                if(v != 0){
                    Usuari u = ins.getInscrit(i);
                    if(u instanceof Estudiants){
                        sumaEstudiants++;
                        indexEstudiants++;
                    }else if(u instanceof Pdi){
                        sumaPdi++;
                        indexEstudiants++;
                    }else if(u instanceof Ptgas){
                        sumaPtgas++;
                        indexPtgas++;
                    }
                        
                }

            }
        }
        //mostrar la mitja de cada colectiu
        System.out.println("MITJA DE LES VALORACIONS DE CADA COL·LECTIU");
        if(indexEstudiants>0){
            System.out.println("Estudiants:"+((sumaEstudiants/indexEstudiants)));
        }else{
            System.out.println("No hi ha valoracions dels estudiants");
        }
        if(indexPdi>0){
            System.out.println("PDI:"+((sumaPdi/indexPdi)));
        }else{
            System.out.println("No hi ha valoracions dels PDI");
        }
        if(indexPtgas>0){
            System.out.println("Ptgas:"+((sumaPtgas/indexPtgas)));
        }else{
            System.out.println("No hi ha valoracions dels Ptgas");
        }
    }

    /**
     * OPCIO 20
     * Calcular l’usuari més actiu d’un cert col·lectiu, és a dir, el què s’ha apuntat a més activitats. En
     * cas d’empat s’escull qualsevol dels usuaris que compleixen els requisits. 
     * @param inscripcions20
     * @param colectiu15
     */
    private static void opcio20(LlistaInscripcio inscripcions20){
        Boolean correcte20=false;
        String colectiu20=null;
        do{
            System.out.print("De quin colectiu voleu mirar l'usuari més actiu:");
            colectiu20=teclat.nextLine();
            if (colectiu20.equals("PTGAS") || colectiu20.equals("PDI") || colectiu20.equals("estudiants")){
                correcte20=true;
            }
            else{ System.out.print("ERROR; les opcions son PTGAS, PDI o estudiants");}
        }while(!correcte20);

        /* RECORRER LLISTA INSCRIPCIO I FER UNA NOVA AMB NOMES ELS DELS COLETIU*/
        LlistaInscripcio llistacolectiu20= new LlistaInscripcio(inscripcions20.getNumElements()); 
        
        for (int i=0; i<inscripcions20.getNumElements(); i++){
            if (inscripcions20.getInscripcioPos(i).getActivitat().esPerA(colectiu20)==true) /* SI COLECTIU */
            {
                llistacolectiu20.AfegirInscripcio(inscripcions20.getInscripcioPos(i));
            }
        }

        /* SI NO HI HA RES A LA LLISTA NO HI HA CAP ACTIVITAT PER AL COLETIU */
        if (llistacolectiu20.getNumElements() == 0) { 
            System.out.println("No hi ha activitats del col·lectiu: " + colectiu20); 
            return; 
        }

        /* COMPARAR LA PERSONA AMB MAXIM Nº D'ACTIVITATS INSCRIT DE CADA ACTIVITAT  */
        String nom20 = llistacolectiu20.getInscripcioPos(0).getLlistaInscrits().usuariMesInscrit(); 
        int comptador20 = llistacolectiu20.getInscripcioPos(0).getLlistaInscrits().numeroMaximUsuariMesInscrit();
        for (int i = 0; i < llistacolectiu20.getNumElements(); i++) { 
            if (comptador20<llistacolectiu20.getInscripcioPos(i).getLlistaInscrits().numeroMaximUsuariMesInscrit()){
                nom20 = llistacolectiu20.getInscripcioPos(i).getLlistaInscrits().usuariMesInscrit(); 
                comptador20 = llistacolectiu20.getInscripcioPos(i).getLlistaInscrits().numeroMaximUsuariMesInscrit();
            }
        }

        System.out.print("El usuari més actiu de "+ colectiu20+" es: "+ nom20);
        
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

    private static Usuari buscarUsuariPerAlies(LlistaUsuaris usus, String alies) {
        for (int i = 0; i < usus.getnUsuaris(); i++) {
            Usuari u = usus.getUsuarisPos(i);
            if (u != null && u.getAlies() != null && u.getAlies().equalsIgnoreCase(alies)) return u;
        }
        return null;
    }
  
      /**
     * Mètode que filtra les activitats disponibles per a un usuari
     * Programadora: Aina Garcia Albesa
     * @param activitats
     * @param usuari
     * @return llista amb les activitats que un usuari pot fer
     */
    private static Activitats[] mostrarActDisponiblesUsuari(LlistaActivitats activitats, Usuari usuari){
        Activitats[] actDisponibles = new Activitats[100];
            int pos = 0; //Posició dins de la taula String

        for (int i=0; i < activitats.getNumElements();i++){
            Activitats activitat = activitats.getActivitatPos(i);

            if (!activitat.haFinalitzat()){
                if (usuari instanceof Estudiants && activitat.isEstudiants()){
                    actDisponibles[pos] = activitat;
                    pos++;
                }
                if (usuari instanceof Pdi && activitat.isPDI()){
                    actDisponibles[pos] = activitat;
                    pos++;
                }
                if (usuari instanceof Ptgas && activitat.isPTGAS()){
                    actDisponibles[pos] = activitat;
                    pos++;
                }
            }
        }
        return actDisponibles;
    }
    private static boolean estaInscrit(Inscripcions ins, Usuari u) {
        return (buscarAliesEnLlista(ins.getLlistaInscrits(), u.getAlies()) || 
                buscarAliesEnLlista(ins.getLlistaDeEspera(), u.getAlies()));
    }

    private static boolean buscarAliesEnLlista(LlistaUsuaris llista, String alies) {
        boolean trobat = false;
        for (int i = 0; i < llista.getnUsuaris() && !trobat; i++) {
            if (llista.getUsuarisPos(i).getAlies().equals(alies)) trobat = true;
        }
        return trobat;
    }

    /*FUNCIONS AUXILIARS: */
    /**
     * Pregunta si o no per pasar a boolea
     * Si no entroduim si o no ho torna a demanar
     * @param resposta es el string de la resposta
     * @return boolea amb   true => si
     *                      false => no
     */
    private static boolean siONo(String resposta){
        boolean opcio=true;
        boolean correcte=false;
        while (!correcte){
            if (resposta.equals("si")){
                opcio=true;
                correcte=true;
            }
            else if (resposta.equals("no")){
                opcio=false;
                correcte=true;
            }
            else {
                System.out.println("ERROR; RESPOSTA INCORRECTE => Introduiu de nou la resposta (si o no):");
                resposta=teclat.nextLine();
            }
        }
        return opcio;
    }

    /**
     * Assignar un nom a una activitat
     * Si l'activitat ja existeix demana un altre
     * @param llistaActivitats es la llista d'on comprobem si ja existeix la activitat
     * @return variable tipus String amb el nom
     */
    private static String introduirNomActivitat(LlistaActivitats llistaActivitats){
        Boolean hiHa=false;
        String nom;
        System.out.print("Introduïu el nom de l'activitat: ");
        nom=teclat.nextLine();
        if (llistaActivitats!=null){
            hiHa= llistaActivitats.hiHaActivitat(nom);
        }
        while(hiHa){
            System.out.println("ERROR => ACTIVITAT JA REGISTRADA; Introduïu el nom de l'activitat: ");
            nom=teclat.nextLine();
            if (llistaActivitats!=null){
                hiHa= llistaActivitats.hiHaActivitat(nom);
            }
        }
        return nom;
    }

    /**
     * Introduir una Data
     * Si el dia, mes, o any son incorrectes salta una excepciuio i ho torna a demanar
     * Si es un valor no numeric salta una excepcio i ho torna a demanr
     * @return variable tipus LocalDate amb la data
     */
    private static LocalDate introduirData() {
        LocalDate data = null;
        boolean dataCorrecta = false;

        while (!dataCorrecta) {
            try {
                System.out.print("Dia: ");
                int dia = Integer.parseInt(teclat.nextLine());

                System.out.print("Mes: ");
                int mes = Integer.parseInt(teclat.nextLine());

                System.out.print("Any: ");
                int any = Integer.parseInt(teclat.nextLine());

                data = LocalDate.of(any, mes, dia);
                dataCorrecta = true;

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Has d'introduir un valor numèric.");
            } catch (DateTimeException e) {
                System.out.println("ERROR: La combinació dia/mes/any no és vàlida.");
            }
        }
        return data;
    }

    /**
     * Introdueix les dades de una hora
     * Si l'hora o minuts es incorrecte ho torna a demanar 
     * Si untroduim un valor no numeric sanlat una excepcio i ho torna a demanar 
     * @return variable tipus LocalTime amb la hora
     */
    public static LocalTime introduirTemps (){
        Boolean ValorHoraCorrecte=false;
        LocalTime temps=null;
        while (!ValorHoraCorrecte){
            try{
                System.out.print("Hora: ");
                int hora=Integer.parseInt(teclat.nextLine());
                
                System.out.print("Minut: ");
                int minut=Integer.parseInt(teclat.nextLine());
                
                temps = LocalTime.of(hora, minut);
                ValorHoraCorrecte=true;
            }
            catch(NumberFormatException exceptions){
                System.out.println("ERROR; Ha de ser un valor numeric " + exceptions);
            }
            catch(DateTimeException exceptions){
                System.out.println("ERROR; Valors de l'hora incorrectes "+ exceptions);
            }
        } 
        return temps;
    }

    // Mètodes per fitxers serialitzats
    /*private static void guardarInscripcions(LlistaInscripcio llista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOM_FITXER))) {
            oos.writeObject(llista);
            System.out.println("Dades guardades correctament al fitxer: " + NOM_FITXER);
        } catch (IOException e) {
            System.err.println("Error en guardar les dades: " + e.getMessage());
        }
    }

    private static LlistaInscripcio carregarInscripcions() {
        File fitxer = new File(NOM_FITXER);
        if (!fitxer.exists()) {
            System.out.println("No s'ha trobat cap fitxer de dades. Inicialitzant llista buida.");
            return new LlistaInscripcio(100); // Mida per defecte segons el teu codi
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOM_FITXER))) {
            LlistaInscripcio llista = (LlistaInscripcio) ois.readObject();
            System.out.println("Dades carregades correctament.");
            return llista;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en carregar les dades: " + e.getMessage());
            return new LlistaInscripcio(100);
        }
    }*/
}
