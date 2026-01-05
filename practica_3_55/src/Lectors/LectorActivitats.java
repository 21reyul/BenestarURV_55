package Lectors;
import ActivitatsPackage.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LectorActivitats {

    public static void llegirFitxer(LlistaActivitats lista) {
        // Formateadores para fechas y horas del archivo 
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        
        // El archivo está fuera de src, se accede directamente por su nombre 
        File fichero = new File("C:\\Practica3\\practica_3_55\\src\\Activitats.txt");
        

        try (Scanner lector = new Scanner(fichero)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                
                // Ignorar líneas vacías o comentarios
                if (linea.isEmpty() || linea.startsWith("#")) continue;

                // Separar los datos por punto y coma 
                String[] p = linea.split(";");

                // Datos comunes de la clase padre (Activitats) 
                String nom = p[0];
                boolean pdi = Boolean.parseBoolean(p[1]);
                boolean ptgas = Boolean.parseBoolean(p[2]);
                boolean estud = Boolean.parseBoolean(p[3]);
                LocalDate dIni = LocalDate.parse(p[4], dateFormat);
                LocalDate dFi = LocalDate.parse(p[5], dateFormat);

                // Lógica para diferenciar tipos según número de columnas 
                if (p.length == 13) { 
                    // PERIODIQUES: p[6]=dia, p[7]=centre, p[8]=ciutat, p[9]=hora, p[10]=setmanes, p[11]=places, p[12]=preu
                    lista.afegir(new ActivitatsPeriodiques(nom, pdi, ptgas, estud, dIni, dFi, p[6], p[7], p[8], LocalTime.parse(p[9], timeFormat),Integer.parseInt(p[10]), Integer.parseInt(p[11]), Double.parseDouble(p[12])));
                } 
                else if (p.length == 10) {
                    // UN DIA: p[6]=places, p[7]=preu, p[8]=ciutat, p[9]=hora
                    lista.afegir(new ActivitatsUnDia(
                        nom, pdi, ptgas, estud, dIni, dFi,
                        Integer.parseInt(p[6]), Double.parseDouble(p[7]), p[8], LocalTime.parse(p[9], timeFormat)
                    ));
                } 
                else if (p.length == 9) {
                    // ONLINE: p[6]=enllaç, p[7]=dataIniInterna, p[8]=periode
                    lista.afegir(new ActivitatsOnline(nom, pdi, ptgas, estud, LocalDate.parse(p[7], dateFormat), dFi, p[6], Integer.parseInt(p[8])));
                }
            }
            System.out.println("Carga finalizada. Total actividades: " + lista.getNumElements());
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se encontró el archivo 'Activitats.txt' en la raíz del proyecto.");
        } catch (Exception e) {
            System.err.println("Error procesando el archivo: " + e.getMessage());
        }
        
    }
}
