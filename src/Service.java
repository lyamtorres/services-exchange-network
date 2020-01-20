

public class Service {

    private String name;
    private int costPerHour;
    
    public Service(String name, int costPerHour){
        this.name = name;
        this.costPerHour = costPerHour;
    }

    public String getName() {
        return this.name;
    }

    public int getCostPerHour() {
        return this.costPerHour;
    }

    public String toString(){
        return "[[name: " + name + "] " + "[costPerHour: " + costPerHour + "]]";
    }
}
