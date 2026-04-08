package tdas;

import Entidades.Materias;

public interface ConjuntoStringTDA {

    public void inicializar();


    public void agregar(Materias valor);

    public void sacar(Materias valor);

    public Materias elegir();

    public boolean pertenece(Materias valor);

    public boolean estaVacio();

}
