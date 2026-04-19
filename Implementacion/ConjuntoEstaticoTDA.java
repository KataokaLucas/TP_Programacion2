package Implementacion;

import tdas.ConjuntoTDA;

public class ConjuntoEstaticoTDA implements ConjuntoTDA {

    private int[] elementos;
    private int cantidad;

    //Tienen un costo temporal de O(1) porque solo hay asignacion de variables
    @Override
    public void inicializar() {
        elementos = new int[100];
        cantidad = 0;
    }

    //Tiene un costo temporal de O(n) ya que utilizamos el metodo pertence que itera un cantidad de n veces
    @Override
    public void agregar(int valor) {
        if(!pertenece(valor)){
            elementos[cantidad] = valor;
            cantidad++;
        }
    }

    //Tiene un costo temporal de O(n) debido a que se debe recorrer el bucle una cantidad de n veces
    @Override
    public void sacar(int valor) {
        boolean encontrado = false;
        for(int i=0;i<cantidad && !encontrado;i++){
            if(elementos[i]==valor){
                elementos[i] = elementos[cantidad-1];
                cantidad--;
                encontrado = true;

            }
        }
    }

    //Tiene un costo temporal de O(1) ya que solo devolvemos el ultimo elemento sin recorrer nada
    @Override
    public int elegir() {
        return elementos[cantidad-1];
    }

    //Tiene un costo temporal de O(n) ya que utilizamos un bucle que recorre una cantidad de n veces
    @Override
    public boolean pertenece(int valor) {
        boolean encontrado = false;
        for(int i=0;i<cantidad && !encontrado;i++){
            if(elementos[i] == valor){
                encontrado = true;
            }
        }
        return encontrado;
    }

    //Tiene un costo temporal de O(1) ya que solo verifica si el conjunto esta vacio verificando si cantidad es igual a 0
    @Override
    public boolean estaVacio() {
        return cantidad == 0;
    }
}
