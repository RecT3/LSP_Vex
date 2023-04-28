package org.howard.edu.lsp.finals.problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class SongsDatabaseTest {
	
	@Test
	@DisplayName("Test case for adding songs")
    public void testaddSongs() {
        SongsDatabase db = new SongsDatabase();
        SongsDatabase db2 = new SongsDatabase();
        db.addSong("Rap", "The Bigger Picture");
        db.addSong("R&B", "Appletree");
        db.addSong("Rap", "Crack Sandwich");
        db.addSong("R&B" , "Let It Burn");
        
        db.addSong("Rap", "KOD");
        db.addSong("Rap", "In Da Club");
        
        Set<String> rap_songs = db.getSongs("Rap");
        Set<String> rb_songs = db.getSongs("R&B");
        
        assertTrue(rap_songs.contains("The Bigger Picture"));
        assertTrue(rb_songs.contains("Let It Burn"));
        assertTrue(rap_songs.contains("Crack Sandwich"));
        assertTrue(rb_songs.contains("Appletree"));
        
        assertFalse(rap_songs.contains("Appletree"));
        assertFalse(rb_songs.contains("Crack Sandwich"));
        
        assertEquals(db.getSongs("Rap").size(), db2.getSongs("Rap").size());
    }
	
	@Test
	@DisplayName("Test case for getting the songs")
	public void testGetSongs() {
		SongsDatabase db = new SongsDatabase();
		db.addSong("Soul", "Ain't Too Proud To Beg");
		db.addSong("Soul", "Lost Ones");
		db.addSong("Rap", "Low Down");
		db.addSong("Rap", "RAPSTAR");
		
		assertEquals(2, db.getSongs("Rap").size());
		assertEquals(2, db.getSongs("Soul").size());
	}
	
	@Test
	@DisplayName("Test case for getting the genre of a song")
	public void testGetGenre() {
		SongsDatabase db = new SongsDatabase();
		db.addSong("R&B", "Amphetamine");
		db.addSong("R&B", "Pick Up Your Feelings");
		db.addSong("Soul", "If Only You Knew");
		db.addSong("Soul", "Heartbreak Hotel");
				
		assertEquals("Soul", db.getGenre("If Only You Knew"));
		assertEquals("R&B", db.getGenre("Amphetamine"));
		assertEquals("That song is not in the Database.", db.getGenre("Nothing Even Matters"));
	}

}
