package tdas;

import Entidades.Alumnos;
import Implementacion.ConjuntoEstaticoTDA;

public interface DiccionarioSimpleTDA {

    public void inicializar();

    public void agregar(int clave, Alumnos valor);

    public void eliminar(int clave);

    public Alumnos recuperar(int clave);

    public ConjuntoEstaticoTDA obtenerClaves();



}
