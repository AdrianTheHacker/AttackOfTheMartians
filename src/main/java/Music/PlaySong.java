package Music;

import Main.GameElements;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlaySong {
    private static final String fileType = ".wav";

    private static final File BACKGROUND_MUSIC = new File(System.getProperty("user.dir") + "\\src\\main\\java\\Music\\songs\\GameMusic" + fileType);
    private static final File TITLE_SCREEN_MUSIC = new File(System.getProperty("user.dir") + "\\src\\main\\java\\Music\\songs\\TitleMusic" + fileType);

    static AudioInputStream titleAudioInputStream;
    static Clip titleMusic;

    static AudioInputStream backgroundAudioInputStream;
    public static Clip backgroundMusic;

    public static void playTitleSong() {
        try {
            titleAudioInputStream = AudioSystem.getAudioInputStream(TITLE_SCREEN_MUSIC);
            titleMusic = AudioSystem.getClip();
            titleMusic.open(titleAudioInputStream);

            titleMusic.loop(-1);

            GameElements.i = 1;
        } catch(UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file exception: " + e);
        } catch(IOException e) {
            System.out.println("IOException: " + e);
        } catch(LineUnavailableException e) {
            System.out.println("Line Unavailable Exception: " + e);
        }
    }

    public static void playBackgroundSong() {
        try {
            titleMusic.stop();

            backgroundAudioInputStream = AudioSystem.getAudioInputStream(BACKGROUND_MUSIC);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(backgroundAudioInputStream);

            backgroundMusic.loop(-1);

            GameElements.i = 2;
        } catch(UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file exception: " + e);
        } catch(IOException e) {
            System.out.println("IOException: " + e);
        } catch(LineUnavailableException e) {
            System.out.println("Line Unavailable Exception: " + e);
        }
    }
}
