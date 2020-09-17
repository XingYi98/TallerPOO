/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author JANET CHEN Y DANIEL FLORIDO
 */
public class Autor {
    private String nombre;
    private int cedula;
    private String estado;

    public Autor() {
    }

    public Autor(String nombre, int cedula, String estado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        if(("ACTIVO".equals(estado))|| ("INACTIVO".equals(estado))){
        return estado;
        }else{
        return null;
        }
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
