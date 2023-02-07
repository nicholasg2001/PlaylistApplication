
public class Song {
    public String songID;
    public String songName;
    public String artistName;
    public int songLength;
    
    public Song(){
        songID = "None";
        songName = "None";
        artistName = "None";
        songLength = 0;
    }
    
    public Song(String ID, String Sname, String Aname, int Length){
        songID = ID;
        songName = Sname;
        artistName = Aname;
        songLength = Length;
    }
    
    public Song(Song s){
        this.songID = s.songID;
        this.songName = s.songName;
        this.artistName = s.artistName;
        this.songLength = s.songLength;
        
    }
    
    @Override
    public String toString(){
        String str = String.format("Song ID: %s\nSong Name: %s\nArtist Name: %s\nSong Length (in seconds): %d\n", songID, songName, artistName, songLength); 
        return str;
    }
}

