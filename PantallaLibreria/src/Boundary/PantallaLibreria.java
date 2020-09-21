/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary;
import Control.ControllerBiblioteca;
import Entidades.Autor;
import Entidades.Libro;

/**
 *
 * @author JANET CHEN Y DANIEL FLORIDO
 */
public class PantallaLibreria {
   
    /**
     * @param args the command line arguments
     */
    
    private ControllerBiblioteca controlBiblioteca;
    
    public static void main(String[] args) {
        
        PantallaLibreria pantallaLibreria = new PantallaLibreria();
        
        Libro libro1 = new Libro("001","Habia una vez",20000);
        Libro libro2 = new Libro("002","Hola",10000);
        Libro libro3 = new Libro("003","Como",30000);
        Autor aut1 = new Autor("Daniel",123456789,"ACTIVO");
        Autor aut2 = new Autor("Janet",234567891,"ACTIVO");
        
        //boolean AgregarLibro(Libro nuevoLibro)
        System.out.println("AGREGAR NUEVO LIBRO");
        System.out.println("Se agrego nuevo libro?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro2));
        System.out.println("Se agrego nuevo libro?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro1));
        System.out.println("Libro con isbn repetido, se agrego?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro1) + "\n");
        
        //boolean AgregarAutor(Autor nuevoAutor)
        System.out.println("AGREGAR NUEVO AUTOR");
        System.out.println("Se agrego nuevo autor?: " + pantallaLibreria.controlBiblioteca.AgregarAutor(aut1));
        System.out.println("Se agrego nuevo autor?: " + pantallaLibreria.controlBiblioteca.AgregarAutor(aut2));
        System.out.println("Autor repetido, se agrego?: " + pantallaLibreria.controlBiblioteca.AgregarAutor(aut2)+ "\n");
        
        //boolean AgregarLibro(Libro nuevoLibro,Autor aut)
        System.out.println("AGREGAR LIBRO NUEVO A AUTOR EXISTENTE");
        System.out.println("Se agrego libro nuevo?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro3, aut1));
        System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro1, aut1));
        
        //Libro BuscarLibro(String isbn)
        System.out.println("BUSCAR LIBRO");
        System.out.println("Libro encontrado?: " + pantallaLibreria.controlBiblioteca.BuscarLibro(libro1.getIsbn()).getTitulo() + "\n");
    
        //boolean AsignarAutorALibro(Libro libro,Autor autor)
        System.out.println("ASIGNAR AUTOR EXISTENTE A LIBRO EXISTENTE");
        System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AsignarAutorALibro(libro1, aut1) + "\n");
        
        //double CalcularCostoTotal()
        System.out.println("COSTO TOTAL DE TODO LOS LIBROS");
        System.out.println("Costo total: " + pantallaLibreria.controlBiblioteca.CalcularCostoTotal() + "\n");
        
        //boolean AsignarLibroAutorA(Autor autor,Libro libro)
        System.out.println("ASIGNAR LIBRO EXISTENTE A AUTOR EXISTENTE");
        System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AsignarLibroAutorA(aut1, libro1) + "\n");
        
        //Autor BuscarAutor(int cedula)
        System.out.println("BUSCAR AUTOR");
        System.out.println("Autor encontrado: " + pantallaLibreria.controlBiblioteca.BuscarAutor(aut1.getCedula()).getNombre() + "\n");
    
        //double CalcularCostosLibrosDeUnAutor(int cedula)
        System.out.println("COSTO TOTAL DE LIBROS DEL AUTOR 1");
        System.out.println("Costo total: " + pantallaLibreria.controlBiblioteca.CalcularCostosLibrosDeUnAutor(aut1.getCedula()) + "\n");
        
        //ArrayList LibrosDeUnAutor(Autor autor)
        System.out.println("Libros del Autor 2: " + pantallaLibreria.controlBiblioteca.LibrosDeUnAutor(aut2).get(0) + "\n");
        
    }
    
    public PantallaLibreria() {
        this.controlBiblioteca = new ControllerBiblioteca();
    }
    


}