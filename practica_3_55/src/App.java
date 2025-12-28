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
                    System.out.print("Introdueix el teu alies: ");
                    String alies = teclat.nextLine();
                    Usuaris usuariActual = llistaUsuaris.buscarUsuariPerAlies(alies);
                    
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

    private static void opcio7(){

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
    private static void opcio10(Usuaris usuari){ //TODO 1 importar fitxer per usuari
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

    private static void opcio13(){

    }

    private static void opcio14(){

    }

    private static void opcio15(){

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

    private static void opcio20(){

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
    private static Activitats[] mostrarActDisponiblesUsuari(LlistaActivitats activitats, Usuaris usuari){
        Activitats[] actDisponibles = new Activitats[100];
            int pos = 0; //Posició dins de la taula String

        for (int i=0; i < activitats.getNumElements();i++){
            Activitats activitat = activitats.getActivitatPos(i);

            if (!activitat.haFinalitzat()){
                if (usuari instanceof Estudiants && activitat.isEstudiants()){
                    actDisponibles[pos] = activitat;
                    pos++;
                }
                if (usuari instanceof PDI && activitat.isPDI()){
                    actDisponibles[pos] = activitat;
                    pos++;
                }
                if (usuari instanceof PTGAS && activitat.isPTGAS()){
                    actDisponibles[pos] = activitat;
                    pos++;
                }
            }
        }
        return actDisponibles;
    }
    private static boolean estaInscrit(Inscripcions ins, Usuaris u) {
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
