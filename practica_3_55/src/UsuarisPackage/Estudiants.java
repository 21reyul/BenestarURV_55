package UsuarisPackage;

/**
 * CLASSE FILLA USUARIS = Estudiants
 * Conté l'informcio especifica dels usuaris tipus estudiants
 * Informació:
 *      @ensenyament = grau en el que estan matriculats
 *      @anyIni = any en que l'usuari inicia els estudis
 */
public class Estudiants extends Usuaris{
    private String ensenyament;
    private int anyIni;

    //Constructor
    public Estudiants(String alies, String correu, String ensenyament, int anyIni) {
        super(alies, correu);
        this.ensenyament=ensenyament;
        this.anyIni=anyIni;
    }

    //Getters i setters
    public String getEnsenyament() {
        return ensenyament;
    }

    public void setEnsenyament(String ensenyament) {
        this.ensenyament = ensenyament;
    }

    public int getAnyIni() {
        return anyIni;
    }

    /*Programadora: Judit Carles Pallares */
    public String getCorreuComplet(){
        return getCorreu()+"@estudiants.urv.cat";
    }

    public void setAnyIni(int anyIni) {
        this.anyIni = anyIni;
    }

    /*Programadora: Judit Carles Pallares */
    public String toString(){
        return ("\n   Nom: "+this.getAlies()+"\n   Correu: "+this.getCorreuComplet()+"\n   Ensenyament: "+this.getEnsenyament()+"\n   Any Inici: "+this.getAnyIni()+"\n");
    }

    /*Programadora: Judit Carles Pallares */
    public Estudiants copia(){
        Estudiants est= new Estudiants(this.getAlies(), this.getCorreu(), this.getEnsenyament(), this.getAnyIni());
        return est;
    }
}
