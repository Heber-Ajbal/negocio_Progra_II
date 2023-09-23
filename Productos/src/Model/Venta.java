/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Heber
 */
public class Venta {
    private int  codigoProducto;
    private int cantidad;    
    private String total;
    private int idFactura;
    private String Nombre;

    public Venta(int codigoProducto, int cantidad, String total, int idFactura, String Nombre, float PrecioU) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.total = total;
        this.idFactura = idFactura;
        this.Nombre = Nombre;
        this.PrecioU = PrecioU;
    }
    private float PrecioU;

    public Venta() {
        
    }

    public float getPrecioU() {
        return PrecioU;
    }

    public void setPrecioU(float PrecioU) {
        this.PrecioU = PrecioU;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    
    
}
