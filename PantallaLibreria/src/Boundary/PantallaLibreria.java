/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary;
import Control.ControllerBiblioteca;
import Entidades.Autor;
import Entidades.Libro;
import java.util.Scanner;

/**
 *
 * @author JANET CHEN Y DANIEL FLORIDO
 */
public class PantallaLibreria {
   
    /**
     * @param args the command line arguments
     */
    
    private ControllerBiblioteca controlBiblioteca;
   
    public PantallaLibreria() {
        this.controlBiblioteca = new ControllerBiblioteca();
    }
    
    public static void main(String[] args) {
        
        PantallaLibreria pantallaLibreria = new PantallaLibreria();
        Scanner  sc= new Scanner(System.in);
        int opcion;
        String seguir;
        Libro libro1 = new Libro("001","Habia una vez",20000);
        Libro libro2 = new Libro("002","Hola",50000);
        Libro libro3 = new Libro("003","Como",30000);
        Autor aut1 = new Autor("Daniel",123456789,"ACTIVO");
        Autor aut2 = new Autor("Janet",234567891,"ACTIVO");
        
        do{
            opcion=imprimirMenu();
           
            switch(opcion){
                case 1:
                    //boolean AgregarLibro(Libro nuevoLibro)
                    System.out.println("\nAGREGAR NUEVO LIBRO");
                    System.out.println("Se agrego nuevo libro?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro2));
                    System.out.println("Se agrego nuevo libro?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro1));
                    System.out.println("Libro con isbn repetido, se agrego?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro1) + "\n");
                    break;
                case 2:
                    //boolean AgregarAutor(Autor nuevoAutor)
                    System.out.println("\nAGREGAR NUEVO AUTOR");
                    System.out.println("Se agrego nuevo autor?: " + pantallaLibreria.controlBiblioteca.AgregarAutor(aut1));
                    System.out.println("Se agrego nuevo autor?: " + pantallaLibreria.controlBiblioteca.AgregarAutor(aut2));
                    System.out.println("Autor repetido, se agrego?: " + pantallaLibreria.controlBiblioteca.AgregarAutor(aut2)+ "\n");
                    break;
                case 3:
                    //boolean AgregarLibro(Libro nuevoLibro,Autor aut)
                    System.out.println("\nAGREGAR LIBRO NUEVO A AUTOR EXISTENTE");
                    System.out.println("Se agrego libro nuevo?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro3, aut1));
                    System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AgregarLibro(libro1, aut1));
                    break;    
                case 4:
                    //Libro BuscarLibro(String isbn)
                    System.out.println("\nBUSCAR LIBRO");
                    System.out.println("Libro encontrado?: " + pantallaLibreria.controlBiblioteca.BuscarLibro(libro1.getIsbn()).getTitulo() + "\n");
                    break;
                case 5:
                    //boolean AsignarAutorALibro(Libro libro,Autor autor)
                    System.out.println("\nASIGNAR AUTOR EXISTENTE A LIBRO EXISTENTE");
                    System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AsignarAutorALibro(libro1, aut1));
                    System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AsignarAutorALibro(libro1, aut2) + "\n");
                    break;
                case 6:
                    //double CalcularCostoTotal()
                    System.out.println("\nCOSTO TOTAL DE TODO LOS LIBROS");
                    System.out.println("Costo total: " + pantallaLibreria.controlBiblioteca.CalcularCostoTotal() + "\n");
                    break;
                case 7:
                    //boolean AsignarLibroAutorA(Autor autor,Libro libro)
                    System.out.println("\nASIGNAR LIBRO EXISTENTE A AUTOR EXISTENTE");
                    System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AsignarLibroAutorA(aut1, libro1));
                    System.out.println("Libro en la lista de libro, se agrego?: " + pantallaLibreria.controlBiblioteca.AsignarLibroAutorA(aut2, libro1) + "\n");
                    break;
                case 8:
                    //Autor BuscarAutor(int cedula)
                    System.out.println("\nBUSCAR AUTOR");
                    System.out.println("Autor encontrado: " + pantallaLibreria.controlBiblioteca.BuscarAutor(aut1.getCedula()).getNombre() + "\n");
                    break;
                case 9:
                    //double CalcularCostosLibrosDeUnAutor(int cedula)
                    System.out.println("\nCOSTO TOTAL DE LIBROS DEL AUTOR 1");
                    System.out.println("Costo total: " + pantallaLibreria.controlBiblioteca.CalcularCostosLibrosDeUnAutor(aut1.getCedula()) + "\n");
                    break;
                case 10:
                    //ArrayList LibrosDeUnAutor(Autor autor)
                    break;
                case 11:
                    //ArrayList AutoresDeUnLibro(Libro libro)
                    break;
                case 12:
                    //Autor AutorMasProductivo()
                    System.out.println("\nAUTOR MAS PRODUCTIVO");
                    System.out.println("Autor mas productivo: " + pantallaLibreria.controlBiblioteca.AutorMasProductivo().getNombre() + "\n");
                    break;
                case 13:
                    //Autor MejorAutorDeUnLibro(Libro libro)
                    System.out.println("\nMEJOR AUTOR DE UN LIBRO");
                    System.out.println("Mejor autor de un libro: " + pantallaLibreria.controlBiblioteca.MejorAutorDeUnLibro(libro1).getNombre() + "\n");
                    break;
                case 14:
                    //Autor AutorQueMasGana()
                    System.out.println("\nAUTOR QUE MAS GANA");
                    System.out.println("Autor que mas gana: " + pantallaLibreria.controlBiblioteca.AutorQueMasGana().getNombre());
                    break; 
                case 15:
                    break;
                default:
                    System.out.println("ERROR! ingrese un dato valido!");                       
                    break;
            }
            if(opcion != 15){
            System.out.println("\nDesea ver el menu de nuevo s/n");
            seguir= sc.nextLine();
            System.out.println("\n");
            if("n".equals(seguir)){
                break;
            }
            }
         
        }while(opcion!=15);
    }
    
    public static int imprimirMenu(){
        int eleccion;  
        Scanner  sc= new Scanner(System.in);
        System.out.println(" Eliga por favor una opcion: ");
        System.out.println("\t1. Agregar un libro");
        System.out.println("\t2. Agregar un autor");
        System.out.println("\t3. Agregar un libro nuevo con autor");
        System.out.println("\t4. Buscar libro");
        System.out.println("\t5. Asignar autor a libro");
        System.out.println("\t6. Costo total de todo los libros");
        System.out.println("\t7. Asignar libro a autor");
        System.out.println("\t8. Buscar Autor");
        System.out.println("\t9. Costos total de libros de un autor");
        System.out.println("\t10.Lista de libros de un autor");
        System.out.println("\t11.Lista de autores de un libro");
        System.out.println("\t12.Autor mas productivo");
        System.out.println("\t13.Mejor autor de un libro");
        System.out.println("\t14.Autor que mas gana");
        System.out.println("\t15.Salir");        
        System.out.println("Opcion: ");
        eleccion= sc.nextInt();
        return eleccion;
    }  
    
    
}