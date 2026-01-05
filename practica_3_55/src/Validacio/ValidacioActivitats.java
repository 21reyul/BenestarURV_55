package Validacio;

import java.time.LocalDate;
import java.time.LocalTime;

import ActivitatsPackage.ActivitatsOnline;
import ActivitatsPackage.ActivitatsPeriodiques;
import ActivitatsPackage.ActivitatsUnDia;

/* Programadora: Aina Garcia Albesa */

/*VALIDACIO ACTIVITATS */
public class ValidacioActivitats {
    public static void main(String[] args) throws Exception {
        ActivitatsOnline actOnline1 = new ActivitatsOnline("Orientacio per fer mobilitat internacional", true, true, false, LocalDate.of(2025, 12, 1) , 
                                                    LocalDate.of(2025, 12, 18), "https://youtu.be/mobilitat-urv-2026", LocalDate.of(2025, 1, 20), 30);
        
        ActivitatsOnline actOnline2 = new ActivitatsOnline("Introduccio al campus virtual", true, true, true, LocalDate.of(2025, 9, 1) , 
                                                    LocalDate.of(2025, 9, 6), "https://youtu.be/introduccio-campus-virtual", LocalDate.of(2025, 9, 10), 300); 
                                                    
        ActivitatsPeriodiques actPer1 = new ActivitatsPeriodiques("Curs B2 d'angles per a estudiants", false, false, true, LocalDate.of(2025, 9, 5) , 
                                                    LocalDate.of(2025, 9, 22), "dijous", "Campus Catalunya", "Tarragona", LocalTime.of(17, 30), 
                                                    LocalDate.of(2025, 10, 15), 20, 25, 100.0);
        
        ActivitatsPeriodiques actPer2 = new ActivitatsPeriodiques("Curs B2 d'angles per a professorat i administracio", true, true, false, LocalDate.of(2025, 9, 5) , 
                                                    LocalDate.of(2025, 9, 22), "dimarts", "Campus Catalunya", "Tarragona", LocalTime.of(17, 30), 
                                                    LocalDate.of(2025, 10, 15), 15, 25, 70.0);

        ActivitatsUnDia actDia1 = new ActivitatsUnDia("Seguretat a internet", false, false, true, LocalDate.of(2025, 12, 2), 
                                                    LocalDate.of(2025, 12, 9), 20, 5.0, "Tarragona", LocalTime.of(17, 0));   

        ActivitatsUnDia actDia2 = new ActivitatsUnDia("Senderisme", true, true, true, LocalDate.of(2025, 12, 2), 
                                                    LocalDate.of(2025, 12, 9), 40, 10.0, "Amposta", LocalTime.of(10, 0)); 
        
        validarActOnline(actOnline1, actOnline2);
        validarActPer(actPer1, actPer2);
        validarActUnDia(actDia1, actDia2);
    }

    // ---- Comprobacions classe ActivitatsOnline ----
    private static void validarActOnline(ActivitatsOnline actOnline1, ActivitatsOnline  actOnline2){
        System.out.println("COMPROBACIO CLASSE ACTIVITATSONLINE:\n\n");

        // getters
        System.out.println("Infromacio activitat online 1 =>\n Nom = "+actOnline1.getNomActivitat()+" Data = "+actOnline1.getDataIni()+" Periode = "+actOnline1.getPeriode()+" dies\n"); 
        System.out.println("Infromacio activitat online 2 =>\n Nom = "+actOnline2.getNomActivitat()+" Data = "+actOnline2.getDataIni()+" Periode = "+actOnline2.getPeriode()+" dies\n"); 

        // setters 
        actOnline1.setNomActivitat("Reunio mobilitat internacional");
        actOnline1.setPDI(false);
        actOnline1.setPTGAS(false);
        actOnline1.setEstudiants(true);
        actOnline1.setDataIni(LocalDate.of(2025,12, 19));
        actOnline1.setPeriode(50);
        System.out.println("Infromacio activitat online 1 modificada =>\n Nom = "+actOnline1.getNomActivitat()+" Data = "+actOnline1.getDataIni()+" Periode = "+actOnline1.getPeriode()+" dies\n"); 

        // toString
        System.out.println(actOnline1.toString());
        System.out.println(actOnline2.toString());
    }

