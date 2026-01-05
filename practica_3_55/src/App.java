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

private static void opcio2(){

}

private static void opcio3(){

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

private static void opcio5(){

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

private static void opcio9(){

}
 
private static void opcio10(){
   
    
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

private static void opcio18(){

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

private static void opcio21(){

}
}


