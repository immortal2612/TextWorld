import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, Node> nodes = new HashMap<String, Node>();
    private ArrayList<Creature> creatures = new ArrayList<>();

    public Graph() {
    }

    public void addNode(String name) {
        Node a = new Node(name);
        nodes.put(name, a);
    }

    public void addUndirectedEdge(String name1, String name2) {
        if(!(this.getNode(name1).getArrayList().contains(this.getNode(name2)))){
            this.addDirectedEdge(name1, name2);
            this.addDirectedEdge(name2, name1);
        }
    }

    public void addDirectedEdge(String name1, String name2) {
        Node node1 = this.getNode(name1);
        Node node2 = this.getNode(name2);

        node1.addNeighbor(node2);
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public Creature getCreature(int a){
        return creatures.get(a);
    }

    public void addCreature(Creature c){
        creatures.add(c);
    }
    public ArrayList<Node> getArrayList(){
        ArrayList<String> keys = new ArrayList<>();
        for(String name: nodes.keySet()){
            keys.add(name);
        }

        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < keys.size(); i++){
            list.add(nodes.get(keys.get(i)));
        }

        return list;
    }

    public void creaturesTurn(){
        for(Creature a: creatures){
            a.act();
            System.out.println(a.getName() + " in the " + a.getCurrentRoom().getName());
        }
    }

    public void getCreaturesInCurrent(Node a){
        ArrayList<Creature> c = new ArrayList<>();

        for(Creature x: creatures){
            if(x.getCurrentRoom() == a){
                c.add(x);
            }
        }
        if(c.size() == 0){
            System.out.println("No creatures in current room.");
        }
        for(Creature y: c){
            System.out.println(y.getName());
        }
    }

    public class Node {
        private String name;
        private HashMap<String, Node> neighbors = new HashMap<String, Node>();
        private HashMap<String, Item> items = new HashMap<>();

        private Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Node a) {
            neighbors.put(a.getName(), a);
        }

        public String getNeighborNames() {
            String returnVal = "";
            for(String name : neighbors.keySet()){
                returnVal += name;
                returnVal += " ";
            }

            if(returnVal.equals("")){
                return "No Neighbors";
            }
            return returnVal;
        }

        public Node getNeighbor(String n) {
            return neighbors.get(n);
        }

        public String getItemNames() {
            String returnVal = "";
            for(String name : items.keySet()){
                returnVal += name;
                returnVal += " ";
            }

            if(returnVal.equals("")){
                return "No Items";
            }
            return returnVal;
        }

        public Item removeAndReturn(String key){
            Item i = items.get(key);
            items.remove(key);

            return i;
        }

        public void addItem(Item a){
            items.put(a.getName(), a);
        }

        public ArrayList<Node> getArrayList(){
            ArrayList<String> keys = new ArrayList<>();
            for(String name: neighbors.keySet()){
                keys.add(name);
            }

            ArrayList<Node> near = new ArrayList<>();
            for(int i = 0; i < keys.size(); i++){
                near.add(neighbors.get(keys.get(i)));
            }

            return near;
        }
    }
}
