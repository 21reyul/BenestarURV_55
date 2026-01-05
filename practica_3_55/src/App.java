import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ActivitatsPackage.*;
import UsuarisPackage.*;

public class App {
    static Scanner teclat = new Scanner(System.in);
    //private static final String NOM_FITXER = "inscripcions.bin";
    static LlistaUsuaris llistaUsuaris = new LlistaUsuaris(100);
    static LlistaActivitats llistaActivitats = new LlistaActivitats(100);
    static LlistaInscripcio llistaInscripcio;

    public static void main(String[] args) throws FileNotFoundException {
        LlistaActivitats llistaactivitats=new LlistaActivitats(10);
        boolean fi=false;
        while (!fi){
            switch(opcio) {
                case 1:
                    opcio1();
                    break;

                case 2:
                    opcio2();
                    break;

                case 3:
                    opcio3();
                    break;

                case 4:
                    opcio4();
                    break;

                case 5:
                    opcio5();
                    break;

                case 6:
                    opcio6();
                    break;

                case 7:
                    /* Mostrar el detall d’informació d’una activitat a partir del seu nom. */
                    opcio7(llistaactivitats);
                    break;

                case 8:
                    opcio8();
                    break;

                case 9:
                    opcio9();
                    break;

                case 10:
                    System.out.print("Introdueix el teu alies: ");
                    String alies = teclat.nextLine();
                    Usuari usuariActual = llistaUsuaris.buscarUsuariPerAlies(alies);
                    
                    if (usuariActual == null) {
                        System.out.println("L'usuari no existeix.");
                    } else {
                        opcio10(usuariActual);
                    }
                    break;

                case 11:
                    opcio11();
                    break;

                case 12:
                    opcio12();
                    break;

                case 13:
                    opcio13(llistaactivitats);
                    break;

                case 14:
                    opcio14(llistaactivitats);
                    break;

                case 15:
                    opcio15(llistaactivitats);
                    break;

                case 16:
                    opcio16();
                    break;

                case 17:
                    opcio17();
                    break;

                case 18:
                    opcio18();
                    break;

                case 19:
                    opcio19();
                    break;

                case 20:
                    opcio20();
                    break;

                case 21:
                    opcio21();
                    break;

                case 22:
                    //guardarInscripcions(llistaInscripcio);
                    fi=true;
                    System.out.println("Sortint del programa");
                    break;

                default:
                    System.out.println("Opcio no valida");
                    break;
                
            }
        }
    }

    private static void opcio1(){

    }

    private static void opcio2(){

    }

    private static void opcio3(){

    }

    private static void opcio4(){

    }

    private static void opcio5(){

    }

    private static void opcio6(){

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

    private static void opcio8(){

    }

    private static void opcio9(){

    }

    /**
     * Opció 10: inscriure a un usuari
     * Programadora: Aina Garcia Albesa
     * @param usuari
     */
    private static void opcio10(Usuari usuari){ //TODO 1 importar fitxer per usuari
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
                if (llistaInscripcio.getInscripcionsPos(i).getActivitat().getNomActivitat().equals(act.getNomActivitat())) {
                    ins = llistaInscripcio.getInscripcionsPos(i);
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


    private static void opcio11(){

    }

    private static void opcio12(){

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
        llistaActivitatsOpcio13.Afegir(actUnDiaOpccio13);
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
        llistaActivitatsOpcio14.Afegir(actUnDiaOpccio14);

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
        llistaActivitatsOpcio15.Afegir(actOnlineOpcio15);
    }

    private static void opcio16(){

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
            Inscripcions inscripcio = llistaInscripcions.getInscripcionsPos(i);
            if (inscripcio != null && inscripcio.getActivitat().haFinalitzat()) {
                inscripcionsAcabades.Afegir(null, inscripcio.getActivitat()); // Es necessita un usuari, però el mètode no ho utilitza
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


    private static void opcio18(){

    }

    private static void opcio19(){

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

    private static void opcio21(){

    }

    // Mètodes auxiliars opció 10
    
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