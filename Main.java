public class Main {
    public static void main(String[] args){
        new JuegoController(new Mallet(), new Player("Jugador numero 1", 5),new Board(),new ConsoleView()).start();
    }
    
}
