/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Entidades.Libro;
import Entidades.Autor;
import java.util.ArrayList;
/**
 *
 * @author JANET CHEN Y DANIEL FLORIDO
 */
public class ControllerBiblioteca {
    
    private ArrayList<Libro> listaLibros;
    private ArrayList<Autor> listaAutores;

    public ControllerBiblioteca(ArrayList<Libro> listaLibros, ArrayList<Autor> listaAutores) {
        this.listaLibros = listaLibros;
        this.listaAutores = listaAutores;
    }

    public ControllerBiblioteca() {
        this.listaLibros = new ArrayList<>();
        this.listaAutores = new ArrayList<>();
    }
   
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(ArrayList<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }
    
    public boolean AgregarLibro(Libro nuevoLibro){
        if(BuscarLibro(nuevoLibro.getIsbn()) == null){
            listaLibros.add(nuevoLibro);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean AgregarLibro(Libro nuevoLibro,Autor autor){
        return true;
    }
    
    public Libro BuscarLibro(String isbn){
        for(int i=0; i<listaLibros.size();i++){
            if(listaLibros.get(i).getIsbn().equals(isbn)){
            return listaLibros.get(i);
            }
        }
        return null;
    }
    
    public boolean AsignarAutorALibro(Libro libro,Autor autor){
        return true;
    }
    public double CalcularCostoTotal(){
        return 0;
    }
    public boolean AgregarAutor(Autor nuevoAutor){
        return true;
    }
    public boolean AsignarLibroAutorA(Autor autor,Libro libro){
        return true;
    }
    public Autor BuscarAutor(int cedula){
        for(int i=0; i< listaAutores.size(); i++){
        if(listaAutores.get(i).getCedula() == cedula){
            return listaAutores.get(i);
        }
    }
    return null;
    }
    public double CalcularCostosLibrosDeUnAutor(int cedula){
        return 0;
    }
    public ArrayList LibrosDeUnAutor(Autor autor){
        return null;
    }
    public ArrayList AutoresDeUnLibro(Libro libro){
        return null;
    }
    public Autor AutorMasProductivo(){
        return null;
    }
    public Autor MejorAutorDeUnLibro(Libro libro){
        return null;
    }
    public Autor AutorQueMasGana(double porciento){
        return null;
    }
            
    
}
