package unlar.edu.ar;

import unlar.edu.ar.objects.*;
import unlar.edu.ar.service.BibliotecaService;
import unlar.edu.ar.exception.*;

public class App {

    public static void main(String[] args) {

        BibliotecaService biblio = new BibliotecaService();

    
        Libro l1 = new Libro("Harry Potter y la Piedra Filosofal", "111", "J.K. Rowling", 1997);
        Libro l2 = new Libro("Mujercitas", "222", "Alcott", 1868);
        Libro l3 = new Libro("Clean Code", "333", "Martin", 2008);
        Libro l4 = new Libro("Orgullo y Prejuicio", "444", "Austen", 1813);
        Libro l5 = new Libro("Estructuras de Datos", "555", "Autor Y", 2015);

        biblio.agregarLibro(l1);
        biblio.agregarLibro(l2);
        biblio.agregarLibro(l3);
        biblio.agregarLibro(l4);
        biblio.agregarLibro(l5);

    
        Estudiante e1 = new Estudiante("1", "Martina Martinez", "Ing en Sistemas", "MartinaM@gmail.com");
        Estudiante e2 = new Estudiante("2", "Lala Drona", "Ing en Sistemas", "lala@gmail.com");
        Estudiante e3 = new Estudiante("3", "Charly Garcia", "Ing en Sistemas", "charlie@gmail.com");

        biblio.agregarEstudiante(e1);
        biblio.agregarEstudiante(e2);
        biblio.agregarEstudiante(e3);

        System.out.println("\n===== LIBROS CARGADOS =====");
biblio.mostrarLibros();

System.out.println("\n===== ESTUDIANTES CARGADOS =====");
biblio.mostrarEstudiantes();


        try {
            biblio.registrarPrestamo("111", "1");
            System.out.println("Préstamo realizado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            biblio.registrarPrestamo("111", "2"); // ya está prestado
        } catch (LibroNoDisponibleException e) {
            System.out.println("Libro no disponible: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

  
        try {
            biblio.registrarPrestamo("222", "99");
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("Estudiante no encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            biblio.registrarPrestamo("222", "1");
            biblio.registrarPrestamo("333", "1");
            biblio.registrarPrestamo("444", "1"); // este debería fallar
        } catch (LimitePrestamosExcedidoException e) {
            System.out.println("Límite de préstamos excedido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        int diasRetraso = 15;
        double multaPorDia = 50; // podés cambiarlo
        double multaTotal = diasRetraso * multaPorDia;

        System.out.println("Multa por " + diasRetraso + " días: $" + multaTotal);
    }
}