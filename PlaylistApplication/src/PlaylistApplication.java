


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class PlaylistApplication {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        char option;
        Playlist list = new Playlist();
        printMenu();
        while(true){
            System.out.println("Choose an option: ");
            option = keyboard.next().charAt(0);
            if(option == 'a' || option == 'd' || option == 'o' || option == 's' || option == 't' || option == 'q'){
                executeMenu(list, option);
                printMenu();
            }
            else{
                ;
            }
        }
    }
    
    public static void printMenu() {
        System.out.println("==============================================\na - Add song\nd - Remove song\no - Output full playlist\ns - Output songs by specific artist\nt - Output total time of playlist\nq - Quit\n");
    }
      
    
    public static void executeMenu(Playlist list, char option) {
        Scanner keyboard = new Scanner(System.in);    
        switch (option) {
            case 'q':
                System.exit(0);
            case 'a':
                {
                    System.out.println("ADD SONG");
                    System.out.println("Enter song's unique ID:");
                    String songID = keyboard.nextLine();
                    System.out.println("Enter song's name:");
                    String songName = keyboard.nextLine();
                    System.out.println("Enter artist's name:");
                    String artistName = keyboard.nextLine();
                    System.out.println("Enter song's length (in seconds):");
                    int songLength = keyboard.nextInt();
                    Song newSong = new Song(songID, songName, artistName, songLength);
                    list.enqueue(newSong);
                    System.out.printf("\"%s\" added to the playlist\n", songName);
                    break;
                }
            case 'd':
                System.out.println("REMOVE SONG");
                list.dequeue();
                break;
            case 'o':
                System.out.println("OUTPUT FULL PLAYLIST");
                System.out.println(list);
                break;
            case 't':
                System.out.printf("Total play time: %d", list.getPlaytime());
                break;
            case 's':
                {
                    System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
                    System.out.println("Enter artist's name: ");
                    String artistName = keyboard.nextLine();
                    System.out.println(list.getSongsByArtist(artistName));
                    break;
                }
            default:
                break;
        }
    }
            
         
    
    
}
