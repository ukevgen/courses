package com.courses.spalah;

import java.util.List;

import com.courses.spalah.reader.NaiveReader;
import com.courses.spalah.track.Track;

/**
 * @author Ievgen Tararaka
 */
public class MusicPlayerApp {
    public static void main(String[] args) {
        naiveReader();
    }

    public static void naiveReader() {
        NaiveReader naiveReader = new NaiveReader();
        List<Track> tracks = naiveReader.getListOfAllTracks();
        System.out.println("Tracks: " + tracks);

        for (Track track : tracks) {
            System.out.println("Playing track " + track.getName() + " for " + track.getDurationInSeconds() + " seconds");
        }
    }
}
