package UsuarisPackage;

/**
 * CLASSE FILLA USUARIS = PDI (Profesorat)
 * Conté l'informcio especifica dels usuaris tipus profesorat
 * Informació:
 *      @nomDept = nom del departamet on treballa el usuari
 *      @campus = Campus on treballa el usuari
 */
public class PDI extends Usuaris{
    private String nomDept;
    private String campus;


    //Constructor
    public PDI(String alies, String correu, String nomDept, String campus) {
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
        return getCorreu()+"@urv.cat";
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    /*Programadora: Judit Carles Pallares */
    public String toString(){
        return ("\n   Nom: "+this.getAlies()+"\n   Correu: "+this.getCorreuComplet()+"\n   Nom Departament: "+this.getNomDept()+"\n   Campus: "+this.getCampus()+"\n");
    }

    /*Programadora: Judit Carles Pallares */
    public PDI copia(){
        PDI pdi = new PDI(this.getAlies(), this.getCorreu(), this.getNomDept(), this.getCampus());
        return pdi;
    }

}
