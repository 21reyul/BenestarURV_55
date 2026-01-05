package Validacio;
import UsuarisPackage.Usuari;
import UsuarisPackage.Estudiants;
import UsuarisPackage.LlistaUsuaris;
import UsuarisPackage.Pdi;
import UsuarisPackage.Ptgas;


/*Programadora: Cristina Cozma */
/*Programadora: Judit Carles Pallares */

/* VALIDACIO USUARIS */
public class ValidacioUsuaris {
    public static void main(String[] args) throws Exception {
        Estudiants est1 = new Estudiants("Cristina", "cc", "GEI", 2024);
        Estudiants est2 = new Estudiants("Judit", "jcp", "GEI", 2024);

        Pdi pdi1 = new Pdi("Neus", "n.budesca", "GEI", "SesceladeS");
        Pdi pdi2 = new Pdi("Maria", "m.ferre", "GEI", "SesceladeS");

        Ptgas ptgas1 = new Ptgas("Eustaquio", "eusta", "Catalunya");
        Ptgas ptgas2 = new Ptgas("Juana", "juani", "Bellissens");

        LlistaUsuaris llistaUsuaris = new LlistaUsuaris(10);

        //Comprobacions clase Estudiants
        System.out.println("COMPROBACIO CLASSE ESTUDIANTS:\n\n");
        System.out.println("Informacio estudiant 1 =>\n   Nom ="+ est1.getAlies() + "  Correu = " + est1.getCorreuComplet() + "  Ensenyament = " + est1.getEnsenyament() + " AnyInici = " + est1.getAnyIni()+"\n");
        System.out.println("Informacio estudiant 2 =>\n   Nom ="+ est2.getAlies() + "  Correu = " + est2.getCorreuComplet() + "  Ensenyament = " + est2.getEnsenyament() + " AnyInici = " + est2.getAnyIni()+"\n");
        est2.setAlies("Aroa"); 
        est2.setCorreu("ag"); 
        est2.setEnsenyament("BioGEI");
        est2.setAnyIni(2023);
        System.out.println("Informacio estudiant 2 després de la modificació=> \n   Nom ="+ est2.getAlies() + "  Correu = " + est2.getCorreuComplet() + "  Ensenyament = " + est2.getEnsenyament() + " AnyInici = " + est2.getAnyIni()+"\n");
        System.out.println("ToString => "+est1.toString());
        Estudiants est3=est1.copia();
        System.out.println("Copia de estudiant 1 a estudaint 3 => "+est3.toString());

        //Comprobacions clase PDI
        System.out.println("_______________________________________________________________________________________________________________________________\n");
        System.out.println("COMPROBACIO CLASSE PDI:\n");
        System.out.println("Informacio profesor 1 =>\n   Nom ="+ pdi1.getAlies() + "  Correu = " + pdi1.getCorreuComplet() + "  NomDepartament = " + pdi1.getNomDept() + " Campus = " + pdi1.getCampus()+"\n");
        System.out.println("Informacio profesor 2 =>\n   Nom ="+ pdi2.getAlies() + "  Correu = " + pdi2.getCorreuComplet() + "  NomDepartament = " + pdi2.getNomDept() + " Campus = " + pdi2.getCampus()+"\n");
        pdi2.setAlies("Santiago"); 
        pdi2.setCorreu("s.romani"); 
        pdi2.setNomDept("DEIM");
        pdi2.setCampus("Catalunya");
        System.out.println("Informacio profesor 2 =>\n   Nom ="+ pdi2.getAlies() + "  Correu = " + pdi2.getCorreuComplet() + "  NomDepartament = " + pdi2.getNomDept() + " Campus = " + pdi2.getCampus()+"\n");
        System.out.println("ToString => "+ pdi1.toString());
        Pdi pdi3=pdi1.copia();
        System.out.println("Copia de estudiant 1 a estudaint 3 => "+pdi3.toString());
        
        //Comprobacions clase PTGAS
        System.out.println("_______________________________________________________________________________________________________________________________\n");
        System.out.println("COMPROBACIO CLASSE PDGAS:\n");
        System.out.println("Informacio personal tècnic i de gestió 1:\n   Nom ="+ ptgas1.getAlies() + "  Correu = " + ptgas1.getCorreuComplet() +" Campus = " + ptgas1.getCampus()+"\n");
        System.out.println("Informacio personal tècnic i de gestió 2:\n   Nom ="+ ptgas2.getAlies() + "  Correu = " + ptgas2.getCorreuComplet() +" Campus = " + ptgas2.getCampus()+"\n");
        ptgas2.setAlies("Juanita"); 
        ptgas2.setCorreu("lajuanita"); 
        ptgas2.setCampus("Catalunya");
        System.out.println("Informacio personal tècnic i de gestió 2:\n   Nom ="+ ptgas2.getAlies() + "  Correu = " + ptgas2.getCorreuComplet() +" Campus = " + ptgas2.getCampus()+"\n");
        System.out.println("ToString => "+ ptgas1.toString());
        Ptgas ptgas3=ptgas1.copia();
        System.out.println("Copia de estudiant 1 a estudaint 3 => "+ptgas3.toString());
    }

}
