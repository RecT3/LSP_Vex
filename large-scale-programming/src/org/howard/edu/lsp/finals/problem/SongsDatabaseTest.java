package org.howard.edu.lsp.finals.problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class SongsDatabaseTest {
	
	@Test
    public void testaddSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "The Bigger Picture");
        db.addSong("R&B", "Appletree");
        db.addSong("Rap", "Crack Sandwich");
        db.addSong("R&B" , "Let It Burn");
        
        Set<String> rap_songs = db.getSongs("Rap");
        Set<String> rb_songs = db.getSongs("R&B");
        
        assertTrue(rap_songs.contains("The Bigger Picture"));
        assertTrue(rb_songs.contains("Let It Burn"));
        assertFalse(rap_songs.contains("Appletree"));
        assertFalse(rb_songs.contains("Crack Sandwich"));
    }
	
	@Test
	public void testGetSongs() {
		SongsDatabase db = new SongsDatabase();
		db.addSong("Soul", "Ain't Too Proud To Beg");
		db.addSong("Soul", "Lost Ones");
		db.addSong("Rap", "Low Down");
		db.addSong("Rap", "RAPSTAR");
		
		Set<String> soul_songs = db.getSongs("Soul");
		assertTrue(soul_songs.contains("Lost Ones"));
		assertTrue(soul_songs.contains("Ain't Too Proud To Beg"));
	}
	
	@Test
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
