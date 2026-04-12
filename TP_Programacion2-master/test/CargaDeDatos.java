package test;

import Entidades.Alumnos;
import Entidades.Materias;
import Implementacion.ConjuntoEstaticoStringTDA;
import tdas.ColaTDA;
import tdas.ConjuntoStringTDA;
import tdas.DiccionarioSimpleTDA;

public class CargaDeDatos {

    public static void cargarDatos(ConjuntoStringTDA c1, ColaTDA cd1,DiccionarioSimpleTDA d1) {
        Materias m1 = new Materias("1001","Calculo I");
        Materias m2 = new Materias("1002","Algebra");
        Materias m3 = new Materias("1003","Fisica I");
        Materias m4 = new Materias("1004","Programacion II");
        Materias m5 = new Materias("1005","Ingeniera de Datos I");
        c1.agregar(m1);
        c1.agregar(m2);
        c1.agregar(m3);
        c1.agregar(m4);
        c1.agregar(m5);
        ConjuntoStringTDA c3 = new ConjuntoEstaticoStringTDA();
        c3.inicializar();
        //ConjuntoStringTDA c2 = new ConjuntoEstaticoStringTDA();
        //c2.inicializar();a
        Alumnos a1 = new Alumnos("Lucas Kataoka", c3);
       //Alumnos a2 = new Alumnos("Franco De Vincenzo","46955902",c2);
        d1.agregar(47130033,a1);
       // d1.agregar(1189064,a2);
        //c3.agregar(m2);
        Materias m6 = new Materias("1001","Teleinformatica y Redes");
        Materias m7 = new Materias("1004","Programacion Orientado a Objetos");
        Materias m8 = new Materias("1005","Estadistica Avanzada");
        c1.agregar(m6);
        c1.agregar(m7);
        c1.agregar(m8);







    }

}
