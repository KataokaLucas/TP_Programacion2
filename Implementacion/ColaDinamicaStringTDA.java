package Implementacion;

import tdas.ColaTDA;

public class ColaDinamicaStringTDA implements ColaTDA {

    class Nodo{
        String valor;
        Nodo siguiente;
    }

    Nodo primero;
    Nodo ultimo;

    @Override
    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void Acolar(String valor) {
        Nodo aux = new Nodo();
        aux.valor = valor;
        if(ultimo != null){
            ultimo.siguiente = aux;;
        }
        ultimo = aux;
        if(primero==null){
            primero = ultimo;
        }
    }

    @Override
    public void Desacolar() {
        primero = primero.siguiente;
        if(primero == null)
            ultimo = null;
    }

    @Override
    public boolean ColaVacia() {
        return primero == null;
    }

    @Override
    public String Primero() {
        return primero.valor;
    }
}
