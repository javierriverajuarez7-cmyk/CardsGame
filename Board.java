public class Board {
    private int round = 1;
    private int callsAcumulated;
    private int multi = 1;
    private String activeEvent = "Ninguno";

    public void nextRound(){round++;}
    public void addCalls(int n){callsAcumulated += n;}

    public int consumMulti(){
        int m = multi;
        multi = 1;
        activeEvent = "Ninguno";
        return m;
    }
    public void setMulti(int m){multi = Math.max(1,m);}
    public void setactiveEvent(String e){activeEvent = e;}
    public int getRound(){return round;}
    public int getAcumulatedCalls(){return callsAcumulated;}
    public String getactiveEvent(){return activeEvent;}

    @Override 
    public String toString(){
        return "Ronda" + round + "|Llamadas de atención" + callsAcumulated + "|Evento activo" + activeEvent;
    }

    
}
