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
public class Libro {
    private String isbn;
    private String titulo;
    private double costo;
    private ArrayList<Autor> autores;

    public Libro() {
    }

    public Libro(String isbn, String titulo, double costo) {
        this.isbn = isbn="";
        this.titulo = titulo;
        this.costo = costo;
        this.autores = new ArrayList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    
    public boolean AlreadyExist(Autor autor){
     for(int i=0;i<this.autores.size();i++){
         if(this.autores.get(i).getCedula()==autor.getCedula()){
             return true;
         }
     }
     return false;
    }  
    
    
}
