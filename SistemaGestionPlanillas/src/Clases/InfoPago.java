
package Clases;

import java.sql.Date;


/**
 *
 * @author reyna
 */
public class InfoPago {
    
    private int id;
    private String id_Empleado;
    private Date fecha;
    private int unidades;
    private Double descuento;
    private Double total_dia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(String id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal_dia() {
        return total_dia;
    }

    public void setTotal_dia(Double total_dia) {
        this.total_dia = total_dia;
    }
    
    
    
}
