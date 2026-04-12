package tdas;

public interface ConjuntoTDA {

    public void inicializar();

    public void agregar(int valor);

    public void sacar(int valor);

    public int elegir();

    public boolean pertenece(int valor);

    public boolean estaVacio();
}
