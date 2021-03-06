package org.century.appfacturas.models;

public class Producto {

    private Integer codigo;
    private String nombre;
    private float precio;

    //Atributos que no pertenecen a la clase
    private static int indiceCodigo;

    public Producto() {
        this.codigo = ++indiceCodigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.codigo + "\t" + this.nombre + "\t" + this.precio;
    }
}
