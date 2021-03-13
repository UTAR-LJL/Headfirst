package chapter11;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;

public class MiniMusicCmdLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	void play() {
		
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Tack track = seq.createTrack();
			
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, Instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
