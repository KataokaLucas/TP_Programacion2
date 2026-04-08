package Entidades;

public class Materias {

    private String codigo;
    private String materia;

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
