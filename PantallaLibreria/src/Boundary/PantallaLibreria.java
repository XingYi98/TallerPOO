/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary;
import Control.ControllerBiblioteca;
import Entidades.Autor;
import Entidades.Libro;
import java.util.ArrayList;
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
        Scanner  info= new Scanner(System.in);
        int opcion;
        String seguir;
       
        do{
            opcion=imprimirMenu();
           
            switch(opcion){
                case 1:
                    //boolean AgregarLibro(Libro nuevoLibro)
                    System.out.println("\nAGREGAR NUEVO LIBRO");
                    Libro libro = infoLibro();
                    if(pantallaLibreria.controlBiblioteca.AgregarLibro(libro) == true){
                            System.out.println("\nSe agrego nuevo libro correctamente");
                            imprimirLibro(libro);
                    }else{
                            System.out.println("ERROR, libro no agregado");
                    }
                    break;
                    
                case 2:
                    //boolean AgregarAutor(Autor nuevoAutor)
                    System.out.println("\nAGREGAR NUEVO AUTOR");
                    Autor autor = infoAutor();
                    if(pantallaLibreria.controlBiblioteca.AgregarAutor(autor) == true){
                        System.out.println("\nSe agrego nuevo autor correctamente");
                        imprimirAutor(autor);
                    }else{
                        System.out.println("ERROR, autor no agregado");
                    }
                    break;
                    
                case 3:
                    //boolean AgregarLibro(Libro nuevoLibro,Autor aut)
                    System.out.println("\nAGREGAR LIBRO NUEVO A AUTOR EXISTENTE");
                    Libro libro1 = infoLibro();
                    Autor autor1 = infoAutor();
                    if(pantallaLibreria.controlBiblioteca.AgregarLibro(libro1, autor1)){
                        System.out.println("\nSe agrego nuevo libro correctamente");
                        imprimirLibro(libro1);
                        System.out.println("\nCon autor");
                        imprimirAutor(autor1);
                    }else{
                        System.out.println("ERROR, libro no agregado");
                    }
                    break;
                    
                case 4:
                    //Libro BuscarLibro(String isbn)
                    System.out.println("\nBUSCAR LIBRO");
                    System.out.println("\nIngrese el isbn del libro que desea buscar");
                    String isbn;
                    isbn = sc.nextLine();
                    Libro libroaux;
                    if(pantallaLibreria.controlBiblioteca.BuscarLibro(isbn) != null){
                        libroaux = pantallaLibreria.controlBiblioteca.BuscarLibro(isbn);
                        System.out.println("Libro encontrado");
                        imprimirLibro(libroaux);
                    }else{
                        System.out.println("ERROR, libro no encontrado");
                    }
                    break;
                    
                case 5:
                    //boolean AsignarAutorALibro(Libro libro,Autor autor)
                    System.out.println("\nASIGNAR AUTOR EXISTENTE A LIBRO EXISTENTE");
                    Autor autor3 = infoAutor();
                    Libro libro3 = infoLibro();
                    if(pantallaLibreria.controlBiblioteca.AsignarAutorALibro(libro3, autor3)){
                        System.out.println("Se asignado correctamente el autor");
                        imprimirAutor(autor3);
                        System.out.println("Al libro");
                        imprimirLibro(libro3);
                    }else{
                        System.out.println("ERROR, no se logro asignar autor a libro");
                    }
                    break;
                    
                case 6:
                    //double CalcularCostoTotal()
                    System.out.println("\nCOSTO TOTAL DE TODO LOS LIBROS");
                    if(pantallaLibreria.controlBiblioteca.CalcularCostoTotal() > 0){
                        System.out.println("Costo total: " + pantallaLibreria.controlBiblioteca.CalcularCostoTotal() + "\n");
                    }else if (pantallaLibreria.controlBiblioteca.CalcularCostoTotal() == 0){
                        System.out.println("No hay libros aun para calcular sus costos");
                    }else{
                        System.out.println("ERROR, no se logro calcular el costo total de los libros"); 
                    }
                    break;

                case 7:
                    //boolean AsignarLibroAutorA(Autor autor,Libro libro)
                    System.out.println("\nASIGNAR LIBRO EXISTENTE A AUTOR EXISTENTE");
                    Autor autor4 = infoAutor();
                    Libro libro4 = infoLibro();
                    if(pantallaLibreria.controlBiblioteca.AsignarLibroAutorA(autor4, libro4)){
                        System.out.println("Se asignado correctamente el libro");
                        imprimirLibro(libro4);
                        System.out.println("Al autor");
                        imprimirAutor(autor4);
                    }else{
                        System.out.println("ERROR, no se logro asignar libro a autor");
                    }
                    break;
                    
                case 8:
                    //Autor BuscarAutor(int cedula)
                    System.out.println("\nBUSCAR AUTOR");
                    System.out.println("\nIngrese la cedula del autor que desea buscar");
                    int cedula;
                    cedula = info.nextInt();
                    Autor autoraux;
                    if(pantallaLibreria.controlBiblioteca.BuscarAutor(cedula) != null){
                        autoraux = pantallaLibreria.controlBiblioteca.BuscarAutor(cedula);
                        System.out.println("Autor encontrado");
                        System.out.println("NOMBRE: " + autoraux.getNombre() + " / CEDULA: " + autoraux.getCedula() + " / ESTADO: " + autoraux.getEstado());
                    }else{
                        System.out.println("ERROR, autor no encontrado");
                    }
                    break;
                    
                case 9:
                    //double CalcularCostosLibrosDeUnAutor(int cedula)
                    System.out.println("\nCOSTO TOTAL DE LIBROS DE UN AUTOR");
                    int cedula1;
                    cedula1 = info.nextInt();
                    if(pantallaLibreria.controlBiblioteca.CalcularCostosLibrosDeUnAutor(cedula1) > 0){
                        System.out.println("Costo total del autor ingresado: " + pantallaLibreria.controlBiblioteca.CalcularCostosLibrosDeUnAutor(cedula1) + "\n");
                    }else if(pantallaLibreria.controlBiblioteca.CalcularCostosLibrosDeUnAutor(cedula1) == 0){
                        System.out.println("El autor no tiene libros aun para calcular el costo");
                    }else{
                        System.out.println("ERROR, no se logro calcular el costo de los libros de  un autor");
                    }
                    break;
                    
                case 10:
                    //ArrayList LibrosDeUnAutor(Autor autor)
                    System.out.println("\nLIBROS DE UN AUTOR");
                    Autor autor5= infoAutor();
                    if(pantallaLibreria.controlBiblioteca.LibrosDeUnAutor(autor5) != null){
                    imprimirListaLibros(pantallaLibreria.controlBiblioteca.LibrosDeUnAutor(autor5));
                    }else{
                        System.out.println("ERROR, no se encontro los libros del autor");
                    }
                    break;
                    
                case 11:
                    //ArrayList AutoresDeUnLibro(Libro libro)
                    System.out.println("\nAUTORES DE UN LIBRO");
                    Libro libro6 = infoLibro();
                    if(pantallaLibreria.controlBiblioteca.AutoresDeUnLibro(libro6) != null){
                    imprimirListaAutores(pantallaLibreria.controlBiblioteca.AutoresDeUnLibro(libro6));
                    }else{
                        System.out.println("ERROR, no se encontro los autores del libro");
                    }
                    break;
                    
                case 12:
                    //Autor AutorMasProductivo()
                    System.out.println("\nAUTOR MAS PRODUCTIVO");
                    if(pantallaLibreria.controlBiblioteca.AutorMasProductivo() != null){
                        System.out.println("Autor mas productivo");
                        imprimirAutor(pantallaLibreria.controlBiblioteca.AutorMasProductivo());
                    }else{
                        System.out.println("No se encontro el autor mas productivo");
                    }
                    break;
                    
                case 13:
                    //Autor MejorAutorDeUnLibro(Libro libro)
                    System.out.println("\nMEJOR AUTOR DE UN LIBRO");
                    System.out.println("\nIngrese el isbn del libro");
                    Libro libro5 = infoLibro();
                    if(pantallaLibreria.controlBiblioteca.MejorAutorDeUnLibro(libro5) != null){
                        System.out.println("Mejor autor de un libro");
                        imprimirAutor(pantallaLibreria.controlBiblioteca.MejorAutorDeUnLibro(libro5));
                    }else{
                        System.out.println("No se encontro el mejor autor de un libro");
                    }
                    break;
                    
                case 14:
                    //Autor AutorQueMasGana()
                    System.out.println("\nAUTOR QUE MAS GANA");
                    if(pantallaLibreria.controlBiblioteca.AutorQueMasGana() != null){
                        System.out.println("Autor que mas gana");
                        imprimirAutor(pantallaLibreria.controlBiblioteca.AutorQueMasGana());
                    }else{
                        System.out.println("No se encontro el autor que mas gana");
                    }
                    break; 
                    
                case 15:
                    System.out.println("HAS SALIDO EXITOSAMENTE");
                    break;
                    
                default:
                    System.out.println("ERROR, ingrese un dato valido");                       
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
    
    public static Libro infoLibro(){
    String isbn,titulo;
    double costo;
    Scanner  sc= new Scanner(System.in);
    Scanner  info= new Scanner(System.in);           
    System.out.println("\nIngrese los datos del libro");
    System.out.println("\nIngrese el isbn");
    isbn = sc.nextLine();
    System.out.println("\nIngrese el titulo");
    titulo = sc.nextLine();
    System.out.println("\nIngrese el costo");
    costo = info.nextDouble();
    Libro libro = new Libro(isbn, titulo, costo);
        
    return libro;
    }
    
    public static Autor infoAutor(){
    String nombre,estado;
    int cedula;
    Scanner  sc= new Scanner(System.in);
    Scanner  info= new Scanner(System.in);
    System.out.println("\nIngrese los datos del autor");
    System.out.println("\nIngrese el nombre");
    nombre = sc.nextLine();
    System.out.println("\nIngrese la cedula");
    cedula = info.nextInt();
    System.out.println("\nIngrese el estado (ACTIVO/INACTIVO)");
    estado = sc.nextLine();
    Autor autor = new Autor(nombre, cedula, estado);
    
    return autor;
    }
    
    public static void imprimirListaAutores(ArrayList<Autor> autores){
        if(autores.isEmpty() == true){
            System.out.println("No hay autores aun");
        }else{
        System.out.println("AUTORES");
        for(int i=0;i<autores.size();i++){
            imprimirAutor(autores.get(i));
        }
        }
    }
    
    public static void imprimirListaLibros(ArrayList<Libro> libros){
        if(libros.isEmpty() == true){
            System.out.println("No hay libros aun");
        }else{
        System.out.println("LIBROS");
        for(int i=0;i<libros.size();i++){
            imprimirLibro(libros.get(i));
        }
        }
    }
    
    public static void imprimirAutor(Autor autor){
        if(autor != null){
            System.out.println("NOMBRE: " + autor.getNombre() + " / CEDULA: " + autor.getCedula() + " / ESTADO: " + autor.getEstado());
        }else{
            System.out.println("Autor no encontrado");
        }
    }
    
    public static void imprimirLibro(Libro libro){
        if(libro != null){
            System.out.println("ISBN: " + libro.getIsbn() + " / TITULO: " + libro.getTitulo() + " / COSTO: " + libro.getCosto());
        }else{
            System.out.println("Libro no encontrado");
        }
    }
    
  
}