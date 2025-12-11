import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import UsuarisPackage.Usuari;
public class App {
    static Scanner teclat = new Scanner(System.in);
    private static LocalDate data = LocalDate.now();

    public static void main(String[] args) throws Exception{
        boolean fi=false;
        while (!fi){
            int opcio = 1;
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
 * Mostrar les dades de les activitats en la data d'avui
 * @param dades
 * @param data
 * @return activitatsAvui, llista de les activitats que estan disponibles avui
*/
private static void opcio4(){

}

private static void opcio5(){

}

private static void opcio6(){

}

private static void opcio7(){

}

private static void opcio8(){

}

private static void opcio9(){

}

private static void opcio10(){
    /* 
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
    */
}

private static void opcio11(){

}

private static void opcio12(){

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

private static void opcio18(){

}

private static void opcio19(){

}

private static void opcio20(){

}

private static void opcio21(){

}
}


