package UsuarisPackage;


/**
 * CLASSE FILLA USUARIS = PTGAS (Personal Tècnic i de Gestió)
 * Conté l'informcio especifica dels usuaris tipus peronal tecnic i de gestió
 * Informació:
 *      @campus = Campus on treballa el usuari
 */
public class PTGAS extends Usuaris{
    private String campus;

    //Constructor
    public PTGAS(String alies, String correu, String campus) {
        super(alies, correu);
        this.campus=campus;
    }

    //getters i setters
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
        return ("\n   Nom: "+this.getAlies()+"\n   Correu: "+this.getCorreuComplet()+"\n   Campus: "+this.getCampus()+"\n");
    }
    
    /*Programadora: Judit Carles Pallares */
    public PTGAS copia(){
        PTGAS ptgas = new PTGAS(this.getAlies(), this.getCorreu(), this.getCampus());
        return ptgas;
    }

}
