package mx.iteso.observer.impl;

import mx.iteso.observer.Observer;
import mx.iteso.observer.Scorer;
import mx.iteso.observer.Subject;

import java.util.ArrayList;

public class ScoresData implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<Scorer> scorers;
    private int homeGoals;
    private int awayGoals;
    private String homeTeam;
    private String awayTeam;


    public ScoresData(){
        observers = new ArrayList<Observer>();
        scorers = new ArrayList<Scorer>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observers.indexOf(observer));
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.homeTeam, this.awayTeam, this.homeGoals, this.awayGoals,this.scorers);
        }
        scorers.clear();
    }

    public void newScore(){
        notifyObservers();
    }

    public void newScorer(Scorer scorer){
        scorers.add(scorer);

    }
    public void setScore( String homeTeam, String awayTeam, int homeGoals, int awayGoals){
        this.homeTeam = homeTeam;
        this.awayTeam =  awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        newScore();
    }
}
