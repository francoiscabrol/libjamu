/*
 * Copyright (c) 2014 François Cabrol.
 *
 *  This file is part of libjamu.
 *
 *     libjamu is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     libjamu is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with libjamu.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cabrol.francois.libjamu.musictheory.utils;

import com.cabrol.francois.libjamu.musictheory.entity.note.Note;

import java.util.Arrays;
import java.util.List;

public class NotesUtils {
	
	public static String[] everyTonicsSharpAndFlat = {"C", "C#", "Db", "D", "D#", "Eb", "E", "E#", "Fb", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B", "B#", "Cb"};
	
	public static String[] everyTonicsOnlyFlat = {"C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};
	
	public static String[] everyTonicsOnlySharp = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	
	
	public static int getKeyMidiNote(String stringNote){
		List<String> everyTonicsOnlyFlatList = Arrays.asList(everyTonicsOnlyFlat);
		List<String> everyTonicsOnlySharpList = Arrays.asList(everyTonicsOnlySharp);
		//exceptions
		switch(stringNote){
			case "E#": stringNote = "F"; break;
			case "Fb": stringNote = "E"; break;
			case "B#": stringNote = "C"; break;
			case "Cb": stringNote = "B"; break;
		}
		if ( everyTonicsOnlyFlatList.indexOf(stringNote) == - 1 )
			return everyTonicsOnlySharpList.indexOf(stringNote); 
		else
			return everyTonicsOnlyFlatList.indexOf(stringNote);
	}
	
	public static String getStringNote(int keyMidiNote){
		return everyTonicsOnlySharp[getKeyTransposedOnFirstOctave(keyMidiNote)];
	}
	
	public static int getTransposeKey(int key, int octave){
		return getKeyTransposedOnFirstOctave(key) + 12 * octave;
	}
	
	public static int getKeyTransposedOnFirstOctave(int key){
    	return key - (12 * getKeyOctave(key));
	}
	
	public static int getKeyOctave(int key){
		return Math.round(key / 12);
	}
	
	public static int getIntervalBetweenTwoKeys(int key1, int key2){
        if(key2 > key1)
            key1 += 12;
		int intervalInSemiTone =  key2 - key1;
		intervalInSemiTone = (intervalInSemiTone>0) ? intervalInSemiTone : -intervalInSemiTone;
		return intervalInSemiTone;
	}

    public static List<Note> cloneAListOfNotes(List<Note> notes){
        List<Note> dest = new ArrayListNote();
        for (Note item : notes) { dest.add(new Note(item.getRhythmicNote(), item.getKey())); }
        return dest;
    }

    public static List<Note> moveNotesInTime(float tocksToMove, List<Note> notes){
        for(Note n : notes){
            n.getRhythmicNote().setStart(n.getRhythmicNote().getStart()+tocksToMove);
        }
        return notes;
    }


}
