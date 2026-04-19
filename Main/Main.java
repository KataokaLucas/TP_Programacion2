package Main;

import Entidades.Alumnos;
import Entidades.Materias;
import Implementacion.ColaDinamicaStringTDA;
import Implementacion.ConjuntoEstaticoMateriasTDA;
import Implementacion.ConjuntoEstaticoTDA;
import Implementacion.DiccionarioSimpleEstaticoTDA;
import tdas.ColaTDA;
import tdas.ConjuntoMateriasTDA;
import tdas.DiccionarioSimpleTDA;
import test.CargaDeDatos;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);

    //Muestra las materias que hay en el conjunto
    //Tiene un costo temporal de O(n^2) ya que el bucle va a iterar dependiendo de la cantidad elementos "n" y como el metodo pertenece esta dentro del metodo agregar, tambien es n
    public static void MostrarMaterias(ConjuntoMateriasTDA c1) {

        //Nos ayudamos con un Conjunto auxiliar para volver a reconstruir el conjunto original
        ConjuntoMateriasTDA aux = new ConjuntoEstaticoMateriasTDA();
        aux.InicializarConjunto();

        System.out.printf("%-6s | %-30s%n","CODIGO","MATERIA");
        System.out.println("-".repeat(45));
        while (!c1.ConjuntoVacio()) {
            Materias valor = c1.Elegir();
            System.out.printf("%-6s | %-30s%n",valor.getCodigo(),valor.getMateria());
            aux.Agregar(valor);
            c1.Sacar(valor);
        }
        // Restauramos los datos al conjunto original
        while (!aux.ConjuntoVacio()) {
            Materias valor = aux.Elegir();
            c1.Agregar(valor);
            aux.Sacar(valor);
        }
    }

    //Muestra a los alumnos con sus materias inscriptas
    // El costo es de O(n*(n+m^2))
    public static void mostarAlumnos(DiccionarioSimpleTDA d1){
        System.out.printf("%-12s | %-25s | %-10s | %-30s%n", "DNI", "ALUMNO", "CODIGO", "MATERIA");
        System.out.println("-".repeat(85));
    //Utilizamos el metodo recuperar del diccionario para obtener los valores a partir de las claves(dni) de los alumnos
    ConjuntoEstaticoTDA claves = d1.ObtenerClaves();
        while(!claves.estaVacio()) {
        int dni = claves.elegir();
        Alumnos alumno = d1.Recuperar(dni);
        ConjuntoMateriasTDA materiasAlumno = alumno.getMateriasInscriptas();
        ConjuntoMateriasTDA auxReporte = new ConjuntoEstaticoMateriasTDA();
        auxReporte.InicializarConjunto();


        //Muestra los alumnos que no estan inscriptos a ninguna materia
        if(materiasAlumno.ConjuntoVacio()){
            System.out.printf("%-12s | %-25s | %-10s | %-30s%n", dni, alumno.getNombre(), "-", "-");
        }
        //Muestra los alumnos que estan inscripto a una o mas materias
        else {
            boolean primero = true;
            while (!materiasAlumno.ConjuntoVacio()) {
                Materias m = materiasAlumno.Elegir();
                if(primero) {
                    // Primera materia → imprime dni y nombre
                    System.out.printf("%-12s | %-25s | %-10s | %-30s%n", dni, alumno.getNombre(), m.getCodigo(), m.getMateria());
                    primero = false;
                }
                else {
                    System.out.printf("%-12s | %-25s | %-10s | %-30s%n", "", "", m.getCodigo(), m.getMateria());
                }
                auxReporte.Agregar(m);
                materiasAlumno.Sacar(m);
            }
        }
            System.out.println("-".repeat(85));
        // Se restaura las materias del alumno
        while (!auxReporte.ConjuntoVacio()) {
            Materias m = auxReporte.Elegir();
            materiasAlumno.Agregar(m);
            auxReporte.Sacar(m);
        }
        claves.sacar(dni);
    }
}

    //Esta funcion evita que por mas que tengan distinto codigo, no permite que el alumno se inscriba a la misma materia
    //Tiene un Costo temporal de o(n^2)
    public static boolean evitarMateriasDuplicadas(ConjuntoMateriasTDA conjuntoMaterias,String materia){
        boolean band = true;
        ConjuntoMateriasTDA aux = new ConjuntoEstaticoMateriasTDA();
        aux.InicializarConjunto();

        while(!conjuntoMaterias.ConjuntoVacio()){
            Materias m = conjuntoMaterias.Elegir();
            if(m.getMateria().equalsIgnoreCase(materia)){
                band = false;
            }
            aux.Agregar(m);
            conjuntoMaterias.Sacar(m);
        }
        while(!aux.ConjuntoVacio()){
            Materias m = aux.Elegir();
            conjuntoMaterias.Agregar(m);
            aux.Sacar(m);
        }
        if(band == false){
            return false;
        }
        else {return true;}

    }

    //Elimina la materia del conjunto del alumno que ya no existe en el conjunto principal de materias
    //Tiene un costo temporal de O(n^2)
    public static void eliminarMateriaDelAlumno(DiccionarioSimpleTDA d1, Materias m){
    ConjuntoEstaticoTDA claves = d1.ObtenerClaves();
        while(!claves.estaVacio()) {
        int dni = claves.elegir();
        Alumnos alumno = d1.Recuperar(dni);
        ConjuntoMateriasTDA materiasAlumno = alumno.getMateriasInscriptas();
        if(materiasAlumno.Pertenece(m)){
            materiasAlumno.Sacar(m);
        }
        claves.sacar(dni);
    }
}

    //Funcion de un string vacio para leer los mensajes(como si fuese una pausa) por terminal
    //El costo temporal es de O(1)
    public static void Pausa(){
        System.out.println("Presione enter para continuar");
        teclado.nextLine();
    }

    //Funcion para agregar materias al ConjuntoTDA Estatico
    //El costo temporal es O(n^2) ya que el metodo pertenece recorre una cantidad n para verificar si ya existe la materia, lo mismo pasa con el metodo agregar y tambien con la funcion Mostrar Materias
    public static void AgregarMateria(ConjuntoMateriasTDA c1){

        String materia;
        String codigo;

        MostrarMaterias(c1);
        System.out.println();
        System.out.println("Ingrese el Codigo de la materia");
        codigo = teclado.nextLine();
        System.out.println("Nombre la materia que desea agregar:");
        materia = teclado.nextLine();
        Materias m = new Materias(codigo,materia);
        if(c1.Pertenece(m)){
            System.out.println("La materia ya existe en el sistema");
            Pausa();
        }
        else{
            c1.Agregar(m);
            System.out.println("La materia se agrego correctamente");
            Pausa();
        }
    }

    //Funcion para sacar materias al ConjuntoTDA Estatico
    //El costo temporal es O(n^2 + m^2) ya que el metodo pertenece recorre una cantidad n para verificar si ya existe la materia y si existe recorre en la funcion eliminarMateriaAlumno otro bucle de complejidad k
    public static void SacarMateria(ConjuntoMateriasTDA c1, DiccionarioSimpleTDA d1){
        String codigo;
        String materia;

        MostrarMaterias(c1);
        System.out.println();
        System.out.println("Ingrese el Codigo de la materia");
        codigo = teclado.nextLine();
        System.out.println("Nombre la materia que desea agregar:");
        materia = teclado.nextLine();
        Materias m = new Materias(codigo,materia);

        if(!c1.Pertenece(m)){
            System.out.println("La materia no existe en el sistema");
            Pausa();
        }
        else{
            eliminarMateriaDelAlumno(d1, m);
            c1.Sacar(m);
            System.out.println("La materia se elimino correctamente");
            Pausa();

        }
    }

    //Funcion para Inscribirse a una materia a traves del dni del alumno
    //El costo temporal es de O(n^2 + m)
    public static void InscribirseMateria(ConjuntoMateriasTDA c1, DiccionarioSimpleTDA d1, ColaTDA cd1){

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


        if(!c1.Pertenece(m)){
            System.out.println("La materia no existe en el sistema");
            Pausa();
        }
        else{
            //Buscamos con el metodo recuperar para obtener el conjunto del alumno para verificar si la materia ya pertenece al mismo
            System.out.println("Introduce su numero de dni");
            dni = teclado.nextInt();
            teclado.nextLine();
            Alumnos alumno = d1.Recuperar(dni);
            if(alumno != null){
                String stringDNI = String.valueOf(dni);
                if(!alumno.getMateriasInscriptas().Pertenece(m)){
                    //Acolamos la materia de esta manera para poder luego splitear y poder manipular mas facilmente los datos que recibimos
                    cd1.Acolar(stringDNI+"|"+codigo+"|"+materia);
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

    //Funcion para procesar las inscripciones hechas por los alumnos a traves de la ColaDinamicaTDA
    //Tiene un costo temporal de O(p × (n+ s^2 + m + k)),
    public static void ProcesarInscripciones(ColaTDA cd1, DiccionarioSimpleTDA d1, ConjuntoMateriasTDA c1) {

        //Utilizamos el metodo split para poder separar los datos que recibimos como String para manipularlos
        while (!cd1.ColaVacia()) {
            String valor = cd1.Primero();
            String[] partes = valor.split("\\|");
            int dni = Integer.parseInt(partes[0]);
            Materias m = new Materias(partes[1], partes[2]);
            Alumnos alumno = d1.Recuperar(dni);

            //Verificamos que la materia a pesar de tener distinto codigo no sea la misma.Ejemplo 1001|Algebra;1002|Algebra
            boolean resultado = evitarMateriasDuplicadas(alumno.getMateriasInscriptas(),partes[2]);
            if (alumno != null && !alumno.getMateriasInscriptas().Pertenece(m) && c1.Pertenece(m) && resultado) {
                alumno.getMateriasInscriptas().Agregar(m);
            }
            cd1.Desacolar();
        }
    }

    //Funcion para Deinscribirse a una materia a traves del dni del alumno
    //El costo temporal es de O(n)
    public static void DesinscribirseMateria(ConjuntoMateriasTDA c1, DiccionarioSimpleTDA d1, ColaTDA cd2){

        String codigo;
        String materia;
        int dni;


        System.out.println("Ingrese el Codigo de la materia");
        codigo = teclado.nextLine();
        System.out.println("Nombre la materia que desea agregar:");
        materia = teclado.nextLine();
        Materias m = new Materias(codigo,materia);


        if(!c1.Pertenece(m)){
            System.out.println("La materia no existe en el sistema");
            Pausa();
        }
        //Buscamos con el metodo recuperar para obtener el conjunto del alumno para verficar si la materia no pertenece al mismo
        else {
            System.out.println("Introduce su numero de dni");
            dni = teclado.nextInt();
            teclado.nextLine();
            Alumnos alumno = d1.Recuperar(dni);

            if(alumno != null){
                String stringDNI = String.valueOf(dni);
                if(alumno.getMateriasInscriptas().Pertenece(m)){
                    cd2.Acolar(stringDNI+"|"+codigo+"|"+materia);
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

    //Funcion para procesar las desinscripciones hechas por los alumnos a traves de la ColaDinamicaTDA
    //El costo temporal es O(p*(n+k)
    public static void ProcesarDesinscripciones(ColaTDA cd2, DiccionarioSimpleTDA d1){
        //Utilizamos el metodo split para poder separar los datos que recibimos como String para manipularlos
        while(!cd2.ColaVacia()){
            String valor = cd2.Primero();
            String[] partes = valor.split("\\|");
            int dni = Integer.parseInt(partes[0]);
            Materias m = new Materias(partes[1], partes[2]);

            Alumnos alumno = d1.Recuperar(dni);
            if(alumno != null){
                if(alumno.getMateriasInscriptas().Pertenece(m)) {
                    alumno.getMateriasInscriptas().Sacar(m);
                }
            }
            cd2.Desacolar();
        }

    }

    //Funcion main donde se ejecuta el menu y carga de datos
    public static void main(String[] args) {

        DiccionarioSimpleTDA d1 = new DiccionarioSimpleEstaticoTDA();
        ConjuntoMateriasTDA c1 = new ConjuntoEstaticoMateriasTDA();
        ColaTDA cd1 = new ColaDinamicaStringTDA();
        ColaTDA cd2 = new ColaDinamicaStringTDA();
        c1.InicializarConjunto();
        cd1.InicializarCola();
        cd2.InicializarCola();
        d1.InicializarDiccionario();
        CargaDeDatos.cargarDatos(c1,cd1,d1);
        int opcion;

        while(true){
            System.out.println("----------------");
            System.out.println("Elija una opcion:");
            System.out.println("[0],Salir del sistema");
            System.out.println("[1],Mostrar Materias");
            System.out.println("[2],Agregar Materias");
            System.out.println("[3],Sacar Materias");
            System.out.println("[4],Inscribirse a Materias");
            System.out.println("[5],Desinscribirse a Materias");
            System.out.println("[6],Procesar Inscripciones/Desincripciones");
            System.out.println("[7] Mostrar Alumnos");
            System.out.println("----------------");

            opcion = teclado.nextInt();
            teclado.nextLine();
            if(opcion==0){
                break;
            }
            else if(opcion == 1){
                MostrarMaterias(c1);
            }
            else if(opcion==2){
                AgregarMateria(c1);
            }
            else if(opcion==3){
                SacarMateria(c1,d1);
            }
            else if(opcion==4){
                InscribirseMateria(c1,d1,cd1);
            }
            else if(opcion==5){
                DesinscribirseMateria(c1,d1,cd2);
            }
            else if(opcion == 6) {
                // se llama a los dos proscesos
                ProcesarInscripciones(cd1, d1,c1);
                ProcesarDesinscripciones(cd2, d1);
                System.out.println("Todos los cambios fueron procesados.");
                Pausa();
            }
            else if(opcion == 7){
                mostarAlumnos(d1);
            }
            else{
                System.out.println("Opcion invalida");
                Pausa();
            }
          }
        }
    }
