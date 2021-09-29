import java.io.File;
import java.nio.file.InvalidPathException;

import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayList {
//initialized all my objects and attributes to be used later in the methods
	private AudioInputStream audioInput;
	private Clip clip;
	private File musicPath;
	private long clipTimePosition;

	//method returns true if 1-the path exists , 2-it is a file, 3-it ends with .wav
	public boolean isWavPath(String path) {

		File f = new File(path);
		if (f.exists() && f.isFile() && (path.substring(path.lastIndexOf(".")).equals(".wav")))
			return true;
		else
			return false;
	}

//METHOD PLAYMUSIC
	public void playMusic(String musicLocation) {

		try {
			musicPath = new File(musicLocation);// takes the file path from the user and save it in the file

			if (musicPath.exists()) {
				// if the file does exists
				// the file is turned into an audio stream
				audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip(); // it gets a clip that will be able to play that audio stream
				clip.open(audioInput);// opens the audio stream and starts playing the song
				clip.start();// the clip will start playing
				

			} else {
				// the file inserted doesn't exist
				System.out.println("Can't find file!!");
			}
		} catch (Exception ex) {
			System.out.println("An error has occured.");
		}
	}// end of method

//METHOD PAUSESONG
	public void pauseSong() {
		// checks first if the clip is playing
		if (clip.isRunning()) {
			// takes the exact timing position of the song
			clipTimePosition = clip.getMicrosecondPosition();
			clip.stop();// stops playing the clip
			System.out.println("..Music is Paused..");
		} else {
			System.out.println("Song is Already Paused...");
		}
	}// end of method
 private boolean runs = true;
//METHOD RESUME SONG
	public void resumeSong(String musicLocation) {
		if(runs) {
		playMusic(musicLocation);
		runs=false;
		}
		else {
		// checks first if the clip is playing
		if (clip.isRunning()) {
			System.out.println("Song is Already Playing...");
		} else {
			// sets that exact timing position of the song back to the clip
			clip.setMicrosecondPosition(clipTimePosition);
			clip.start();// starts playing the clip
		}
		}
	}// end of method

//METHOD STOPMUSIC
	public void stopMusic() {
		try {
			// checks if the clip is playing
			if (clip.isRunning()) {
				clip.stop();// stops playing the clip

			}
		} catch (Exception ex) {
			System.out.println("An error has occured.");
		}
	}// end of method
 public void loopSong(String musicLocation) {
    	 try {
				musicPath = new File(musicLocation);//takes the file path from the user and save it in the file

				if (musicPath.exists()) {
					//if the file does exists
					//the file is turned into an audio stream
					audioInput = AudioSystem.getAudioInputStream(musicPath);
					clip = AudioSystem.getClip(); //it gets a clip that will be able to play that audio stream
					clip.open(audioInput);//opens the audio stream and starts playing the song
					clip.start();//the clip will start playing
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				
				} else {
					//the file inserted doesn't exist
					System.out.println("Can't find file!!");
				}
			} catch (Exception ex) {
				System.out.println("An error has occured.");
			}
   }//end of method

}// end of class
