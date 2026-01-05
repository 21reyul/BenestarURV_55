import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import ActivitatsPackage.*;
import Exception.DataIncorrectaException;
import Exception.GestorDates;
import UsuarisPackage.*;

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


/**
 * Indica la data del dia en el que estem, aquesta inicialment sera la del servidor
 * Conté l'opcio de modificar la data per poder elaborar els diferents jocs de proves
 */
public static void opcio1(){
    
    Scanner teclat = new Scanner(System.in);
    //La data inicial sera la del servidor
    System.out.println("La data del dia d'avui es:\s" + data.getDayOfMonth() + "/" + data.getMonthValue() + "/"+ data.getYear());
    System.out.println("Si vols modificar la data introdueix: OK");
    String resposta=teclat.nextLine();//llegim la resposta de teclat, si es que si, entrem en un bucle per modificar la data
    try{
        if(resposta.equalsIgnoreCase("OK")){
            System.out.println("Introdueix el nou any:");
            var anyNou=Integer.parseInt(teclat.nextLine());
                        
            System.out.println("Introdueix el nou mes:");
            var mesNou=Integer.parseInt(teclat.nextLine());

            System.out.println("Introdueix el nou dia:");
            var diaNou=Integer.parseInt(teclat.nextLine());

            if(diaNou >= 1 && diaNou <= 31 && mesNou >= 1 && mesNou <= 12 && anyNou>0){
                data = LocalDate.of(anyNou, mesNou, diaNou);
                System.out.println("Data actualitzada:\s" + data.getDayOfMonth() + "/" + data.getMonth() + "/" + data.getYear());
            }else{
                System.out.println("Data incorrecta");
            }
        }else{
            System.out.println("No s'ha modificat la data,  la data del dia d'avui es:\s" + data.getDayOfMonth() + "/" + data.getMonthValue() + "/"+ data.getYear());
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
    private static void opcio4(){
        boolean ple=false;
        boolean hiHaEspera=false;
        int compt=0;

        
        //canviar a les intàncies generals, sol son de prova
        LlistaActivitats llistaActs = new LlistaActivitats(10);
        LlistaInscripcio llistaIns = new LlistaInscripcio(10);
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

    private static void opcio7(){

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

    

    private static void opcio13(){

    }

    private static void opcio14(){

    }

    private static void opcio15(){

    }

    //valorar l'activitat per part de l'asistent
    private static void opcio16(){
        try{
            System.out.println("Quina activitat vols valorar?");
            String nomAct= teclat.nextLine();//llegim el nom de l'activitat per teclat
            LlistaActivitats llistaActs = new LlistaActivitats(10);
            LlistaInscripcio llistaIns = new LlistaInscripcio(10);
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

    private static void opcio17(){

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
            for(int j=0; j<llistaIns.getNumElem();j++){
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
            System.out.println("PDI:"+((sumaEstudiants/indexEstudiants)));
        }else{
            System.out.println("No hi ha valoracions dels estudiants");
        }
        if(indexPdi>0){
            System.out.println("PDI:"+((sumaPdi/indexPdi)));
        }else{
            System.out.println("No hi ha valoracions dels estudiants");
        }
        if(indexPtgas>0){
            System.out.println("PDI:"+((sumaPtgas/indexPtgas)));
        }else{
            System.out.println("No hi ha valoracions dels estudiants");
        }
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

    private static Usuari buscarUsuariPerAlies(LlistaUsuaris usus, String alies) {
        for (int i = 0; i < usus.getnUsuaris(); i++) {
            Usuari u = usus.getUsuarisPos(i);
            if (u != null && u.getAlies() != null && u.getAlies().equalsIgnoreCase(alies)) return u;
        }
        return null;
    }
}
