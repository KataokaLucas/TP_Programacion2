package Implementacion;

import tdas.PilaTDA;

public class PilaEstaticaTDA implements PilaTDA {

    private String elementos[];
    private int indice;

    @Override
    public void inicializar() {
        elementos = new String[100];
        indice = 0;


    }

    @Override
    public void apilar(String valor) {
        elementos[indice] = valor;
        indice++;
    }

    @Override
    public void desapilar() {
        indice--;

    }

    @Override
    public boolean estaVacia() {
        return indice == 0;
    }

    @Override
    public String tope() {
        return elementos[indice-1];
    }
}
