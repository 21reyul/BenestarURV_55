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

    public void setAnyIni(int anyIni) {
        this.anyIni = anyIni;
    }


}
