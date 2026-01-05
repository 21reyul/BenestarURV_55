package Exception;
public class ForaDeRang extends Exception {
    public ForaDeRang (int valor, int minim, int maxim){
        super("La valoracio"+valor+"esta fora del rang permes ("+minim +","+maxim+")");

    }

}
