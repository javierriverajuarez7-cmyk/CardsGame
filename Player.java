import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String name;
    private int energy;
    private int credits;

    private final List<Integer> hand = new ArrayList<>();


    public Player(String name, int energyPrincipal){
        this.name = name;
        this.energy = energyPrincipal;

    }
    public boolean canplay(Card c){return energy >= c.getenergyCost();}
    public void energyLow(Card c){energy -= c.getenergyCost();}
    public void energyUp(int n){energy +=n;}
    public void energyLost(int n){energy = Math.max(0, energy - n);}
    public void winCredits(int n){credits +=n;}
    public void addtoHand(int idCard){hand.add(idCard);}
    public boolean quitMallet(int idCard){return hand.remove(Integer.valueOf(idCard));}
    public boolean hadinMallet(int idCard){return hand.contains(idCard);}
    public List<Integer>getHand(){return Collections.unmodifiableList(hand);}
    public String getName(){return name;}
    public int getEnergy(){return energy;}
    public int getCredits(){return credits;}

    @Override
    public String toString(){
        return name + "|Energia:" + energy + "|Creditos:" + credits +"|Hand: " + hand; 
    }

    
}
