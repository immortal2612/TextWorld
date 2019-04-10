import java.util.ArrayList;

public class Popstar extends Creature {
    Player player;
    public Popstar(Graph.Node l, Player p){
        super("Popstar", "Wanders around aimlessly until it catches your scent, then it will start hunting you", l);
        player = p;
    }

    protected ArrayList<Graph.Node> getPossibleRooms() {
        ArrayList<Graph.Node> possibleRooms = new ArrayList<>();

        if(getCurrentRoom() == player.getCurrent()){
            System.out.println("The Popstar caught you!");
        }


        for(Graph.Node a: getCurrentRoom().getArrayList()){
            if(a == player.getCurrent()){
                possibleRooms.add(a);
            }
        }

        if(possibleRooms.size() == 1){
            System.out.println("The Popstar caught you!");
            return possibleRooms;
        }

        for(Graph.Node a: getCurrentRoom().getArrayList()){
            for(Graph.Node b: a.getArrayList()){
                if(b == player.getCurrent()){
                    possibleRooms.add(a);
                }
            }
        }

        if(possibleRooms.size() == 1){
            System.out.println("Popstar is in an adjacent room!");
            return possibleRooms;
        } else {
            return getCurrentRoom().getArrayList();
        }

    }
}
