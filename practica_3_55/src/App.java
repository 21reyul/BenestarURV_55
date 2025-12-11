import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

private void menu(int opcio){
    boolean fi=false;
    while (!fi){
        switch(opcio){
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
                System.out.println("S'ortint del programa");
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
    LocalDate data = LocalDate.now();
    try{
        System.out.println("La data del dia d'avui es:\s" + data.getDayOfMonth() + "/" + data.getMonthValue() + "/"+ data.getYear());
        String resposta;
        System.out.println("Si vols modificar la data introdueix: Si");
        resposta=teclat.nextLine().toLowerCase();//llegim la resposta de teclat, si es que si, entrem en un bucle per modificar la data

        if(resposta.equals("Si")){
            System.out.println("Introdueix el nou dia:");
            var diaNou=Integer.parseInt(teclat.nextLine());

            System.out.println("Introdueix el nou mes:");
            var mesNou=Integer.parseInt(teclat.nextLine());

            System.out.println("Introdueix el nou any:");
            var anyNou=Integer.parseInt(teclat.nextLine());

            if(diaNou >= 1 && diaNou <= 31 && mesNou >= 1 && mesNou <= 12 && anyNou>0){
                LocalDate dataNova = LocalDate.of(diaNou, mesNou, anyNou);
                System.out.println("Data actualitzada:\s" + dataNova.getDayOfMonth() + "/" + dataNova.getMonth() + "/" + dataNova.getYear());
            }else{
                System.out.println("Data incorrecta");
            }
        }else{
            System.out.println("No s'ha modificat la data,  la data del dia d'avui es:\s" + data.getDayOfMonth() + "/" + data.getMonthValue() + "/"+ data.getYear());
        }
    }catch(NumberFormatException e){
        System.out.println("Les dades introduïdes han de ser enters");
    }
}

private void opcio2(){

}

private void opcio3(){

}

/**
 * Mostrar les dades de les activitats en la data d'avui
 * @param dades
 * @param data
 * @return activitatsAvui, llista de les activitats que estan disponibles avui
 */
private LlistaActivitats opcio4(LlistaActivitats dades, LocalDate data){
    boolean hiHaActivitats=false;
    LlistaActivitats activitatsAvui = new LlistaActivitats(numElements);
    for(int i=0; i<dades.getNumElements(); i++){
        Activitats act = dades.getLlista();
        if(!data.isBefore(act.getDataINI())&& !data.isAfter(act.getDataFi())){
            activitatsAvui.Afegir(act);
            hiHaActivitats=true;
        }
    }
    if(hiHaActivitats){
        System.out.println("Activitats disponibles avui");
        for(int i=0; i<activitatsAvui.getNumElements();i++){
            activitatsAvui[i].toString();
        }
    }
    return activitatsAvui;
}

private void opcio5(){

}

private void opcio6(){

}

private void opcio7(){

}

private void opcio8(){

}

private void opcio9(){

}

private void opcio10(){

}

private void opcio11(){

}

private void opcio12(){

}

private void opcio13(){

}

private void opcio14(){

}

private void opcio15(){

}

private void opcio16(){

}

private void opcio17(){

}

private void opcio18(){

}

private void opcio19(){

}

private void opcio20(){

}

private void opcio21(){

}


