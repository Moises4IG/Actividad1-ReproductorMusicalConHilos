import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class ReproductorMusica extends Thread {
    private volatile boolean reproduciendo = true;
    private Player reproductor;
    private volatile boolean pausado = false;
    private String rutaCancion = "David Guetta Feat Kid Cudi - Memories.mp3";

    public synchronized void pausarMusica() {
        pausado = true;
        if (reproductor != null) {
            reproductor.close();
            reproductor = null;
        }
    }

    public synchronized void reiniciarMusica() {
        if (reproductor != null) {
            reproductor.close();
            reproductor = null;
        }
        pausado = false;
        notifyAll();
    }

    public synchronized void detenerMusica() {
    reproduciendo = false;
    pausado = false;
    if (reproductor != null) {
        reproductor.close();
        reproductor = null;
    }
    notifyAll();
}

    @Override
    public void run() {
        try {
            while (reproduciendo) {
                synchronized (this) {
                    while (pausado) {
                        wait();
                    }
                }
                try (FileInputStream entradaArchivo = new FileInputStream(rutaCancion)) {
                    reproductor = new Player(entradaArchivo);
                    reproductor.play();
                }
            }
            if (reproductor != null) {
                reproductor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
