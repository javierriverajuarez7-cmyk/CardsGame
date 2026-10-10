
import java.util.List;
import java.util.Scanner;


public class ConsoleView {
    private final Scanner sc = new Scanner(System.in);
    public void shown(String text){
        System.out.println(text);
    }
    public void shownCards(List<? extends Card>cards){
        if(cards.isEmpty()) shown("Sin ningun resultado");
        for(Card c: cards) shown(c.toString());
    }
    public void principalMenu(){
        shown("\n ====Card Battle====\n1. Listar Cartas\n2. Buscar carta por ID\n" + "3. Buscar carta por nombre\n4.Ordenar mazo por energia(costo)\n" + "5 Jugar por turnos\n0 Salir");

    }
    public void menuTurn(){
        shown("\n ----Tu turno--- \n1. Usar carta\n2. Tomar carta\n3.Pasar el turno\n0.Volver al menu");
    }
    public int leerEntero(String prompt){
        while(true){
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try{
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                shown("Ingrese Numero Valido.");
            }
        }
    }
    public String leerTexto(String prompt){
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    
}
