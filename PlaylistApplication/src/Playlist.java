public class Playlist {
    
    private class Node {
        Song element;
        Node next;
        
        Node(Song s){
            element = new Song(s);
            next = null;
        }
    }
    
    private Node head, tail;
    private int size;
    
    public Playlist(){
        head = tail = null;
        size = 0;
    }
    
    public void clear(){
        head = tail = null;
        size = 0;
    }
    public String enqueue(Song s){
        Node newNode = new Node(s);
        if(head == null){
            head = tail = newNode;
            size++;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            size++;
        }
        String str = String.format("%s added to the playlist", s.songName);
        return str;
    }
    
    public Song dequeue(){
        
        if(head == null){
            System.out.println("Playlist is empty");
            return null;
        }
        else{
            Song removed = head.element;
            head = head.next;
            if(head == null){
                tail = null;
            }
            System.out.printf("%s removed from the playlist\n", removed.songName);
            size--;
        return removed;
        }
    }
    
    @Override
    public String toString(){
        String str = "";
        if (head == null){
            str = "Playlist is empty\n";
            return str;
        }
        else{
            int pos = 1;
            Node current = head;
            while(current != null){
                str += String.format("%d\n", pos) + current.element.toString();
                pos++;
                current = current.next;
            }
        }
        return str;
    }
    
    public int getPlaytime(){
        Node current = head;
        int playTime = 0;
        while(current != null){
            playTime += current.element.songLength;
            current = current.next;
        }
        return playTime;
    }
    
    public String getSongsByArtist(String artist){
        String strIfFound = "";
        Node current = head;
        boolean found = false;
        int pos = 1;
        
        while(current != null){
            if(current.element.artistName.equals(artist)){
                strIfFound += String.format("%d\n", pos) + current.element.toString();
                found = true;
            }
            current = current.next;
            pos++;
        }
        
        if(found){
            return strIfFound;
        }
        else{
            String notFound = "This artist is not found in the playlist\n";
            return notFound;
        }
    }
}
    
     
      
  
