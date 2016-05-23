package com.courses.spalah.reader;

import java.util.List;

import com.courses.spalah.track.Track;

/**
 * @author Ievgen Tararaka
 */
public interface TrackReader {
    Track getNext();

    List<Track> getAll();
}
