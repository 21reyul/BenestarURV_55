import java.util.Scanner;

import ActivitatsPackage.LlistaActivitats;

public class App {
    static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
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
                    opcio7();
                    break;

                case 8:
                    opcio8();
                    break;

                case 9:
                    opcio9();
                    break;

                case 10:
                    opcio10(usuari);
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

    private static void opcio7(){

    }

    private static void opcio8(){

    }

    private static void opcio9(){

    }

    private static void opcio10(Usuari usuari){ //TODO 1 importar fitxer per usuari
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
