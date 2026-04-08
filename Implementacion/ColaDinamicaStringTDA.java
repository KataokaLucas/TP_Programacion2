package Implementacion;

import tdas.ColaTDA;

public class ColaDinamicaStringTDA implements ColaTDA {

    class nodo{
        String valor;
        nodo siguiente;
    }

    nodo primero;
    nodo ultimo;

    @Override
    public void inicializar() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void acolar(String valor) {
        nodo aux = new nodo();
        aux.valor = valor;
        if(primero == null){
            primero = aux;
            ultimo = aux;
            aux.siguiente = null;
        }
        else {
            ultimo.siguiente = aux;
            ultimo = aux;
        }
    }

    @Override
    public void desacolar() {
        primero = primero.siguiente;
        if(primero == null)
            ultimo = null;
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public String primero() {
        return primero.valor;
    }
}
