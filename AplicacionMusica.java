public class AplicacionMusica {
    public static void main(String[] args) {
        ReproductorMusica hiloMusica = new ReproductorMusica();
        InteraccionUsuario hiloInteraccion = new InteraccionUsuario(hiloMusica);

        hiloMusica.start();
        hiloInteraccion.start();

        try {
            hiloMusica.join();
            hiloInteraccion.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

