public class CurseCard extends Card{
    private int credits;
    private int difficulty;

    public CurseCard(int id, String name, int energyCost, String description, int credits, int difficulty){
        super(id, name, energyCost, description);
        this.credits = credits;
        this.difficulty=difficulty;
    }
    @Override 
    public String playCard(Player player, Board board){
        int wins = credits + board.consumMulti();
        player.winCredits(wins);
        String msg = "Apruebas" + getName() + ": +" + wins + "creditos: ";
        if(difficulty >8){
            player.energyLost(1);
            msg += "(Dificultad alta: -1 energia extra";
        }
        return msg;
    }
    @Override  
    public String getType(){return "Curso";}
    public int getCredits(){return credits;}
    public int getDifficulty(){return difficulty;}


    @Override 
    public String toString(){
        return super.toString() + "|Creditos" + credits + "|Dificultad: " + difficulty;
    }
    
}
