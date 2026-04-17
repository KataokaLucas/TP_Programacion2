package tdas;

import Entidades.Materias;

public interface ConjuntoMateriasTDA {

    public void InicializarConjunto();


    public void Agregar(Materias valor);

    public void Sacar(Materias valor);

    public Materias Elegir();

    public boolean Pertenece(Materias valor);

    public boolean ConjuntoVacio();

}
