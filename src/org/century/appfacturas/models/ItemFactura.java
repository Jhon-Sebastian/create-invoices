package org.century.appfacturas.models;

public class ItemFactura {

    private Integer cantidad;
    private Producto producto;

    public ItemFactura(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //Metodo que calcula el importe del producto = Producto * #Productos
    public float calcularImporte(){
        return this.cantidad * this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return this.producto +
                "\t" + this.cantidad +
                "\t" + calcularImporte() +
                "\n";
    }
}
