public class MiHilo extends Thread {

    String nombre;

    public MiHilo(String nombre) {
        super();
        this.nombre = nombre;
        this.setName(nombre); // Asegura que el nombre del hilo sea el correcto
    }

    public static void main(String[] args) {
        // Crear instancias de hilos con nombres "1", "2" y "3"
        MiHilo hiloUno = new MiHilo("1");
        MiHilo hiloDos = new MiHilo("2");
        MiHilo hiloTres = new MiHilo("3");

        // Establecer prioridades
        hiloUno.setPriority(2);
        hiloDos.setPriority(3);
        hiloTres.setPriority(1);

        // Iniciar los hilos
        hiloUno.start();
        hiloDos.start();
        hiloTres.start();
    }

    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println("El hilo " + Thread.currentThread().getName() + " está en ejecución ");
            
            // Lanzar RuntimeException si es el hilo "2" y está en la iteración 9
            if (this.getName().equals("2") && i == 9) {
                throw new RuntimeException("Excepción provocada intencionalmente en el hilo " + Thread.currentThread().getName());
            }
            
            try {
                Thread.sleep(500); // Pausa de 500 milisegundos entre iteraciones
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
