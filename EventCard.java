public class EventCard extends Card{
    private int energyDelta;
    private int creditsMulty;

    public EventCard(int id, String name, int energyCost, String description, int energyDelta, int creditsMulty){
        super(id, name, energyCost, description);
        this.energyDelta = energyDelta;
        this.creditsMulty = creditsMulty;
    }
    @Override 
    public String playCard(Player player, Board board){
        if(energyDelta >= 0) player.energyUp(energyDelta);
        else player.energyLost(-energyDelta);
        board.setMulti(creditsMulty);
        board.setactiveEvent(getName());
        return "Evento " + getName() + ":energía " + (energyDelta >= 0 ? "+" : "") + energyDelta + ",el proximo curso de x" + creditsMulty + "créditos.";
    }
    @Override 
    public String getType(){return "Evento de Campus";}
    public int getdeltaEnergy(){return energyDelta;}
    public int getmultyCredits(){return creditsMulty;}

    @Override 
    public String toString(){
        return super.toString() + "Energia delta : " + energyDelta + "| x Creditos :" + creditsMulty;
    }
    
}
