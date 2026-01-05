package UsuarisPackage;

import ActivitatsPackage.Inscripcions;

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
                for(int j=i; j<nUsuaris-1; j++){//la meitat superior de la taula que queda, la movem una posicio cap endavant
                    llistaUsuaris[j]=llistaUsuaris[j+1];
                }
                llistaUsuaris[nUsuaris-1]=null;
                nUsuaris--;
            }
        }
    }

    public boolean BuscarUsuari(Usuari u){
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

    /**
     * Mètode que et dona la valoració d'un usuari que es troba dins d'una inscripció
     * Programadora: Aina Garcia Albesa
     * @param usuari
     * @param inscripcio
     * @return
     */
    public Integer getValoracioUsuari(Usuari usuari, Inscripcions inscripcio) {
        Integer resultat = null;
        
        if (usuari != null && inscripcio != null && llistaUsuaris != null) {
            int i = 0;
            boolean trobat = false;
            
            // Buscar si l'usuari està a la llista
            while (i < nUsuaris && !trobat) {
                Usuari u = llistaUsuaris[i];
                if (u != null && u.getAlies().equals(usuari.getAlies())) {
                    trobat = true;
                }
                i++;
            }
            
            // Si l'usuari està a la llista, obtenir la valoració de la inscripció
            if (trobat) {
                resultat = inscripcio.getValoracioUsuari(usuari);
            }
        }
        return resultat; 
    }

    /**
     * Mètode que busca a travès de l'àlies si un usuari existeix
     * Programadora: Aina Garcia Albesa
     * @param alies
     * @return
     */
    public Usuari buscarUsuariPerAlies(String alies) {
    Usuari trobat = null;
    int i = 0;
    while (i < nUsuaris && trobat == null) {
        if (llistaUsuaris[i].getAlies().equalsIgnoreCase(alies)) {
            trobat = llistaUsuaris[i];
        }
        i++;
    }
        return trobat;
    }

    public String usuariMesInscrit(){
        String nom=llistaUsuaris[0].getAlies();
        int numero=llistaUsuaris[0].getContador();
        for (int i=0; i<nUsuaris; i++){
            if (numero<llistaUsuaris[i].getContador()){
                nom=llistaUsuaris[i].getAlies();
                numero=llistaUsuaris[i].getContador();
            }
        }
        return nom;
    }
 
     public int numeroMaximUsuariMesInscrit(){
        int numero=llistaUsuaris[0].getContador();
        for (int i=0; i<nUsuaris; i++){
            if (numero<llistaUsuaris[i].getContador()){
                numero=llistaUsuaris[i].getContador();
            }
        }
        return numero;
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
