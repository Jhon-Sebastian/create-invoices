package org.century.appfacturas.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    //Atributos de la clase
    private Integer id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;

    //Atributos que cumplen otras funciones
    private static int indiceId;
    private int indiceItems;
    private static final int MAX_ITEMS = 10;

    public Factura(String descripcion, Cliente cliente) {
        this.id = ++indiceId;
        this.items = new ItemFactura[MAX_ITEMS];
        this.fecha = new Date();
        this.descripcion = descripcion;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    //Metodo para agregar un item
    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    //Calcular el precio de los productos de todos los itesmFacturas
    public float calcularTotal() {
        float total = 0;
        for(int i  = 0; i < indiceItems; i++){
            total += items[i].calcularImporte();
        }
        return total;
    }

    //Metodo para mostrar todos los datos
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura # ")
                .append(this.id)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\tNIF: ")
                .append(this.cliente.getNif())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n")
        ;

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n")
        ;
        //Recorremos solo los elementos que existan y no todo el arreglo
        for(int i = 0; i < indiceItems; i++){
            sb.append(items[i]);
        }
        sb.append("\nGRAN TOTAL: ").append(calcularTotal());

        return sb.toString();
    }
}
