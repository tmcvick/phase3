import java.io.IOException;
import java.net.URL;

import javax.media.CannotRealizeException;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;

public class MediaPlayer {
	
	private Player player;

	public MediaPlayer(URL file) {
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder", new Format[] { input1, input2 },
				new Format[] { output }, PlugInManager.CODEC);

		try {
			player = Manager.createRealizedPlayer(new MediaLocator(file));
		} catch (NoPlayerException e) {
			System.out.print("No Player Present\n");
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			System.out.print("Cannot Realize Player\n");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double getClipLength() {
		return player.getDuration().getSeconds();
	}

	public void start() {
		player.start();
	}

	public void stop() {
		player.stop();
	}

	public void pause() {
		javax.media.Time time = player.getMediaTime();
		player.stop();
		player.setMediaTime(time);
	}
}
