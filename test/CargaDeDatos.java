package test;

import Entidades.Alumnos;
import Entidades.Materias;
import Implementacion.ConjuntoEstaticoMateriasTDA;
import tdas.ColaTDA;
import tdas.ConjuntoMateriasTDA;
import tdas.DiccionarioSimpleTDA;

public class CargaDeDatos {

    //Cargamos datos de prueba para testear el sistema
    //Tiene un costo temporal de O(1) ya que no depende de una cantidad n que haga crecer esta carga de datos
    public static void cargarDatos(ConjuntoMateriasTDA c1, ColaTDA cd1, DiccionarioSimpleTDA d1) {
        //Carga de materias
        Materias m1 = new Materias("1001","Calculo I");
        Materias m2 = new Materias("1002","Algebra");
        Materias m3 = new Materias("1003","Fisica I");
        Materias m4 = new Materias("1004","Programacion II");
        Materias m5 = new Materias("1005","Ingeniera de Datos I");
        Materias m6 = new Materias("1006", "Ingeniera de Datos I");
        Materias m7 = new Materias("3003", "Ingeniera de Datos II");
        Materias m8 = new Materias("1001","Teleinformatica y Redes");
        Materias m9 = new Materias("2003", "Teleinformatica y Redes");
        Materias m10 = new Materias("1004","Programacion Orientado a Objetos");
        Materias m11= new Materias("1005","Estadistica Avanzada");
        Materias m12= new Materias("2001", "Sistemas Operativos");
        Materias m13 = new Materias("2002", "Arquitectura de Computadores");
        Materias m14 = new Materias("3001", "Estructuras de Datos y Algoritmos I");

        c1.Agregar(m1);
        c1.Agregar(m2);
        c1.Agregar(m3);
        c1.Agregar(m4);
        c1.Agregar(m5);
        c1.Agregar(m6);
        c1.Agregar(m7);
        c1.Agregar(m8);
        c1.Agregar(m9);
        c1.Agregar(m10);
        c1.Agregar(m11);
        c1.Agregar(m12);
        c1.Agregar(m13);
        c1.Agregar(m14);

        //Creacion de Conjunto de Alumnos
        ConjuntoMateriasTDA c2 = new ConjuntoEstaticoMateriasTDA();
        ConjuntoMateriasTDA c3 = new ConjuntoEstaticoMateriasTDA();
        ConjuntoMateriasTDA c4 = new ConjuntoEstaticoMateriasTDA();
        ConjuntoMateriasTDA c5 = new ConjuntoEstaticoMateriasTDA();
        ConjuntoMateriasTDA c6 = new ConjuntoEstaticoMateriasTDA();
        ConjuntoMateriasTDA c7 = new ConjuntoEstaticoMateriasTDA();

        // Inicialización de los conjuntos
        c2.InicializarConjunto();
        c3.InicializarConjunto();
        c4.InicializarConjunto();
        c5.InicializarConjunto();
        c6.InicializarConjunto();
        c7.InicializarConjunto();

        //Agregando materias a algunos conjuntos de materias de alumnos
        c3.Agregar(m2);
        c3.Agregar(m1);
        c3.Agregar(m4);
        c4.Agregar(m2);
        c4.Agregar(m1);
        c5.Agregar(m3);
        c6.Agregar(m1);
        c6.Agregar(m5);


        // Creación de nuevos objetos Alumnos
        Alumnos a1 = new Alumnos("Lucas Kataoka",c2);
        Alumnos a2 = new Alumnos("Franco De Vincenzo",c3);
        Alumnos a3 = new Alumnos("Micaela Garcia", c4);
        Alumnos a4 = new Alumnos("Julian Alvarez", c5);
        Alumnos a5 = new Alumnos("Sofia Martinez", c6);
        Alumnos a6 = new Alumnos("Diego Perez", c7);

        // Agregando al diccionario d1 (DNI, Objeto Alumno)
        d1.Agregar(45223112, a3);
        d1.Agregar(43900124, a4);
        d1.Agregar(46123456, a5);
        d1.Agregar(42888999, a6);
        d1.Agregar(47130033,a1);
        d1.Agregar(47120044,a2);









    }

}
