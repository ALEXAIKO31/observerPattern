package mx.iteso.observer;

import mx.iteso.observer.impl.MovileAppDisplay;
import mx.iteso.observer.impl.ScoresData;
import mx.iteso.observer.impl.StoreMonitorDisplay;

public class NewsStation {
    public static void main( String[] args ){
        ScoresData scoresData;
        scoresData = new ScoresData();

        MovileAppDisplay movileAppDisplay = new MovileAppDisplay(scoresData);

        StoreMonitorDisplay storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
        scoresData.newScorer(new Scorer("Alex",31,"Forward","Intel"));
        scoresData.setScore("Tacit Knowledge", "Intel", 8, 1);
        movileAppDisplay.unregister();
        scoresData.newScorer(new Scorer("Alex", 31, "Forward", "Chivas"));
        scoresData.newScorer(new Scorer("Alexis", 21, "Forward", "Chivas"));
        scoresData.setScore("Chivas", "Queretaro", 2, 1);
        scoresData.setScore("La Ganga", "Muebles America", 0, 0);
    }
}
