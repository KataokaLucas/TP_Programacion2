package Implementacion;

import tdas.ColaTDA;

public class ColaDinamicaStringTDA implements ColaTDA {

    //Forma del nodo
    class Nodo{
        String valor;
        Nodo siguiente;
    }

    //Nodo primero y ultimo para utilizarlos de refencias
    Nodo primero;
    Nodo ultimo;

    //El costo temporal es O(1),ya que solo asigna null a dos variables, por ende es una operación inmediata.
    @Override
    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    //El costo temporal es O(1) ya que ultimo se referencia al ultimo nodo ingresado,no es necesario recorrer la cola desde el principio para encontrar el final.
    @Override
    public void Acolar(String valor) {
        //Declaramos un nodo auxiliar
        Nodo aux = new Nodo();
        aux.valor = valor;
        //Si ultimo no es null es porque la cola no esta vacia
        if(ultimo != null){
            //Referenciamos el ultimo nodo al nodo aux que entro
            ultimo.siguiente = aux;;
        }
        //Referenciamos ultimo al nodo aux que entro
        ultimo = aux;
        //Esta condicion ocurre si la cola esta vacia
        if(primero==null){
            //Hacemos que primero referencie a lo mismo que apunta ultimo
            primero = ultimo;
        }
    }

    //El costo temporal es O(1) ya que primero siempre que se desacole,apunta al siguiente nodo
    @Override
    public void Desacolar() {
        //Hacemos que el nodo primero tenga la informacion del siguiente nodo que apunta
        primero = primero.siguiente;
        //Si esta vacio quiere decir que no hay ningun elemento al final, por ende ultimo es null
        if(primero == null)
            ultimo = null;
    }

    //El costo temporal es O(1) ya que se compara solo si el nodo primero es null
    @Override
    public boolean ColaVacia() {
        //Si no hay ningun elemento en la lista primero es null
        return primero == null;
    }

    //El costo temporal es O(1) ya que solo devuelve el valor del primer nodo
    @Override
    public String Primero() {
        //Devuelve el valor del primero nodo
        return primero.valor;
    }
}
