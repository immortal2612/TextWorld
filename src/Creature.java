import java.util.ArrayList;

public abstract class Creature {
    private String name, description;
    private Graph.Node currentRoom;

    public Creature(String n, String d, Graph.Node l){
        name = n;
        description = d;
        currentRoom = l;
    }

    public void moveToRoom(){
        ArrayList<Graph.Node> nodes = getPossibleRooms();
        int val = (int)Math.random()*nodes.size();
        Graph.Node node = nodes.get(val);
        setCurrentRoom(node);
    }

    protected abstract ArrayList<Graph.Node> getPossibleRooms();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    protected void act(){
        moveToRoom();
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }
}
