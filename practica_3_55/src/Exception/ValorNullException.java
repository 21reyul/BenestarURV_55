package Exception;

public class ValorNullException extends Exception {
    public ValorNullException(ValorNullException e) {
        System.out.println("ERROR DE SISTEMA: S'ha intentat accedir a una dada que no existeix.");
    }
}
