package UsuarisPackage;

import java.util.Objects;

/**
 * CLASSE PARE USUARIS
 * Conte l'informació comu dels usuaris:
 *      @alies = Identificador
 *      @correu = adreça electronica
 */
public abstract class Usuari{
    protected String alies;
    private String correu;

    //Constructor
    public Usuari(String alies, String correu){
        this.alies = alies;
        this.correu = correu;
    }

    public String getAlies(){ return alies; }
    public String getCorreu(){ return correu; }

    public void setAlies(String alies){ this.alies = alies; }
    public void setCorreu(String correu){ this.correu = correu; }

    // IMPORTANT: comparar usuaris per alies (o DNI si ho uses així)
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Usuari)) return false;
        Usuari other = (Usuari) o;
        return Objects.equals(this.alies, other.alies);
    }

    @Override
    public int hashCode(){
        return Objects.hash(alies);
    }
}


    
    
    


