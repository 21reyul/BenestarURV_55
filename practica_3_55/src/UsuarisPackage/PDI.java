package UsuarisPackage;

/**
 * CLASSE FILLA USUARIS = PDI (Profesorat)
 * Conté l'informcio especifica dels usuaris tipus profesorat
 * Informació:
 *      @nomDept = nom del departamet on treballa el usuari
 *      @campus = Campus on treballa el usuari
 */
public class Pdi extends Usuari{
    private String nomDept;
    private String campus;


    //Constructor
    public Pdi(String alies, String correu, String nomDept, String campus) {
        super(alies, correu);
        this.nomDept=nomDept;
        this.campus=campus;
    }
    
    //getters i setters
    public String getNomDept() {
        return nomDept;
    }

    public void setNomDept(String nomDept) {
        this.nomDept = nomDept;
    }

    public String getCampus() {
        return campus;
    }

    /*Programadora: Judit Carles Pallares */
    public String getCorreuComplet(){
        return getCorreuComplet()+"@urv.cat";
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    /*Programadora: Judit Carles Pallares */
    public String toString(){
        return ("\n   Nom: "+this.getAlies()+"\n   Correu: "+this.getCorreuComplet()+"\n   Nom Departament: "+this.getNomDept()+"\n   Campus: "+this.getCampus()+"\n");
    }

    /*Programadora: Judit Carles Pallares */
    public Pdi copia(){
        Pdi pdi = new Pdi(this.getAlies(), this.getCorreuComplet(), this.getNomDept(), this.getCampus());
        return pdi;
    }

}
