import java.util.ArrayList;

public class Chicken extends Creature {
    public Chicken(Graph.Node l){
        super("Chicken","Wanders randomly across the map",l);
    }

    protected ArrayList<Graph.Node> getPossibleRooms() {
        return getCurrentRoom().getArrayList();
    }
}
