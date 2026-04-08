package Entidades;

import tdas.ConjuntoStringTDA;
import tdas.ConjuntoTDA;

public class Alumnos {
    private String nombre;
    private ConjuntoStringTDA materiasInscriptas;

    public Alumnos(){

    }

    public Alumnos(String nombre,ConjuntoStringTDA materias){
        this.nombre = nombre;
        this.materiasInscriptas = materias;
    }

    public String getNombre(){
        return nombre;
    }

    public ConjuntoStringTDA getMateriasInscriptas(){
        return materiasInscriptas;
    }


}
