import UsuarisPackage.Usuaris;

/**
 * CLASSE LLISTAUSUARIS
 * Conte una llista de dades Usuaris
 * Informació:
 *      @llistaUsuaris = llista d'els usuaris
 *      @nUsuaris = nº d'usuaris apuntats a la llista
 */
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
    
    public String getLlistaUsuaris() {
        return this.toString();
    }

    public void setLlistaUsuaris(Usuaris[] llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }
}
