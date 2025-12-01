import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {

    ArrayList<Album> Albumnes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean vacio() {
        if (Albumnes.isEmpty()) {
            System.out.println("No hay inmuebles registrados");
            return true;
        }
        return false;
    }

    public void listarAlbums() {
        if (vacio()) return;
        for (int i = 0; i < Albumnes.size(); i++) {
            System.out.println((i + 1) + " " + Albumnes.get(i).getTitulo() + " numero de canciones: " + Albumnes.get(i).getNumCanciones());
        }
    }

    public void eliminarAlbum() {
        if (vacio()) return;
        listarAlbums();

        int opcion = -1;
        boolean opcionValido = false;
        while (!opcionValido) {
            try {
                System.out.println("ELige que inmueble eliminar: ");
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= Albumnes.size()) opcionValido = true;
                else System.out.println("Opcion invalida");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
        Albumnes.remove(opcion - 1);
        System.out.println("Eliminado correctamente");
    }

    public void registrarAlbum() {
        Album nuevo = crearAlbum();
        Albumnes.add(nuevo);
    }

    public Album crearAlbum() {
        System.out.println("Introduce los datos del Album: ");
        String titulo = MetodosCreacion.leerTitulo(sc);
        String artista = MetodosCreacion.leerArtista(sc);
        int anoPub = MetodosCreacion.leerAnoPub(sc);
        int numCanc = MetodosCreacion.leerNumCanciones(sc);

        System.out.println("Creado correctamente");
        return new Album(titulo, artista, anoPub, numCanc, Album.Estado.NORMAL);
    }

    public void editarAlbum() {
        if (vacio()) return;

        while (true) {
            try {
                listarAlbums();
                System.out.println("Elige que album modificar (0 para salir): ");
                int opcion = Integer.parseInt(sc.nextLine());

                if (opcion == 0) {
                    return;
                } else if (opcion >= 1 && opcion <= Albumnes.size()) {
                    boolean seguirEditando = true;
                    while (seguirEditando) {
                        InfoMenus.menu2();
                        System.out.println("Elige el dato a modificar (5 para volver): ");
                        int opcion2 = Integer.parseInt(sc.nextLine());
                        switch (opcion2) {
                            case 1:
                                Albumnes.get(opcion - 1).setTitulo(MetodosCreacion.leerTitulo(sc));
                                break;
                            case 2:
                                Albumnes.get(opcion - 1).setArtistas(MetodosCreacion.leerArtista(sc));
                                break;
                            case 3:
                                Albumnes.get(opcion - 1).setAnoPublicacion(MetodosCreacion.leerAnoPub(sc));
                                break;
                            case 4:
                                Albumnes.get(opcion - 1).setNumCanciones(MetodosCreacion.leerNumCanciones(sc));
                                break;
                            case 5:
                                seguirEditando = false;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                } else {
                    System.out.println("Numero de album no valido");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
            }
        }
    }
}
