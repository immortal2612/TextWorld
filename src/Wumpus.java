    import java.util.ArrayList;

    public class Wumpus extends Creature{
        Player player;
        public Wumpus(Graph.Node l, Player p){
            super("Wumpus", "Wanders around aimlessly but will run away if you get too close", l);
            player = p;
        }


        protected ArrayList<Graph.Node> getPossibleRooms() {
            ArrayList<Graph.Node> neighbors = getCurrentRoom().getArrayList();

            String playerRoom = player.getCurrent().getName();

            for(Graph.Node node: neighbors){
                if(node.getName().equals(playerRoom)){
                    neighbors.remove(node);
                }
            }

            return neighbors;
        }
    }
