package application;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;



import java.io.File;
//import javax.sound.sampled.*;

public class Thread_Handler implements Runnable {
	
	public void playTrack() {
		try {
			File file = new File("src/application/error.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			  DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
	            Clip clip = (Clip)AudioSystem.getLine(info);
	            clip.open(audioInputStream);
	            clip.start();
		} catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public void playTrack_2() {
		try {
			File file = new File("src/application/welcome.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			  DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
	            Clip clip = (Clip)AudioSystem.getLine(info);
	            clip.open(audioInputStream);
	            clip.start();
		} catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	@Override
	public void run() /*extends ExceptionHandler*/ {
		// TODO Auto-generated method stub
		playTrack();
	}
	
	public void run_2() /*extends ExceptionHandler*/ {
		// TODO Auto-generated method stub
		playTrack_2();
	}

}
