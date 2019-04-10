import java.util.HashMap;

public class Player {
    private String name;
    private HashMap<String, Item> inventory = new HashMap<>();
    private Graph.Node current;

    public Player(String n, Graph.Node g){
        name = n;
        current = g;
    }

    public void addItem(Item a){
        inventory.put(a.getName(), a);
    }

    public void moveToInventory(String key){
        Item a = current.removeAndReturn(key);
        inventory.put(key, a);
    }

    public void removeFromInventory(String key){
        Item a = removeAndReplace(key);
        current.addItem(a);
    }

    private Item removeAndReplace(String key){
        Item a = inventory.get(key);
        inventory.remove(key);

        return a;
    }

    private void removeItem(String key){
        inventory.remove(key);
    }

    public void moveRoom(Graph.Node a){
        current = a;
    }

    public Graph.Node getCurrent(){
        return current;
    }

    public void setCurrent(Graph.Node a){
        current = a;
    }

    public String getNeighbors(){
        return current.getNeighborNames();
    }

    public String getName(){
        return name;
    }

    public String getInventory(){
        String returnVal = "";

        for(String a: inventory.keySet()){
            returnVal += a;
            returnVal += " ";
        }

        return returnVal;
    }


}
