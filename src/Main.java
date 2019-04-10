import java.util.Scanner;

public class Main {
    static Graph g = new Graph();
    static Player p;
    public static void main(String[] args) {
        g.addNode("Hall");
        g.addNode("Bathroom");
        g.addNode("Bedroom");
        g.addNode("Closet");
        g.addNode("Family Room");
        g.addNode("Office");
        g.addNode("Kitchen");

        g.addUndirectedEdge("Hall", "Bedroom");
        g.addUndirectedEdge("Hall", "Family Room");
        g.addUndirectedEdge("Hall", "Kitchen");
        g.addUndirectedEdge("Bedroom", "Bathroom");
        g.addUndirectedEdge("Office", "Bedroom");
        g.addUndirectedEdge("Family Room", "Kitchen");
        g.addUndirectedEdge("Closet", "Bedroom");

        String response = "";
        Scanner s = new Scanner(System.in);

        System.out.println("Give your name");
        response = s.nextLine();
        String playerName = response;
        Graph.Node node = g.getNode("Family Room");
        p = new Player(playerName, node);

        g.addCreature(new Chicken(g.getNode("Hall")));
        g.addCreature(new Popstar(g.getNode("Kitchen"), p));
        do{
            System.out.println("You are in the " + p.getCurrent().getName() + ".");
            System.out.println("What do you want to do?");
            response = s.nextLine();

            if(response.contains("go")){
                Go(response, p);
            }else if (response.contains("look")){
                System.out.println(p.getNeighbors());
            }else if(response.contains("add")){
                add(response,p);
            }else if(response.contains("Items")) {
                System.out.println(p.getCurrent().getItemNames());
            } else if(response.contains("Pickup")) {
                Pickup(response, p);
            } else if(response.contains("Drop")){
                Drop(response, p);
            }else if(response.contains("help")){
                System.out.println("Commands:");
                System.out.println("Go <roomname>");
                System.out.println("Look");
                System.out.println("Items");
                System.out.println("Pickup <Item>");
                System.out.println("Drop <Item>");
                System.out.println("add <roomname>(Description)");
                System.out.println("quit");
            } else{
                System.out.println("Not a valid command. Type \"help\" for a list of commands.");
            }
            if(!response.equals("help")) {
                System.out.println("Creatures turn.");
                g.creaturesTurn();
            }
        }while (response!="quit");


    }


    public static void Go(String response, Player p){
        int start = 0;
        int end = 0;
        for(int i = 0; i < response.length(); i++){
            if(response.substring(i, i+1).equals("<")){
                start = i + 1;
            }

            if(response.substring(i,i+1).equals(">")){
                end = i;
            }
        }

        p.moveRoom(g.getNode(response.substring(start,end)));
    }

    public static void add(String response, Player p){
        int start = 0;
        int end = 0;
        for(int i = 0; i < response.length(); i++){
            if(response.substring(i, i+1).equals("<")){
                start = i+1;
            }

            if(response.substring(i,i+1).equals(">")){
                end = i;
            }
        }

        String name = response.substring(start,end);

        g.addNode(name);
        g.addUndirectedEdge(p.getCurrent().getName(),name);
    }

    public static void Pickup(String response, Player p){
        int start = 0;
        int end = 0;
        for (int i = 0; i < response.length(); i++) {
            if (response.substring(i, i + 1).equals("<")) {
                start = i + 1;
            }

            if (response.substring(i, i + 1).equals(">")) {
                end = i;
            }
        }

        String ItemName = response.substring(start, end);
        p.moveToInventory(ItemName);

        System.out.println("You picked up the " + ItemName);
    }

    public static void Drop(String response, Player p){
        int start = 0;
        int end = 0;
        for(int i = 0; i < response.length(); i++){
            if(response.substring(i, i+1).equals("<")){
                start = i+1;
            }

            if(response.substring(i,i+1).equals(">")){
                end = i;
            }
        }

        String itemName = response.substring(start, end);
        p.removeFromInventory(itemName);

        System.out.println("You dropped the " + itemName);
    }


}
