public abstract class Card implements Comparable<Card> {
    private final int id;
    private String name;
    private int energyCost;
    private String description;

    protected Card(int id, String name, int energyCost, String description){
        this.id=id;
        this.name = name;
        this.energyCost = energyCost;
        this.description = description;
    }
    public abstract String playCard(Player player, Board board);
    public abstract String getType();

    public int getID(){return id;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public int getenergyCost(){return energyCost;}
    public void setenergyCost(int energyCost){this.energyCost = energyCost;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    @Override 
    public int compareTo(Card other){
        return Integer.compare(energyCost, other.energyCost);
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Card)) return false;
        return id ==((Card) o).id;

    }
    @Override 
    public int hashCode(){return Integer.hashCode(id);}



    
}
