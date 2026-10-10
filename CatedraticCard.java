public class CatedraticCard extends Card {
    private String departament;
    private int attentionCalls;
    private int attentionTime;

    public CatedraticCard(int id, String name, int energyCost, String description, String departament, int attentionCalls, int attentionTime){
        super(id,name,energyCost,description);
        this.departament = departament;
        this.attentionCalls = attentionCalls;
        this.attentionTime  = attentionTime;
    }
    @Override 
    public String playCard(Player player, Board board){
        player.energyUp(attentionTime);
        board.addCalls(attentionCalls);
        return getName() + "te esta atendiendo: " + attentionTime + "energia +" + attentionCalls + "llamadas de atencion en el tablero";
    }
    @Override 
    public String getType(){return "Catedratico:";}

    public String getDepartament(){return departament;}
    public int getattentionCalls(){return attentionCalls;}
    public int getattentionTime(){return attentionTime;}
    @Override 
    public String toString(){
        return super.toString() + "Depto: "+ departament +"Llamadas: "+ attentionCalls + "Tiempo de atención: " + attentionTime;
    }
    
}
