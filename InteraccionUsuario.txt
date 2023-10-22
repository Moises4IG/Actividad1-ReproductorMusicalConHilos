import java.util.Scanner;

public class InteraccionUsuario extends Thread {
    private ReproductorMusica hiloMusica;
    private final String LETRA_CANCION = 
        "Yeah\n" +
        "\nAll the crazy shit I did tonight\n" +
        "Those would be the best memories\n" +
        "I just wanna let it go for the night\n" +
        "That would be the best therapy for me\n" +
        "\nAll the crazy shit I did tonight\n" +
        "Those would be the best memories\n" +
        "I just wanna let it go for the night\n" +
        "That would be the best therapy for me\n" +
        "\nUh, hey, hey (ooh)\n" +
        "Uh, yeah, yeah (ooh)\n" +
        "Uh, hey, hey (ooh)\n" +
        "Uh, yeah, yeah (ooh)\n" +
        "\nUh, hey, hey (ooh)\n" +
        "Uh, yeah, yeah (ooh)\n" +
        "Uh, hey, hey (ooh)\n" +
        "Uh, yeah, yeah (ooh)\n" +
        "\nIt's gettin' late, but I don't mind\n" +
        "It's gettin' late, but I don't mind\n" +
        "It's gettin' late, but I don't mind\n" +
        "It's gettin' late, but I don't mind";


    public InteraccionUsuario(ReproductorMusica hiloMusica) {
        this.hiloMusica = hiloMusica;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al reproductor musical interactivo. Estás escuchando 'Memories' de David Guetta ft. Kid Cudi.");
        System.out.println("¿Te gustaría ver la letra de la canción? (responde sí o no)");

        String respuestaLetra = scanner.nextLine().trim().toLowerCase();
        if (respuestaLetra.equals("sí") || respuestaLetra.equals("si")) {
            System.out.println(LETRA_CANCION);
        } else {
            System.out.println("¡Perfecto! Disfruta escuchando y siente el ritmo.");
        }

        while (true) {
            System.out.println("\nMENÚ:");
            System.out.println("'pausar' - Pausar la música.");
            System.out.println("'repetir' - Comenzar la música desde el inicio.");
            System.out.println("'salir' - Salir de la aplicación.\n");
            
            String entrada = scanner.nextLine().trim().toLowerCase();

            switch (entrada) {
                case "pausar":
                    hiloMusica.pausarMusica();
                    System.out.println("Música pausada. ¿Necesitas un descanso? ¡No hay problema!");
                    break;
                case "repetir":
                    System.out.println("¡Prepárate para el beat! Reproduciendo desde el comienzo.");
                    hiloMusica.reiniciarMusica();
                    break;
                case "salir":
                    hiloMusica.detenerMusica();
                    System.out.println("Gracias por usar la aplicación. ¡Espero que hayas disfrutado la música! ¡Hasta pronto!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no reconocida. Vamos, no es tan difícil, ¡inténtalo de nuevo!");
            }
        }
    }
}

