package Implementacion;
import Entidades.Materias;
import tdas.ConjuntoMateriasTDA;

public class ConjuntoEstaticoMateriasTDA implements ConjuntoMateriasTDA {

    //Este conjuntoTDA nos permite guardar elementos de objetos Materias

    private Materias[] elementos;
    private int cantidad;

    //Tienen un costo temporal de O(1) porque solo hay asignacion de variables
    @Override
    public void InicializarConjunto() {
        elementos = new Materias[100];
        cantidad = 0;
    }

    //Tiene un costo temporal de O(n) ya que utilizamos el metodo pertence que itera un cantidad de n veces
    @Override
    public void Agregar(Materias valor) {
        if(!Pertenece(valor)){
            elementos[cantidad] = valor;
            cantidad++;
        }
    }

    //Tiene un costo temporal de O(n) debido a que se debe recorrer el bucle una cantidad de n veces
    @Override
    public void Sacar(Materias valor) {
        boolean encontrado = false;
        for(int i=0;i<cantidad && !encontrado;i++){
            if(elementos[i].getCodigo().equalsIgnoreCase(valor.getCodigo()) && elementos[i].getMateria().equalsIgnoreCase(valor.getMateria())){
                elementos[i] = elementos[cantidad-1];
                cantidad--;
                encontrado = true;

            }
        }
    }

    //Tiene un costo temporal de O(1) ya que solo devolvemos el ultimo elemento sin recorrer nada
    @Override
    public Materias Elegir() {
        return elementos[cantidad-1];
    }

    //Tiene un costo temporal de O(n) ya que utilizamos un bucle que recorre una cantidad de n veces
    @Override
    public boolean Pertenece(Materias valor ) {
        boolean encontrado = false;
        for(int i=0;i<cantidad && !encontrado;i++){
            if(elementos[i].getCodigo().equalsIgnoreCase(valor.getCodigo()) && elementos[i].getMateria().equalsIgnoreCase(valor.getMateria())){
                encontrado = true;
            }
        }
        return encontrado;
    }

    //Tiene un costo temporal de O(1) ya que solo verifica si el conjunto esta vacio verificando si cantidad es igual a 0
    @Override
    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }
}
