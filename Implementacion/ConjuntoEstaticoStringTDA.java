package Implementacion;
import Entidades.Materias;
import tdas.ConjuntoStringTDA;

public class ConjuntoEstaticoStringTDA implements ConjuntoStringTDA {
    private Materias[] elementos;
    private int cantidad;
    @Override
    public void inicializar() {
        elementos = new Materias[100];
        cantidad = 0;
    }

    @Override
    public void agregar(Materias valor) {
        if(!pertenece(valor)){
            elementos[cantidad] = valor;
            cantidad++;
        }
    }

    @Override
    public void sacar(Materias valor) {
        boolean encontrado = false;
        for(int i=0;i<cantidad && !encontrado;i++){
            if(elementos[i].getCodigo().equalsIgnoreCase(valor.getCodigo()) && elementos[i].getMateria().equalsIgnoreCase(valor.getMateria())){
                elementos[i] = elementos[cantidad-1];
                cantidad--;
                encontrado = true;

            }
        }
    }

    @Override
    public Materias elegir() {
        return elementos[cantidad-1];
    }

    @Override
    public boolean pertenece(Materias valor ) {
        boolean encontrado = false;
        for(int i=0;i<cantidad && !encontrado;i++){
            if(elementos[i].getCodigo().equalsIgnoreCase(valor.getCodigo()) && elementos[i].getMateria().equalsIgnoreCase(valor.getMateria())){
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
