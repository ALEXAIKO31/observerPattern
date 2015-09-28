package mx.iteso.observer.impl;

import mx.iteso.observer.Scorer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StoreMonitorDisplayTest {
    private StoreMonitorDisplay storeMonitorDisplay;
    private ScoresData scoresData;
    private ArrayList<Scorer> scorers;
    Scorer scorer;

    @Before
    public void setUp() {
        scoresData = mock(ScoresData.class);
        storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
        scorer = mock(Scorer.class);
        scorers = new ArrayList<Scorer>();
    }

    @Test
    public void testUpdate() {
        storeMonitorDisplay.update("homeTeam", "awayTeam", 1, 0, scorers);
    }

    @Test
    public void testScore() {
        storeMonitorDisplay.update("homeTeam", "awayTeam", 1, 0,scorers);
        storeMonitorDisplay.unregister();
    }

    @Test
    public void testNewScorerDisplay(){
        scorers.add(scorer);
        scorers.add(scorer);
        scorers.add(scorer);
        storeMonitorDisplay.update("testTeam", "testTeam2", 1, 0,scorers);
        storeMonitorDisplay.display();
        verify(scorer, times(3)).display();
    }
}
