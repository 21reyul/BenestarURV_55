public class LlistaUsuaris {
    private Usuaris[] llistaUsuaris;
    private int nUsuaris;

    public LlistaUsuaris(int mida){
        nUsuaris=0;
        llistaUsuaris = new Usuaris[mida];

    }

    //getter i setter
    public int getnUsuaris() {
        return nUsuaris;
    }

    public void setnUsuaris(int nUsuaris) {
        this.nUsuaris = nUsuaris;
    }
    
    public Usuaris[] getLlistaUsuaris() {
        return llistaUsuaris;
    }

    public void setLlistaUsuaris(Usuaris[] llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }
}
