/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LJ
 */
public class PlaylistTest {
    private static Playlist instance;
    
    public PlaylistTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Playlist();
        Song song1 = new Song("111", "We Are Young", "Janelle Monae", 252);
        Song song2 = new Song("222", "That's the Way It Is", "Celine Dion", 239);
        Song song3 = new Song("333", "Imagine", "John Lennon", 234);
        Song song4 = new Song("444", "My Heart Will Go On", "Celine Dion",275 );
        instance.enqueue(song1);
        instance.enqueue(song2); 
        instance.enqueue(song3);
        instance.enqueue(song4);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of enqueue method, of class Playlist.
     */
    @Test
    public void testEnqueue() {
        System.out.println("Test enqueue");
        Song e = new Song("555", "Memories", "Maroon 5",230 );
        instance.enqueue(e);
        String expected = new String("1\nSong ID: 111\nSong Name: We Are Young\nArtist Name: Janelle Monae\nSong Length (in seconds): 252\n" + 
                                     "2\nSong ID: 222\nSong Name: That's the Way It Is\nArtist Name: Celine Dion\nSong Length (in seconds): 239\n" +
                                     "3\nSong ID: 333\nSong Name: Imagine\nArtist Name: John Lennon\nSong Length (in seconds): 234\n" +
                                     "4\nSong ID: 444\nSong Name: My Heart Will Go On\nArtist Name: Celine Dion\nSong Length (in seconds): 275\n" +
                                     "5\nSong ID: 555\nSong Name: Memories\nArtist Name: Maroon 5\nSong Length (in seconds): 230\n");
        String actual = instance.toString();
        assertEquals(expected, actual);
    }


    /**
     * Test of dequeue method, of class Playlist.
     */
    @Test
    public void testDequeue() {
        System.out.println("Test dequeue");
        Song expReturn = new Song("111", "We Are Young", "Janelle Monae", 252);
        Song actReturn = instance.dequeue();
        String expected = new String("Song ID: 111\nSong Name: We Are Young\nArtist Name: Janelle Monae\nSong Length (in seconds): 252\n");
        String actual = actReturn.toString();
        assertEquals(expected, actual);
        
        String expectedString = new String("1\nSong ID: 222\nSong Name: That's the Way It Is\nArtist Name: Celine Dion\nSong Length (in seconds): 239\n" +
                                           "2\nSong ID: 333\nSong Name: Imagine\nArtist Name: John Lennon\nSong Length (in seconds): 234\n" +
                                           "3\nSong ID: 444\nSong Name: My Heart Will Go On\nArtist Name: Celine Dion\nSong Length (in seconds): 275\n");
        String actualString = instance.toString();
        assertEquals(expectedString, actualString);   
        
        instance.clear();
        String exp2 = "Playlist is empty\n";
        String act2 = instance.toString();
        assertEquals(exp2, act2);
    }


    /**
     * Test of toString method, of class Playlist.
     */
    @Test
    public void testToString() {
        System.out.println("Test toString");
        String expected = new String("1\nSong ID: 111\nSong Name: We Are Young\nArtist Name: Janelle Monae\nSong Length (in seconds): 252\n" + 
                                     "2\nSong ID: 222\nSong Name: That's the Way It Is\nArtist Name: Celine Dion\nSong Length (in seconds): 239\n" +
                                     "3\nSong ID: 333\nSong Name: Imagine\nArtist Name: John Lennon\nSong Length (in seconds): 234\n" +
                                     "4\nSong ID: 444\nSong Name: My Heart Will Go On\nArtist Name: Celine Dion\nSong Length (in seconds): 275\n");
        String actual = instance.toString();
        assertEquals(expected, actual);
        
        instance.clear();
        String exp2 = "Playlist is empty\n";
        String act2 = instance.toString();
        assertEquals(exp2,act2);
    }

    /**
     * Test of getPlaytime method, of class Playlist.
     */
    @Test
    public void testGetPlaytime() {
        System.out.println("Test getPlaytime");
        int expected = 1000;
        int actual = instance.getPlaytime();
        assertEquals(expected, actual);
    }

    /**
     * Test of getSongsByArtist method, of class Playlist.
     */
    @Test
    public void testGetSongsByArtist() {
        System.out.println("Test getSongsByArtist");
        String artist = "Celine Dion";
        String expected = new String("2\nSong ID: 222\nSong Name: That's the Way It Is\nArtist Name: Celine Dion\nSong Length (in seconds): 239\n" +
                                     "4\nSong ID: 444\nSong Name: My Heart Will Go On\nArtist Name: Celine Dion\nSong Length (in seconds): 275\n");
        String actual = instance.getSongsByArtist(artist); 
        assertEquals(expected, actual);
        
        String art2 = "Leslie";
        String exp2 = "This artist is not found in the playlist\n";
        String act2 = instance.getSongsByArtist(art2);
        assertEquals(exp2, act2);
    }
    
}
