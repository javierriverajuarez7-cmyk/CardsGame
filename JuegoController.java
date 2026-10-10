
public class JuegoController {
    private static final int M_Creditos = 20;
    private final Mallet mallet;
    private final Player player;
    private final Board board;
    private final ConsoleView view;

    public JuegoController(Mallet mallet, Player player,Board board, ConsoleView view){
        this.mallet = mallet;
        this.player = player;
        this.board = board;
        this.view = view;

    }
    public void start(){
        mallet.chargeInicial(12);
        view.shown("El catálago a sido cargado con" + mallet.getCards().size() + "..cartas:");
        int op;
        do{
            view.principalMenu();
            op = view.leerEntero("Opción: ");
            switch (op){
                case 1 -> view.shownCards(mallet.getCards());
                case 2 -> findbyID();
                case 3 -> view.shownCards(mallet.find(view.leerTexto("Nombre :")));
                case 4 -> {mallet.orderwithCost();view.shown("Mazo a sido ordenado por costo"); view.shownCards(mallet.getCards());}
                case 5 -> play();
                case 0 -> view.shown("Hasta la proxima partidas");
                default -> view.shown("Opcion no valida.");
            }

        } while(op !=0);
    }
    private void findbyID(){
        Card c = mallet.find(view.leerEntero("ID:")); 
        view.shown(c == null ? "No existe carta." : c.toString());

    }
    private void play(){
        int op;
        do{
            view.shown("\n" + board + "\n" + player);
            if(player.getCredits() >= M_Creditos){
                view.shown("Ganaste, la meta de creditos: " + M_Creditos);
                return;
            }
            view.menuTurn();
            op = view.leerEntero("Opciones :");
            switch (op){
                case 1 -> useCard();
                case 2 -> takeCard();
                case 3 -> passTurn();
                case 0 -> {}
                default -> view.shown("Opción invalida.");
            }
        }while(op!=0);
    }
    private void useCard(){
        if(player.getHand().isEmpty()){view.shown("Tu mano se encuentra vacia, porfavor toma una carta.");return;}
        for(int id : player.getHand()) view.shown(mallet.find(id).toString());
        int id = view.leerEntero("Asigne ID de la carta a usar");
        if(!player.hadinMallet(id)){view.shown("Esa carta no esta actualmente en tu mano.");return;}
        Card c = mallet.find(id);
        if(!player.canplay(c)){view.shown("Ya puedes jugar con tu mazo.");return;}
        player.energyLow(c);
        player.quitMallet(id);
        view.shown(c.playCard(player, board));

    }
    private void takeCard(){
        Card c = mallet.getAleatory();
        player.addtoHand(c.getID());
        view.shown("Tomaste :" + c);
    }
    private void passTurn(){
        board.nextRound();
        player.energyUp(2);
        view.shown("Turno pasado. Gano 2 de energia");
    }

    
}
