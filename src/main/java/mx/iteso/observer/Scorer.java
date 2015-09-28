package mx.iteso.observer;

/**
 * Created by is693264 on 24/09/2015.
 */
public class Scorer implements Displayable {

    private String name;
    private String team;
    private  int number;
    private String position;

    public Scorer(String name,int number,String position,String team){
        this.name=name;
        this.number=number;
        this.position=position;
        this.team=team;
    }

    public void display(){
        System.out.println("Name: "+name+" Number: "+number+" Position: "+position+" Team: "+team);
    }
}
