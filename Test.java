
import java.util.Scanner;

//START OF THE TEST CLASS
public class Test {
	// initialized the objects as static to be accessed by other methods (Global
	// variable)
	private static Scanner sc = new Scanner(System.in);
	private static Queue q1 = new Queue();
	private static BinarySearchTree bst = new BinarySearchTree();
	private static PlayList p1 = new PlayList();

//MAIN METHOD
	public static void main(String[] args) {
		// Welcome Page
		System.out.println("************");
		System.out.println("Welcome! Enter your name to create your own playlist");
		String name = sc.nextLine();
		System.out.println("Hello " + name);
		System.out.println("************");

		pathInput();// takes the filepath from the user and from the filepath we extract the
					// specific songname
		// Then we insert both that filepath and songname into the queue and binary
		// search tree

		choicemenu();// Once the user is done from adding songs we move to the next step

	}// end of main

	// METHOD PATHINPUT
	public static void pathInput() {

		System.out.println("\nPlease enter a WAV filepath");
		System.out.println("For example: \"C:\\Users\\UserName\\Desktop\\SONGNAME.wav");
		String filepath = sc.nextLine();

		if (filepath.matches("([a-zA-Z]:)?(\\\\[a-zA-Z0-9!() _.-]+)+\\\\?")) {//the REGEX checks if the input resembles a path 
			if (p1.isWavPath(filepath)) { // sends path to isWavPath function to check if its genuine
				
				String songName = filepath.substring(filepath.lastIndexOf("\\") + 1).replace(".wav", "").trim(); //only takes the name of the song
				q1.addSong(filepath, songName);

				bst.insert(songName, filepath); // stores a song name and a filepath to a treenode

				System.out.println("\nDo you want to add a new song?" + " Yes or No");
				String answer = sc.nextLine();
				if (answer.toLowerCase().equals("no")) {
					System.out.println();
				} else {
					pathInput();
				}
			} else {
				System.err.println("\nPath entered is not valid, please check if it exists or if it's a WAV file..");
				pathInput();
			}
		} else {
			System.err.println("\nPlease Enter a Path !!!");
			pathInput();
		}

	}// end of method

	// METHOD CHOICEMENU
	public static void choicemenu() {
		// the user will have the option of either playing the songs in the playlist
		// or to search for a specific song to play
		System.out.println("This is your choice menu:");
		System.out.println("Press 1 for Playlist Menu\nPress 2 to Search for a Specific Song");

		String choice = sc.next();
		if (choice.equals("1"))
			playlistmenu();
		else if (choice.equals("2"))
			searchmenu();
		else {
			System.err.println("Invalid number! Please Try Again");
			choicemenu();
		}
	}// end of method

	// METHOD SEARCHMENU
	private static void searchmenu() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the name of the song you're looking for: ");
		String song = sc1.nextLine();
		System.out.println(bst.searchforSong(song));// returns a String type
		String option;
		if (bst.searchforSong(song) == "..Song is found..") {
			// The song was found in the tree
			while (true) {
				System.out.println(
				"Press 1 to Play the Song."
				+ "\nPress 2 to Search Again."
				+ "\nPress 3 to go Back to your choice menu.\n");
				option = sc.next();
				if (option.equals("1")) {
					// returns a filepath of type String and plays that specific song
					p1.playMusic(bst.searchForFilePath(song));
					System.out.println("Press Any Button to Stop Playing");
					String anything = sc.next();
					p1.stopMusic();
					continue;
				} else if (option.equals("2")) {
					// it calls back the same method for the user to search again for a song
					searchmenu();
					break;
				} else if (option.equals("3")) {
					choicemenu();
					break;
				} else {
					System.err.println("Invalid input, Try Again..\n");
				}
			} // while

		} // if

		else {
			// if the song was NOT FOUND in the tree
			System.out.println("Press 1 to Search Again.\nPress 2 to go Back to your choice menu.\n");
			option = sc.next();
			if (option.equals("1"))
				searchmenu();
			else
				choicemenu();
		}

	}// end of method
//METHOD PLAYLISTMENU

	private static void playlistmenu() {
		// The user is given a list of choices to choose from.
		System.out.println("Press 1 to Play\\Resume the songs.");
		System.out.println("Press 2 to Restart the Song.");
		System.out.println("Press 3 to Pause the song.");
		System.out.println("Press 4 to Play the song on Repeat.");
		System.out.println("Press 5 to Play the next song.");
		System.out.println("Press 6 to View all your added songs");	
		System.out.println("Press 7 to Return back to choice menu.");

		while (true) {

			String choice = sc.next();
			// calls the function
			gotoChoice(choice);
		}
	}// end of method

	
	// METHOD GOTOCHOICE
	private static void gotoChoice(String choice) {
		switch (choice) {
		case "1": // PLAY SONG
			p1.resumeSong(q1.getFront());
			System.out.println("("+q1.getsongName()+")" + " is Playing...");
			break;
		case "2":// RESTART THE SAME SONG
			p1.stopMusic();
			p1.playMusic(q1.getFront());
			System.out.println("(" + q1.getsongName() + ")" + " has Restarted...");
			break;
		case "3":// PAUSE SONG
			p1.pauseSong();
			break;
		case "4"://PLAY THE SAME SONG ON REPEAT
			p1.loopSong(q1.getFront());
			System.out.println("("+q1.getsongName()+")"+" is Playing...");
			break;
		case "5":// PLAY THE NEXT SONG IN THE PLAYLIST
			p1.stopMusic();// stops the music that's currently playing
			q1.deleteSong();// deletes the song at the beginning of the list and moves it back to the end
			p1.playMusic(q1.getFront());// then plays the next new song in the queue which is now in the front
			System.out.println("(" + q1.getsongName() + ")" + " is Playing...");
			break;
	    case "6": // Show the order of songs in the list for the user
			q1.viewPlayList();
			break;	
	    case "7":// GO BACK TO YOUR CHOICE MENU
			p1.stopMusic();// BUT first the song must stop playing
			choicemenu();
			break;
		default:
			System.err.println("Wrong input, Please enter the value Again: ");
			choice = sc.next();
			gotoChoice(choice);

		}// end of switch case

	}// end of method

}// end of class
