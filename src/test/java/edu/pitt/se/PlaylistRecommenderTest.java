package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
public class PlaylistRecommenderTest {

    @Test
    public void emptybpms() {
        // Should fail since list is null
        ArrayList<Integer> bpms = null;
        assertThrows(UnsupportedOperationException.class, () -> PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void highbpm()
    {
        // Pass in a list with high bpms
        ArrayList<Integer> bpms = new ArrayList<>();
        bpms.add(155);
        bpms.add(170);
        bpms.add(180);
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void lowbpm()
    {
        // Pass in a list with low bpms
        ArrayList<Integer> bpms = new ArrayList<>();
        bpms.add(80);
        bpms.add(99);
        bpms.add(75);
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void mediumbpm()
    {
        // Pass in a list with high bpms
        ArrayList<Integer> bpms = new ArrayList<>();
        bpms.add(110);
        bpms.add(130);
        bpms.add(125);
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void validTrackTitle()
    {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Fireflies"));
    }

    @Test
    public void invalidTrackTitle()
    {
        assertFalse(PlaylistRecommender.isValidTrackTitle("120Fireflies"));
    }

    @Test
    public void lowerRange()
    {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-100));
    }

    @Test
    public void inRange()
    {
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }

    @Test
    public void upperRange()
    {
        assertEquals(100, PlaylistRecommender.normalizeVolume(200));
    }
}
