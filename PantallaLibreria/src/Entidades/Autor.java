/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author JANET CHEN Y DANIEL FLORIDO
 */
public class Autor {
    private String nombre;
    private int cedula;
    private String estado;
    private ArrayList<Libro> librosEscritos;

    public Autor() {
        this.librosEscritos = new ArrayList<>();
    }

    public Autor(String nombre, int cedula, String estado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
        this.librosEscritos = new ArrayList<>();
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

    public ArrayList<Libro> getLibrosEscritos() {
        return librosEscritos;
        
    }

    public void setLibrosEscritos(ArrayList<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }
    
    public boolean alreadyExist(Libro libro){
        if(this.librosEscritos.isEmpty() == false){
        for(int i=0;i<this.librosEscritos.size();i++){
            if(this.librosEscritos.get(i).getIsbn().equals(libro.getIsbn())){
                return true;
            }                
        }
        }
        return false;
    }   
    
    public void crearLibro(Libro libro){
        librosEscritos.add(libro);
    }
    
    
}
