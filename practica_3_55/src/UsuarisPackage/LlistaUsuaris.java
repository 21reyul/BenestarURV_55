package UsuarisPackage;
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

    public void Afegir(Usuaris a ){
        llistaUsuaris[nUsuaris]=a;
        nUsuaris++;
    }

    public void Elimina(Usuaris u){
        int pos = -1;
        for (int i = 0; i < nUsuaris; i++){
            if (llistaUsuaris[i].equals(u)) { pos = i; break; }
        }
        if (pos == -1) return;

        for (int j = pos; j < nUsuaris - 1; j++){
            llistaUsuaris[j] = llistaUsuaris[j + 1];
        }
        llistaUsuaris[nUsuaris - 1] = null;
        nUsuaris--;
    }

    public boolean BuscarUsuari(Usuaris u){
        for (int i = 0; i < nUsuaris; i++){
            if (llistaUsuaris[i].equals(u)) return true;
        }
        return false;
    }
    //getter i setter
    public int getnUsuaris() {
        return nUsuaris;
    }

    public void setnUsuaris(int nUsuaris) {
        this.nUsuaris = nUsuaris;
    }
    public Usuaris getUsuarisPos(int i){
        return llistaUsuaris[i];
    }
    public String getUsuarisAliesPos(int i){
        return llistaUsuaris[i].getAlies();
    }
    
    public String getLlistaUsuaris() {
        return this.toString();
    }

    public void setLlistaUsuaris(Usuaris[] llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }
}
