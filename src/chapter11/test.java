package chapter11;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

import jdk.nashorn.internal.runtime.Timing;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sequencer player = MidiSystem.getSequencer();
		Sequence seq = new Sequence(Timing, 4);
		Track t = seq.createTrack();
		t.add(myMidiEvent);
		player.setSequence(seq);
		player.start();
		
	}

}
