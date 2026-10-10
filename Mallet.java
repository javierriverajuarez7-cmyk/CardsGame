import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;




public class Mallet {
    private final List<Card> cards = new ArrayList<>();
    private final Random rnd = new Random();

    private static final String [] CATEDRATICS = {"Dr. Juan" , "Licenciada alicia","Ingeniero Miles","Doctora Torres","Ingeniero Montero"};
    private static final String [] DEPTOS = {"Computación","Mátematica","Física","Ingenieria"};
    private static final String [] CURSOS = {" Calculo 2","Algebra Vectorial","Poo","Base de datos" , "Fisica 2", "Biologia"};
    private static final String [] EVENTS = {"Parciales","Feria Cientifica","Hackathon","Dia de la independencia"};

    public void chargeInicial( int n){
        int total = Math.max(10, n);
        for(int id = 1; id <= total; id++){
            switch(rnd.nextInt(3)){
                case 0 -> cards.add(new CatedraticCard(id, CATEDRATICS[rnd.nextInt(CATEDRATICS.length)],
                1 + rnd.nextInt(4), "Profesor del campus", DEPTOS[rnd.nextInt(DEPTOS.length)],
                1 + rnd.nextInt(3), 1 + rnd.nextInt(4)));
                case 1 -> cards.add(new CurseCard(id, CURSOS[rnd.nextInt(CURSOS.length)],
                1 + rnd.nextInt(5), "Materia del pensum", 1 + rnd.nextInt(5), 1 + rnd.nextInt(2)));
                default -> cards.add(new EventCard(id,EVENTS[rnd.nextInt(EVENTS.length)],
                rnd.nextInt(3), "Situación que afecta el tablero", rnd.nextInt(5) -2, 1 + rnd.nextInt(2)));
            }
        }
    }
    public List<Card> getCards(){return Collections.unmodifiableList(cards);}
    public Card find(int id){
        for(Card c : cards) if(c.getID() == id) return c;
        return null;
    }
    public List<Card> find(String name){
        List<Card> res = new ArrayList<>();
        for(Card c: cards)
            if(c.getName().toLowerCase().contains(name.toLowerCase())) res.add(c);
        return res;
    }
    public void orderwithCost(){Collections.sort(cards);}
    public Card getAleatory(){return cards.get(rnd.nextInt(cards.size()));}
    
}
