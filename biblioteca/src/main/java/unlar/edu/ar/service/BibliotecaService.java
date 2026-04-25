package unlar.edu.ar.service;

import unlar.edu.ar.objects.*;
import unlar.edu.ar.exception.*;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaService {

    private List<Libro> libros = new ArrayList<>();
    private Map<String, Estudiante> estudiantes = new HashMap<>();
    private List<Prestamo> prestamos = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getLegajo(), estudiante);
    }


    public void registrarPrestamo(String isbn, String legajo)
            throws LibroNoDisponibleException,
                   EstudianteNoEncontradoException,
                   LimitePrestamosExcedidoException {

        Libro libro = null;

        // Buscar libro
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                libro = l;
                break;
            }
        }

   
        if (libro == null || !libro.isDisponible()) {
            throw new LibroNoDisponibleException("Libro no disponible");
        }

    
        Estudiante est = estudiantes.get(legajo);

        if (est == null) {
            throw new EstudianteNoEncontradoException("Estudiante no encontrado");
        }

       
        int contador = 0;

        for (Prestamo p : prestamos) {
            if (p.getEstudiante().getLegajo().equals(legajo)) {
                contador++;
            }
        }

        if (contador >= 3) {
            throw new LimitePrestamosExcedidoException("Máximo 3 préstamos");
        }

     
        Prestamo p = new Prestamo(libro, est, LocalDate.now(), null);
        prestamos.add(p);
        libro.setDisponible(false);
    }


    public void mostrarLibros() {
        System.out.println("---- LISTA DE LIBROS ----");
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

   
    public void mostrarEstudiantes() {
        System.out.println("---- LISTA DE ESTUDIANTES ----");
        for (Estudiante e : estudiantes.values()) {
            System.out.println(e);
        }
    }
}
