package Implementacion;
import Entidades.Materias;
import tdas.ConjuntoMateriasTDA;

public class ConjuntoEstaticoMateriasTDA implements ConjuntoMateriasTDA {
    private Materias[] elementos;
    private int cantidad;
    @Override
    public void InicializarConjunto() {
        elementos = new Materias[100];
        cantidad = 0;
    }

    @Override
    public void Agregar(Materias valor) {
        if(!Pertenece(valor)){
            elementos[cantidad] = valor;
            cantidad++;
        }
    }

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

    @Override
    public Materias Elegir() {
        return elementos[cantidad-1];
    }

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

    @Override
    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }
}
