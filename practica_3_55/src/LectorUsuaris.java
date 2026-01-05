import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import UsuarisPackage.*;

public class LectorUsuaris {

    // Format del fitxer:
    // TIPUS;ALIES;CORREU;CAMPUS;EXTRA
    // PDI    -> EXTRA = nomDept
    // PTGAS  -> EXTRA = "-"
    // EST    -> CAMPUS = ensenyament, EXTRA = anyIni (int)
    public static void llegirFitxer(LlistaUsuaris llistaUsu) {

        File fitxer = new File("\\C:\\Users\\aroag\\Desktop\\BenestarURV_55\\practica_3_55\\src\\Usuaris.txt\\");

        try (Scanner sc = new Scanner(fitxer)) {

            int liniaNum = 0;

            while (sc.hasNextLine()) {
                liniaNum++;
                String linia = sc.nextLine().trim();

                if (linia.isEmpty() || linia.startsWith("#")) continue;

                String[] p = linia.split(";");
                if (p.length < 5) {
                    System.err.println("Línia " + liniaNum + " incorrecta (falten camps): " + linia);
                    continue;
                }

                String tipus  = p[0].trim().toUpperCase();
                String alies  = p[1].trim();
                String correu = p[2].trim();
                String campus = p[3].trim();
                String extra  = p[4].trim();

                try {
                    Usuari u;

                    switch (tipus) {
                        case "PDI":
                            // PDI(String alies, String correu, String nomDept, String campus)
                            u = new Pdi(alies, correu, extra, campus);
                            break;

                        case "PTGAS":
                            // PTGAS(String alies, String correu, String campus)
                            u = new Ptgas(alies, correu, campus);
                            break;

                        case "EST":
                        case "ESTUDIANT":
                        case "ESTUDIANTS":
                            // Estudiants(String alies, String correu, String ensenyament, int anyIni)
                            int anyIni = Integer.parseInt(extra);
                            String ensenyament = campus;
                            u = new Estudiants(alies, correu, ensenyament, anyIni);
                            break;

                        default:
                            System.err.println("Línia " + liniaNum + ": tipus desconegut -> " + tipus);
                            continue;
                    }

                    llistaUsu.afegir(u);

                } catch (NumberFormatException e) {
                    System.err.println("Línia " + liniaNum + ": anyIni no és int -> " + extra);
                } catch (Exception e) {
                    System.err.println("Línia " + liniaNum + ": error creant usuari -> " + e.getMessage());
                }
            }

            System.out.println("Usuaris carregats correctament.");

        } catch (FileNotFoundException e) {
            System.err.println("No s'ha trobat el fitxer: Usuaris.txt");
        }
    }
}



