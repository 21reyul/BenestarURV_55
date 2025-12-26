import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import UsuarisPackage.*;
import e.*;
import ActivitatsPackage.*;
public class App {
    static Scanner teclat = new Scanner(System.in);
    private static LocalDate data = LocalDate.now();

    public static void main(String[] args) throws Exception{
        boolean fi=false;
        while (!fi){
            int opcio = 11;
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
                    opcio7();
                    break;

                case 8:
                    opcio8();
                    break;

                case 9:
                    opcio9();
                    break;

                case 10:
                    opcio10();
                    break;

                case 11:
                    opcio11();
                    break;

                case 12:
                    opcio12();
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
    String resposta;
    System.out.println("Si vols modificar la data introdueix: OK");
    resposta=teclat.nextLine();//llegim la resposta de teclat, si es que si, entrem en un bucle per modificar la data

    try{
        if(resposta.equals("OK")){
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

private static void opcio2(){

}

private static void opcio3(){

}


/**
 * Mostrar la informació de les activitats que tenen classe en la data d'avui, 
 * 
*/
private static void opcio4(){
    boolean ple=false;
    boolean hiHaEspera=false;
    int compt=0;

    try{
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
    }catch (NullPointerException e) {
        System.out.println("");
    }catch (ExisteixActivitat e){
        System.out.println(e);
    }
}

private static void opcio5(){

}

//mostrar el nom de les activitats amb places disponibles
private static void opcio6(){
    //TODO 1: implementar les excepcions
    try{
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
    }catch(){

    }
}

private static void opcio7(){

}

//Mostrar un usuari sgeons el nom
private static void opcio8(){
    try{
        //TODO 1: implementar les excepcions
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
    }catch(){

    }
}

private static void opcio9(){

}
 
private static void opcio10(){
    
   private static void opcio10(Usuari usuari){ //TODO 1 importar fitxer per usuari
        System.out.println("Activitats disponibles");
        LlistaActivitats activitats = new LlistaActivitats(0);
        String activitat;
        for (int i=0; i<activitats.length; i++) //TODO 2 posar el nom de la llista
        {
            System.out.println(activitats[i].getActivitat);
        }
        System.out.println("A quina activitat et vols inscriure?");
        activitat=teclat.nextLine(); //TODO 3 definir Scanner teclat
        activitat.inscriures(usuari); 
    }
    
}

//Mostrar llista d'inscripcions per activitat
private static void opcio11(){
    try{
        //TODO 1: implementar les excepcions
        System.out.println("De quina activitat vols obtenir la llista d'incripcions");
        String nomAct= teclat.nextLine();//llegim el nom de l'activitat per teclat
        
        //Crear instancies de les llistes
        LlistaActivitats llistaActs = new LlistaActivitats(10);
        LlistaInscripcio llistaIns = new LlistaInscripcio(10);
        
        Activitats act = llistaActs.getActivitatPerNom(nomAct);
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
    }catch(){
        
    }
}

private static void opcio12(){

}

private static void opcio13(){

}

private static void opcio14(){

}

private static void opcio15(){

}

//valorar l'activitat per part de l'asistent
private static void opcio16(){
    
}

private static void opcio17(){

}

private static void opcio18(){

}

//calcular i mostrar la mitja de valoracions que han fet els usuaris de cada col·lectiu
private static void opcio19(){

}

private static void opcio20(){

}

private static void opcio21(){

}
}


