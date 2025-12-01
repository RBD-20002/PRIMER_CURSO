package Gestion;

import Materiales.Libro;
import Materiales.Material;
import Materiales.Revista;
import Materiales.Tesis;
import Usuarios.Usuario;

import java.util.*;

public class Biblioteca {

    Scanner sc = new Scanner(System.in);
    InfoMenu info = new InfoMenu();
    LinkedList<Material> materiales = new LinkedList<>();
    LinkedList<Usuario> usuarios = new LinkedList<>();
    HashMap<Usuario, Material> prestamo = new HashMap<>();

    public static List<Material> buscarTitulo(LinkedList<Material> materiales, String busqueda) {
        List<Material> resultado = new ArrayList<>();
        for (Material material : materiales) {
            if (material.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
                resultado.add(material);
            }
        }
        if (resultado.isEmpty()) System.out.println("No se encontraron titulos con esa busqueda: " + busqueda);
        return resultado;
    }

    public static List<Material> buscarAutor(LinkedList<Material> materiales, String busqueda) {
        List<Material> resultado2 = new ArrayList<>();
        for (Material material : materiales) {
            if (material.getAutor().toLowerCase().contains(busqueda.toLowerCase())) {
                resultado2.add(material);
            }
        }
        if (resultado2.isEmpty()) System.out.println("No se encontraron autores con esa busqueda: " + busqueda);
        return resultado2;
    }

    public void agregarMaterialesUsuarios() {
        int opcion = -1;
        do {
            try {
                info.menu4();
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> agregarMaterial();
                    case 2 -> agregarUsuario();
                    case 3 -> System.out.println("Volviendo atras");
                    default -> System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
                opcion = -1;
            }
        } while (opcion != 3);
    }

    public void registrarPrestamo() {
        if (vacioMateriales() || vacioUsuarios()) return;

        Usuario clave = seleccionarUsuario();
        Material valor = seleccionarMaterial();

        prestamo.put(clave, valor);
        valor.setEstado(Material.Estado.OCUPADO);
    }

    public void filtrarMateriales() {
        int opcion = -1;
        do {
            try {
                info.menu3();
                System.out.println("Elige por cual vas a filtrar");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce una letra o una referencia al titulo: ");
                        String palabra = sc.nextLine();
                        buscarTitulo(materiales, palabra);
                        break;
                    case 2:
                        System.out.println("Introduce una letra o una referencia al autor: ");
                        String palabra2 = sc.nextLine();
                        buscarAutor(materiales, palabra2);
                        break;
                    case 3:
                        System.out.println("Volviendo atras");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducio invalido");
            }
        } while (opcion != 3);
    }

    public void calcularMultas() {
    }

    public void listarMaterialesUsuarios() {
        if (vacioMateriales() || vacioUsuarios()) return;
        info.menu5();
        int opcion = -1;
        do {
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> listarMateriales();
                    case 2 -> listarUsuarios();
                    case 3 -> System.out.println("Volviendo atras");
                    default -> System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        } while (opcion != 3);
    }

    public void listarMateriales() {
        if (vacioMateriales()) return;
        for (int i = 0; i < materiales.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " " + materiales.get(i));
        }
    }

    public void listarUsuarios() {
        if (vacioUsuarios()) return;
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " " + usuarios.get(i));
        }
    }

    public void agregarMaterial() {
        System.out.println("Seleccion que material vas a agregar: ");
        info.menu2();
        int opcion;
        do {
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        Libro lb = MetodosCreacion.crearLibro(sc);
                        materiales.add(lb);
                        break;
                    case 2:
                        Revista rv = MetodosCreacion.crearRevista(sc);
                        materiales.add(rv);
                        break;
                    case 3:
                        Tesis ts = MetodosCreacion.crearTesis(sc);
                        materiales.add(ts);
                        break;
                    case 4:
                        System.out.println("Volviendo atras");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
                opcion = -1;
            }
            info.menu2();
        } while (opcion != 4);
    }

    public void agregarUsuario() {
        System.out.println("Introduce los datos del usuario: ");
        Usuario usu = MetodosCreacion.crearUsuario(sc);
        usuarios.add(usu);
    }

    public boolean vacioUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return true;
        } else return false;
    }

    public boolean vacioMateriales() {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados");
            return true;
        } else return false;
    }

    private Usuario seleccionarUsuario() {
        int opcion = -1;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                listarUsuarios();
                System.out.println("Elige el usuario que hace el prestamo:");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= usuarios.size()) opcionValida = true;
                else System.out.println("Opcion invalida");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
        return usuarios.get(opcion - 1);
    }

    private Material seleccionarMaterial() {
        int opcion2 = -1;
        boolean opcionValida2 = false;
        while (!opcionValida2) {
            try {
                listarMateriales();
                System.out.println("Elige el libro que quiere el usuario: ");
                opcion2 = Integer.parseInt(sc.nextLine());
                if (opcion2 >= 1 && opcion2 <= materiales.size()) opcionValida2 = true;
                else System.out.println("Opcion invalida");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
        return materiales.get(opcion2 - 1);
    }
}
