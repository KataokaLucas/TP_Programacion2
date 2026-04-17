package Entidades;

import tdas.ConjuntoMateriasTDA;

public class Alumnos {
    private String nombre;
    private ConjuntoMateriasTDA materiasInscriptas;

    public Alumnos(){

    }

    public Alumnos(String nombre, ConjuntoMateriasTDA materias){
        this.nombre = nombre;
        this.materiasInscriptas = materias;
    }

    public String getNombre(){
        return nombre;
    }

    public ConjuntoMateriasTDA getMateriasInscriptas(){
        return materiasInscriptas;
    }


}
