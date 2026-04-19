
package Implementacion;

import Entidades.Alumnos;

public class DiccionarioSimpleEstaticoTDA implements tdas.DiccionarioSimpleTDA {

    //Nodo que guarda la clave(dni) y el valor(Objeto Alumnos)
    class nodo{
        int clave;
        Alumnos valor;
    }

    //Estructara del diccionario a traves del array de nodos;[nodo0,nodo1,nodo2,...]
    private nodo[] valores;
    private int cantidad;


    //Tiene un costo temporal de O(1) ya que solo hay asignacion de variables y esta cantidad no cambia
    @Override
    public void InicializarDiccionario() {
        valores = new nodo[100];
        cantidad = 0;

    }


    //Tiene un costo temporal de O(n) ya se llama al metodo clave2Pos que tiene un bucle que se recorre n veces
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

    //Tiene un costo temporal de O(n) ya se llama al metodo clave2Pos que tiene un bucle que se recorre n veces
    @Override
    public void Eliminar(int clave) {
        int pos = clave2Pos(clave);
        if(pos!= -1) {
            valores[pos] = valores[cantidad - 1];
            cantidad--;
        }

    }

    //Tiene un costo temporal de O(n) ya se llama al metodo clave2Pos que tiene un bucle que se recorre n veces
    @Override
    public Alumnos Recuperar(int clave) {
        int pos = clave2Pos(clave);
        if(pos != -1) {
            return valores[pos].valor;
        }
        return null;
    }

    //Tiene un costo temporal de O(n) debido a que se recorre un bucle n veces que es la cantidad de elementos del array
    @Override
    public ConjuntoEstaticoTDA ObtenerClaves() {
        ConjuntoEstaticoTDA resultado = new ConjuntoEstaticoTDA();
        resultado.inicializar();
        for(int i=0; i<cantidad; i++)
            resultado.agregar(valores[i].clave);
        return resultado;
    }

    //Tiene un costo temporal de O(n) debido a que se recorre un bucle n veces que es la cantidad de elementos del array
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
