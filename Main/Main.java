package Main;


import Entidades.Alumnos;
import Entidades.Materias;
import Implementacion.ColaDinamicaStringTDA;
import Implementacion.ConjuntoEstaticoStringTDA;
import Implementacion.ConjuntoEstaticoTDA;
import Implementacion.DiccionarioSimpleEstaticoTDA;
import tdas.ColaTDA;
import tdas.ConjuntoStringTDA;
import tdas.DiccionarioSimpleTDA;
import test.CargaDeDatos;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    //Muestra las materias que hay en el conjunto
    public static void MostrarMaterias(ConjuntoStringTDA c1){
        ConjuntoStringTDA aux = new ConjuntoEstaticoStringTDA();
        aux.inicializar();
        while (!c1.estaVacio()) {
            Materias valor = c1.elegir();
            System.out.println(valor.getCodigo() + "|" + valor.getMateria());
            aux.agregar(valor);
            c1.sacar(valor);
        }
        // Restauramos los datos al conjunto original
        while (!aux.estaVacio()) {
            Materias valor = aux.elegir();
            c1.agregar(valor);
            aux.sacar(valor);
        }
    }


    public static Materias crearMateria(String codigo,String materia){
        Materias m;
        return m = new Materias(codigo,materia);
    }

    //Funcion de un string vacio para leer los mensajes(como si fuese una pausa) por terminal
    public static void Pausa(){
        System.out.println("Presione enter para continuar");
        teclado.nextLine();
    }

    //Funcion para agregar materias al ConjuntoTDA Estatico
    public static void AgregarMateria(ConjuntoStringTDA c1){

        String materia;
        String codigo;

        MostrarMaterias(c1);
        System.out.println();
        System.out.println("Ingrese el Codigo de la materia");
        codigo = teclado.nextLine();
        System.out.println("Nombre la materia que desea agregar:");
        materia = teclado.nextLine();
        Materias m = new Materias(codigo,materia);
        if(c1.pertenece(m)){
            System.out.println("La materia ya existe en el sistema");
            Pausa();
        }
        else{
            Materias resultado = crearMateria(codigo, materia);
            c1.agregar(resultado);
            System.out.println("La materia se agrego correctamente");
            Pausa();
        }
    }

    //Funcion para sacar materias al ConjuntoTDA Estatico
    public static void SacarMateria(ConjuntoStringTDA c1){
        String codigo;
        String materia;

        MostrarMaterias(c1);
        System.out.println();
        System.out.println("Ingrese el Codigo de la materia");
        codigo = teclado.nextLine();
        System.out.println("Nombre la materia que desea agregar:");
        materia = teclado.nextLine();
        Materias m = new Materias(codigo,materia);

        if(!c1.pertenece(m)){
            System.out.println("La materia no existe en el sistema");
            Pausa();
        }
        else{
            c1.sacar(m);
            System.out.println("La materia se elimino correctamente");
            Pausa();

        }
    }

    //Funcion para Inscribirse a una materia a traves del dni del alumno
    public static void InscribirseMateria(ConjuntoStringTDA c1,DiccionarioSimpleTDA d1,ColaTDA cd1){

        String codigo;
        String materia;
        int dni;

        MostrarMaterias(c1);
        System.out.println();
        System.out.println("Ingrese el Codigo de la materia");
        codigo = teclado.nextLine();
        System.out.println("Nombre la materia que desea agregar:");
        materia = teclado.nextLine();
        Materias m = new Materias(codigo,materia);


        if(!c1.pertenece(m)){
            System.out.println("La materia no existe en el sistema");
            Pausa();
        }
        else{
            System.out.println("Introduce su numero de dni");
            dni = teclado.nextInt();
            teclado.nextLine();
            Alumnos alumno = d1.recuperar(dni);
            if(alumno != null){
                String l = String.valueOf(dni);
                System.out.println(l);
                if(!alumno.getMateriasInscriptas().pertenece(m)){
                    cd1.acolar(l+"|"+codigo+"|"+materia);
                    System.out.println("El pedido de inscripcion se hizo correctamnete");
                    Pausa();
                }
                else{
                    System.out.println("El alumno ya esta inscripto a la materia");
                }
           }
            else{
                System.out.println("El alumno no existe");
            }
        }

    }
    public static void ProcesarInscripciones(ColaTDA cd1, DiccionarioSimpleTDA d1) {
        while (!cd1.estaVacia()) {
            String valor = cd1.primero();
            String[] partes = valor.split("\\|");
            int dni = Integer.parseInt(partes[0]);
            Materias m = new Materias(partes[1], partes[2]);

            Alumnos alumno = d1.recuperar(dni);
            if (alumno != null && !alumno.getMateriasInscriptas().pertenece(m)) {
                alumno.getMateriasInscriptas().agregar(m);
            }
            cd1.desacolar();
        }
    }

    //Funcion para Deinscribirse a una materia a traves del dni del alumno
    public static void DesinscribirseMateria(ConjuntoStringTDA c1,DiccionarioSimpleTDA d1,ColaTDA cd2){

        String codigo;
        String materia;
        int dni;


        System.out.println("Ingrese el Codigo de la materia");
        codigo = teclado.nextLine();
        System.out.println("Nombre la materia que desea agregar:");
        materia = teclado.nextLine();
        Materias m = new Materias(codigo,materia);


        if(!c1.pertenece(m)){
            System.out.println("La materia no existe en el sistema");
            Pausa();
        }
        else{
            System.out.println("Introduce su numero de dni");
            dni = teclado.nextInt();
            teclado.nextLine();
            Alumnos alumno = d1.recuperar(dni);

            if(alumno != null){
                String l = String.valueOf(dni);
                if(alumno.getMateriasInscriptas().pertenece(m)){
                    cd2.acolar(l+"|"+codigo+"|"+materia);
                    System.out.println("El pedido de desinscripcion se hizo correctamnete");
                    Pausa();
                }
                else{
                    System.out.println("El alumno no esta inscripto a la materia");
                }
            }
            else{
                System.out.println("El alumno no existe");
            }
        }
    }

    //Funcion para procesar las inscripciones hechas por los alumnos a traves de la ColaDinamicaTDA
    public static void ProcesarDesinscripciones(ColaTDA cd2, DiccionarioSimpleTDA d1){
        while(!cd2.estaVacia()){
            String valor = cd2.primero();
            String[] partes = valor.split("\\|");
            int dni = Integer.parseInt(partes[0]);
            Materias m = new Materias(partes[1], partes[2]);

            Alumnos alumno = d1.recuperar(dni);
            if(alumno != null){
                if(alumno.getMateriasInscriptas().pertenece(m)) {
                    alumno.getMateriasInscriptas().sacar(m);
                }
            }
            cd2.desacolar();
        }
        System.out.println("Se procesaron todas las desinscripciones");
    }

    //Funcion main donde se ejecuta el menu y carga de datos
    public static void main(String[] args) {

        DiccionarioSimpleTDA d1 = new DiccionarioSimpleEstaticoTDA();
        ConjuntoStringTDA c1 = new ConjuntoEstaticoStringTDA();
        ColaTDA cd1 = new ColaDinamicaStringTDA();
        ColaTDA cd2 = new ColaDinamicaStringTDA();
        c1.inicializar();
        cd1.inicializar();
        cd2.inicializar();
        d1.inicializar();

        CargaDeDatos.cargarDatos(c1,cd1,d1);

        int opcion;

        while(true){
            System.out.println("----------------");
            System.out.println("Elija una opcion:");
            System.out.println("[0],Salir del sistema");
            System.out.println("[1],Agregar Materias");
            System.out.println("[2],Sacar Materias");
            System.out.println("[3],Inscribirse a Materias");
            System.out.println("[4],Desinscribirse a Materias");
            System.out.println("[5],Procesar Inscripciones");

            opcion = teclado.nextInt();
            teclado.nextLine();
            if(opcion==0){
                break;
            }
            else if(opcion==1){
                AgregarMateria(c1);
            }
            else if(opcion==2){
                SacarMateria(c1);
            }
            else if(opcion==3){
                InscribirseMateria(c1,d1,cd1);
            }
            else if(opcion==4){
                DesinscribirseMateria(c1,d1,cd2);
            }
            else if(opcion == 5) {
                // se llama a los dos prosc
                ProcesarInscripciones(cd1, d1);
                ProcesarDesinscripciones(cd2, d1);
                System.out.println("Todos los cambios procesados.");
                Pausa();
            }
            else{
                System.out.println("Opcion invalida");
                Pausa();
            }
        }


        ConjuntoEstaticoTDA claves = d1.obtenerClaves();
        while(!claves.estaVacio()) {
            int d = claves.elegir();
            Alumnos alumno = d1.recuperar(d);
            ConjuntoStringTDA materiasAlumno = alumno.getMateriasInscriptas();
            ConjuntoStringTDA auxReporte = new ConjuntoEstaticoStringTDA();
            auxReporte.inicializar();

            while (!materiasAlumno.estaVacio()) {
                Materias m = materiasAlumno.elegir();
                System.out.println(d + "|" + alumno.getNombre() + "|" + m.getCodigo() + "|" + m.getMateria());
                auxReporte.agregar(m);
                materiasAlumno.sacar(m);
            }
            // se restaura la mat del alumn
            while(!auxReporte.estaVacio()){
                Materias m = auxReporte.elegir();
                materiasAlumno.agregar(m);
                auxReporte.sacar(m);
            }
            claves.sacar(d);
            }
        }
    }