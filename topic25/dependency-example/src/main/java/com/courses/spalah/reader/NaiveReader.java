package com.courses.spalah.reader;

import java.util.ArrayList;
import java.util.List;

import com.courses.spalah.track.Track;

/**
 * @author Ievgen Tararaka
 */
public class NaiveReader {
    private static final List<Track> AVAILABLE_TRACKS = new ArrayList<>();

    static {
        AVAILABLE_TRACKS.add(new Track("Don't Let Me Down", 600));
        AVAILABLE_TRACKS.add(new Track("Don't Mind", 420));
        AVAILABLE_TRACKS.add(new Track("Panda", 355));
        AVAILABLE_TRACKS.add(new Track("Work From Home", 111));
    }

    private List<Track> currentTracks = new ArrayList<>();

    public NaiveReader() {
        currentTracks.addAll(AVAILABLE_TRACKS);
    }

    public List<Track> getListOfAllTracks() {
        return currentTracks;
    }
}
