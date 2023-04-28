package org.howard.edu.lsp.finals.problem;

import java.util.*;

/**
 * making our own song database
 * 
 * @author Ryan
 *
 */
public class SongsDatabase {
	private HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
	
	/**
	 * Add a song title to a genre 
	 * or create a new genre starting with that song
	 * 
	 * @param genre, title
	 */
    public void addSong(String genre, String title) {
        HashSet<String> songSet = map.get(genre);
        if (songSet == null) {
            songSet = new HashSet<String>();
            map.put(genre, songSet);
        }
        songSet.add(title);
    }

    /**
     * Return the Set that contains all songs for a genre
     * 
     * @param genre
     * @return the set of that genre
     */
    public Set<String> getSongs(String genre) {
        HashSet<String> songSet = map.get(genre);
        if (songSet == null) {
            songSet = new HashSet<String>();
        }
        return songSet;
    }

    /**
     * Return genre, i.e., jazz, given a song title 
     * 
     * @param songTitle
     * @return the genre associated with that song
     */
    public String getGenre(String title) {
        for (String genre : map.keySet()) {
            HashSet<String> songSet = map.get(genre);
            if (songSet.contains(title)) {
                return genre;
            }
        }
        return "That song is not in the Database.";
    }
}
