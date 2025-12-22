package UsuarisPackage;
/**
 * CLASSE LLISTAUSUARIS
 * Conte una llista de dades Usuaris
 * Informació:
 *      @llistaUsuaris = llista d'els usuaris
 *      @nUsuaris = nº d'usuaris apuntats a la llista
 */
public class LlistaUsuaris {
    private Usuari[] llistaUsuaris;
    private int nUsuaris;

    //Constructor
    public LlistaUsuaris(int mida){
        nUsuaris=0;
        llistaUsuaris = new Usuari[mida];

    }

    /**
     * Afegir un usuari de la llista
     * @param a, usuari que volem afegir a la llista
     */
    public void afegir(Usuari a){
        llistaUsuaris[nUsuaris]=a;
        nUsuaris++;
    }

    /**
     * Elimina usuari de la llista
     * @param a, usuari que voldrem eliminar
     */
    public void elimina(Usuari a){
        for(int i=0; i<nUsuaris; i++){
            if(llistaUsuaris[i].equals(a)){
                for(int j=i; j<nUsuaris-1; i--){//la meitat superior de la taula que queda, la movem una posicio cap endavant
                    llistaUsuaris[j]=llistaUsuaris[j+1];
                }
                llistaUsuaris[i-1]=null;
                nUsuaris--;
            }
        }
    }

    //getter i setter
    public int getnUsuaris() {
        return nUsuaris;
    }

    public void setnUsuaris(int nUsuaris) {
        this.nUsuaris = nUsuaris;
    }
    public Usuari getUsuarisPos(int i){
        return llistaUsuaris[i];
    }
    public String getUsuarisAliesPos(int i){
        return llistaUsuaris[i].getAlies();
    }


    //retorna un usuari de la llista segons el seu nom
    public Usuari getUsuariPerAlies(String alies){
        Usuari u=null;
        for(int i=0; i<nUsuaris; i++){
            if(llistaUsuaris[i].getAlies().equals(alies)){
                u=llistaUsuaris[i];
            }
        }
        return u;
    }

    public String getLlistaUsuaris() {
        return this.toString();
    }

    public void setLlistaUsuaris(Usuari[] llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }

    public Usuari copia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copia'");
    }

    //toString de la llista d'usuaris
    @Override
    public String toString() {
        String resultat = "LLISTA D'USUARIS:\n";
        for (int i = 0; i < nUsuaris; i++) {
            Usuari u = llistaUsuaris[i];
            resultat = resultat + (i + 1) + ". " + u.getAlies() 
                        + " | Correu: " + u.getCorreu() + "\n";
        }
        if (nUsuaris == 0) resultat = resultat + "No hi ha usuaris.\n";
        return resultat;
    }
}
