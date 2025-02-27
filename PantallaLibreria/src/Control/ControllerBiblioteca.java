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
        }
        return false;
    }
    
    public boolean AgregarLibro(Libro nuevoLibro,Autor aut){
         if(BuscarAutor(aut.getCedula()) != null){
            if(BuscarLibro(nuevoLibro.getIsbn()) == null){
                listaLibros.add(nuevoLibro);
                nuevoLibro.getAutores().add(aut);
                aut.getLibrosEscritos().add(nuevoLibro);
                return true;
            }
        }
        return false;
    }
 
    
    public Libro BuscarLibro(String isbn){
        if(listaLibros.isEmpty() == false){
        for(int i=0; i<listaLibros.size();i++){
            if(listaLibros.get(i).getIsbn().equals(isbn)){
            return listaLibros.get(i);
            }
        }
        }
        return null;   
    }
    
    public boolean AsignarAutorALibro(Libro libro,Autor autor){        
        boolean alreadyExist;
        Autor autoraux =BuscarAutor(autor.getCedula());
        Libro libroaux =BuscarLibro(libro.getIsbn());
            if((autoraux!= null) && (libroaux !=null)){
                alreadyExist=libroaux.AlreadyExist(autor);
                if(autor.getEstado().equals("ACTIVO")){
                    if(alreadyExist==false){
                        libro.crearAutor(autor);
                        return true; 
                    }
                }
            }
        return false;
    }
    public double CalcularCostoTotal(){
        int total=0;
        for(int i=0; i< this.listaLibros.size();i++){
            total+= this.listaLibros.get(i).getCosto();
        }
        return total;
    }
    public boolean AgregarAutor(Autor nuevoAutor){
        if(BuscarAutor(nuevoAutor.getCedula())==null){
            this.listaAutores.add(nuevoAutor);
            return true;
        }
        return false;
    }
    public boolean AsignarLibroAutorA(Autor autor,Libro libro){
        Autor autoraux =BuscarAutor(autor.getCedula());
        Libro libroaux =BuscarLibro(libro.getIsbn());
        if((libroaux!= null) && (autoraux!=null)){
                if(autor.alreadyExist(libro) == false){
                        autor.crearLibro(libro);
                       return true;
                }
            }
        return false;

    }
    public Autor BuscarAutor(int cedula){
        if(listaAutores.isEmpty() == false){
        for(int i=0; i< listaAutores.size(); i++){
            if(listaAutores.get(i).getCedula() == cedula){
            return listaAutores.get(i);
            }
        }
        }
    return null;
    }
    
    public double CalcularCostosLibrosDeUnAutor(int cedula){
        double costosLibro=0.0;
        if(BuscarAutor(cedula)!= null){
            for(int i=1; i<BuscarAutor(cedula).getLibrosEscritos().size(); i++){ 
            costosLibro+=BuscarAutor(cedula).getLibrosEscritos().get(i).getCosto();
            }
        }
        return costosLibro;
    }
    
    public ArrayList<Libro> LibrosDeUnAutor(Autor autor){
       Autor autoraux;
       autoraux= BuscarAutor(autor.getCedula());
        if(autoraux == null){
           return null;
       }else{
           return autoraux.getLibrosEscritos();
       }
    }
    
    public ArrayList<Autor> AutoresDeUnLibro(Libro libro){
        Libro libroaux;
        libroaux = BuscarLibro(libro.getIsbn());
       if(libroaux == null){
           return null;
       }else{
           return libroaux.getAutores();
       }
    }
   
    public Autor AutorMasProductivo(){
        int cantLibros;
        Autor autoraux;
        cantLibros=listaAutores.get(0).getLibrosEscritos().size();
        autoraux=listaAutores.get(0);
            for(int i=1; i<listaAutores.size(); i++){ 
                if(listaAutores.get(i).getLibrosEscritos().size()>cantLibros){
                    cantLibros=listaAutores.get(i).getLibrosEscritos().size();
                    autoraux=listaAutores.get(i);
                }
            }        
        return autoraux;
    }
    
    private Autor AutorMasProductivo(ArrayList<Autor> autores){
        int cantLibros;
        int j=0;
        Autor autoraux;
        cantLibros=autores.get(0).getLibrosEscritos().size();
        autoraux=autores.get(0);
            for(int i=1; i<autores.size(); i++){ 
                if(autores.get(i).getLibrosEscritos().size()>cantLibros){
                    cantLibros=autores.get(i).getLibrosEscritos().size();
                    autoraux=autores.get(i);
                }
            }        
        return autoraux;
    }
    
    public Autor MejorAutorDeUnLibro(Libro libro){
        Autor aut;
        if(BuscarLibro(libro.getIsbn()) != null){
            aut = AutorMasProductivo(BuscarLibro(libro.getIsbn()).getAutores());
            return aut;
        }
        return null;
    }
    
    public Autor AutorQueMasGana(){ 
        double ingreso;
        Autor autoraux;
        ingreso=CalcularCostosLibrosDeUnAutor(listaAutores.get(0).getCedula());
        autoraux=listaAutores.get(0);
        for(int i=1; i< listaAutores.size(); i++){
            if(CalcularCostosLibrosDeUnAutor(listaAutores.get(i).getCedula())>ingreso){
            ingreso=CalcularCostosLibrosDeUnAutor(listaAutores.get(i).getCedula());
            autoraux=listaAutores.get(i);
            }
        }
        return autoraux;
    }
}
