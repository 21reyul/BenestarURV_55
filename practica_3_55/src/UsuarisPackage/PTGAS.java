package UsuarisPackage;


/**
 * CLASSE FILLA USUARIS = PTGAS (Personal Tècnic i de Gestió)
 * Conté l'informcio especifica dels usuaris tipus peronal tecnic i de gestió
 * Informació:
 *      @campus = Campus on treballa el usuari
 */
public class Ptgas extends Usuari{
    private String campus;

    //Constructor
    public Ptgas(String alies, String correu, String campus) {
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
    public Ptgas copia(){
        Ptgas ptgas = new Ptgas(this.getAlies(), this.getCorreu(), this.getCampus());
        return ptgas;
    }

    public void setAlies(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAlies'");
    }

    public void setCorreu(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCorreu'");
    }

    public String getAlies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlies'");
    }

}