    // ---- Comprobacions classe ActivitatsPeriodiques ----
    private static void validarActPer(ActivitatsPeriodiques actPer1, ActivitatsPeriodiques actPer2){
        
        System.out.println("COMPROBACIO CLASSE ACTIVITATSPERIODIQUES:\n\n");
        // getters
        System.out.println("Infromacio activitat periodica 1 =>\n Nom = "+actPer1.getNomActivitat()+" Dia de la setmana = "+actPer1.getDiaDeLaSemana()+" Centre on es fa = "+actPer1.getNomCentre()+
                            " Ciutat = "+actPer1.getCiutat()+" Hora = "+actPer1.getHora()+" Data d'inici = "+actPer1.getDataIni()+" Setmanes de duració = "+actPer1.getNumSetmanes()+" Places = "+actPer1.getLimitPlaces()+" Preu = "+actPer1.getPreu()+" euros"); 
            
        System.out.println("Infromacio activitat periodica 2 =>\n Nom = "+actPer2.getNomActivitat()+" Dia de la setmana = "+actPer2.getDiaDeLaSemana()+" Centre on es fa = "+actPer2.getNomCentre()+
                            " Ciutat = "+actPer2.getCiutat()+" Hora = "+actPer2.getHora()+" Data d'inici = "+actPer2.getDataIni()+" Setmanes de duració = "+actPer2.getNumSetmanes()+" Places = "+actPer2.getLimitPlaces()+" Preu = "+actPer2.getPreu()+" euros"); 

        // setters 
        actPer2.setDiaDeLaSemana("dimarts");
        actPer2.setNomCentre("Campus Bellisens");
        actPer2.setCiutat("Reus");
        actPer2.setHora(LocalTime.of(17, 00));
        actPer2.setDataIni(LocalDate.of(2025, 9, 30));
        actPer2.setNumSetmanes(25);
        actPer2.setLimitPlaces(20);
        actPer2.setPreu(110);
        System.out.println("Infromacio activitat periodica 2 modificada =>\n Nom = "+actPer2.getNomActivitat()+" Dia de la setmana = "+actPer2.getDiaDeLaSemana()+" Centre on es fa = "+actPer2.getNomCentre()+
                            " Ciutat = "+actPer2.getCiutat()+" Hora = "+actPer2.getHora()+" Data d'inici = "+actPer2.getDataIni()+" Setmanes de duració = "+actPer2.getNumSetmanes()+" Places = "+actPer2.getLimitPlaces()+" Preu = "+actPer2.getPreu()+" euros"); 

        // toString
        System.out.println(actPer1.toString());
        System.out.println(actPer2.toString());
    }

    // ---- Comprobacions classe ActivitatsUnDia ----
    private static void validarActUnDia(ActivitatsUnDia actDia1, ActivitatsUnDia actDia2){
        System.out.println("COMPROBACIO CLASSE ACTIVITATSUNDIA:\n\n");

        // getters
        System.out.println("Informacio activitat d'un dia 1 =>\n Nom = "+actDia1.getNomActivitat()+" Hora = "+actDia1.getHora()+" Places = "+actDia1.getLimitPlaces()+
                            " Preu = "+actDia1.getPreu()+" euros Ciutat = "+actDia1.getCiutat());

        System.out.println("Informacio activitat d'un dia 2 =>\n Nom = "+actDia2.getNomActivitat()+" Hora = "+actDia2.getHora()+" Places = "+actDia2.getLimitPlaces()+
                            " Preu = "+actDia2.getPreu()+" euros Ciutat = "+actDia2.getCiutat());
            
        // setters
        actDia1.setHora(LocalTime.of(17, 45, 0));
        actDia1.setPlaces(25);
        actDia1.setPreu(7);
        actDia1.setCiutat("Barcelona");
        System.out.println("Informacio activitat d'un dia 1 modificada =>\n Nom = "+actDia1.getNomActivitat()+" Hora = "+actDia1.getHora()+" Places = "+actDia1.getLimitPlaces()+
                            " Preu = "+actDia1.getPreu()+" euros Ciutat = "+actDia1.getCiutat());

        // toString
        System.out.println(actDia1.toString());
        System.out.println(actDia2.toString());
    }

}
