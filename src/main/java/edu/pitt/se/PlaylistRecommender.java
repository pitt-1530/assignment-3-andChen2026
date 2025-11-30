package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.size() == 0) 
            throw new UnsupportedOperationException("List null or empty");

        int avgBPM = bpms.stream().mapToInt(Integer::intValue).sum() / bpms.size();

        if (avgBPM >= 140) return "HIGH";
        else if (avgBPM >= 100) return "MEDIUM";
        else return "LOW";
    }

    public static boolean isValidTrackTitle(String title) {
        for (char c : title.toCharArray())
        {
            int ascii = (int) c;
            if (!((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122) || ascii == 32))
                return false;
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb > 100) return 100;
        else if (volumeDb < 0) return 0;
        else return volumeDb;
    }
}
