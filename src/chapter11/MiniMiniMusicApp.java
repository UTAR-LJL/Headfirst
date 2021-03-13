package chapter11;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMiniMusicApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniMiniMusicApp music = new MiniMiniMusicApp();
		music.player();
	}
	
	void player() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track t = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 7, 50, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			t.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 2);
			t.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
