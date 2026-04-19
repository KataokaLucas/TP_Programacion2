package Entidades;

public class Materias {

    protected String codigo;
    protected String materia;

    public Materias(){
    }

    public Materias(String codigo,String materia){
        this.codigo = codigo;
        this.materia = materia;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getMateria(){
        return materia;
    }
}
