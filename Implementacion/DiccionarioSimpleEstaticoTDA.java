
package Implementacion;

import Entidades.Alumnos;

public class DiccionarioSimpleEstaticoTDA implements tdas.DiccionarioSimpleTDA {

    class nodo{
        int clave;
        Alumnos valor;
    }

    private nodo[] valores = new nodo[100];
    private int cantidad;

    @Override
    public void InicializarDiccionario() {
        valores = new nodo[100];
        cantidad = 0;

    }

    @Override
    public void Agregar(int clave, Alumnos valor) {
        int pos = clave2Pos(clave);
        if(pos==-1) {
            nodo aux = new nodo();
            aux.clave = clave;
            aux.valor = valor;
            valores[cantidad] = aux;
            cantidad++;
        }
        else {
            valores[pos].valor = valor;
        }

    }

    @Override
    public void Eliminar(int clave) {
        int pos = clave2Pos(clave);
        if(pos!= -1) {
            valores[pos] = valores[cantidad - 1];
            cantidad--;
        }

    }

    @Override
    public Alumnos Recuperar(int clave) {
        int pos = clave2Pos(clave);
        if(pos != -1) {
            return valores[pos].valor;
        }
        return null;
    }

    @Override
    public ConjuntoEstaticoTDA ObtenerClaves() {
        ConjuntoEstaticoTDA resultado = new ConjuntoEstaticoTDA();
        resultado.inicializar();
        for(int i=0; i<cantidad; i++)
            resultado.agregar(valores[i].clave);
        return resultado;
    }

    private int clave2Pos(int clave) {
        int resultado = -1;
        boolean encontrar = false;
        for(int i=0; i<cantidad && !encontrar; i++)
            if(valores[i].clave == clave) {
                resultado = i;
                encontrar = true;
            }
        return resultado;
    }

}
