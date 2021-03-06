package org.century.appfacturas;

import org.century.appfacturas.models.*;
import java.util.Scanner;

public class ClaseEjecutable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente();
        cliente.setNif("555-55");
        cliente.setNombre("Juan Carlos");

        System.out.println("Ingrese una descripcion de la factura: ");
        String descripcion = sc.nextLine();

        Factura factura = new Factura(descripcion,cliente);

        //Inializamos las variables para reutilizar
        Producto producto;
        String nombre;
        float precio;
        int cantidad;

        System.out.println();

        for(int i = 0; i < 3; i++){
            //Cada ves que se itere se crea un nuevo producto
            producto = new Producto();

            //Pedismo el nombre del producto
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            nombre = sc.nextLine();
            producto.setNombre(nombre);
            // OPTIMIZADO -> producto.setNombre(sc.nextLine());

            //Pedimos el precio del producto
            System.out.print("Ingrese precio: ");
            precio = sc.nextFloat();
            producto.setPrecio(precio);

            //Pedimos la cantidad del producto
            System.out.print("Ingrese la cantidad del producto: ");
            cantidad = sc.nextInt();

            //Agregamos cada itemFactura a la FACTURA
            factura.addItemFactura(new ItemFactura(cantidad,producto));

            System.out.println();
            sc.nextLine();
        }
        System.out.println(factura.generarDetalle());

    }
}
