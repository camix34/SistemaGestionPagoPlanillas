/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;


/**
 *
 * @author reyna
 */
public class Pago {
    
    private int id;
    private String idempleado;
    private Double salario_base;
    private Double isss;
    private Double afp;
    private Double descuento;
    private Date fecha;
    private Double total;
    private Date fechainicial;
    private Date fechafinal;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public Double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(Double salario_base) {
        this.salario_base = salario_base;
    }

    public Double getIsss() {
        return isss;
    }

    public void setIsss(Double isss) {
        this.isss = isss;
    }

    public Double getAfp() {
        return afp;
    }

    public void setAfp(Double afp) {
        this.afp = afp;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public Double calculoISSS(Double salario){
        
        Double total = 0.0;
        Double isss = 0.03;
        total = salario*isss;
        total = Math.round(total*100.0)/100.0;
        
      
        
        
    return total;
    }
    
    public Double calculoAFP(Double salario){
        
    Double total = 0.0;
    Double afp = 0.0725;
    total = salario*afp;
    
    total = Math.round(total*100.0)/100.0;
    
    return total;
    }
    
}
