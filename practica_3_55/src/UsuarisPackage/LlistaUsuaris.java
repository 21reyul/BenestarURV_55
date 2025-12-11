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
    public void Afegir(Usuari a){
        llistaUsuaris[nUsuaris]=a;
        nUsuaris++;
    }

    /**
     * Elimina usuari de la llista
     * @param a, usuari que voldrem eliminar
     */
    public void Elimina(Usuari a){
        boolean trobat=false;
        int i=0;
        while(!trobat){
            if(llistaUsuaris[i]==a){
                trobat=true;
                for(int j=i; j<nUsuaris; j++){
                    llistaUsuaris[j]=llistaUsuaris[j+1];
                }
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
    
    public String getLlistaUsuaris() {
        return this.toString();
    }

    public void setLlistaUsuaris(Usuari[] llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }
}
