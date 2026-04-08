package Implementacion;

import tdas.ConjuntoTDA;

public class ConjuntoEstaticoTDA implements ConjuntoTDA {

    private int[] elementos;
    private int cantidad;
    @Override
    public void inicializar() {
        elementos = new int[100];
        cantidad = 0;
    }

    @Override
    public void agregar(int valor) {
        if(!pertenece(valor)){
            elementos[cantidad] = valor;
            cantidad++;
        }
    }

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

    @Override
    public int elegir() {
        return elementos[cantidad-1];
    }

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

    @Override
    public boolean estaVacio() {
        return cantidad == 0;
    }
}
