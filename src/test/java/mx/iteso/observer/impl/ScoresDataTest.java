package mx.iteso.observer.impl;

import mx.iteso.observer.Observer;
import mx.iteso.observer.Scorer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class ScoresDataTest {
    ScoresData scoresData;
    Observer observer;
    Scorer scorer;
    private ArrayList<Scorer> scorers;

    @Before
    public void setUp() {
        scoresData = new ScoresData();
        observer = mock(Observer.class);
        scorer = mock(Scorer.class);
        scorers = new ArrayList<Scorer>();
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testRegisterAndRemoveObserverException() {
        scoresData.registerObserver(observer);
        scoresData.removeObserver(observer);
        scoresData.removeObserver(observer);
    }

    @Test
    public void testSetScore() {
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        scoresData.setScore("testTeam", "testTeam2", 1, 0);
        verify(observer, times(2)).update("testTeam", "testTeam2", 1, 0, scorers);
    }

    @Test
    public void testRemoveObserver(){
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        scoresData.removeObserver(observer);
        scoresData.setScore("testTeam", "testTeam2", 1, 0);
        verify(observer, times(1)).update("testTeam", "testTeam2", 1, 0, scorers);
    }


}
