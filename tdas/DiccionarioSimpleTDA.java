package tdas;

import Entidades.Alumnos;
import Implementacion.ConjuntoEstaticoTDA;

public interface DiccionarioSimpleTDA {

    public void InicializarDiccionario();

    public void Agregar(int clave, Alumnos valor);

    public void Eliminar(int clave);

    public Alumnos Recuperar(int clave);

    public ConjuntoEstaticoTDA ObtenerClaves();



}
