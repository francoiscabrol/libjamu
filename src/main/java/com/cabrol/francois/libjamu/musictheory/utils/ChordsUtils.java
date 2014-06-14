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

import com.cabrol.francois.libjamu.musictheory.entity.intervals.ChordEnrichment;
import com.cabrol.francois.libjamu.musictheory.entity.intervals.Interval;
import com.cabrol.francois.libjamu.musictheory.entity.note.Key;
import com.cabrol.francois.libjamu.musictheory.entity.scaleNote.Chord;
import com.cabrol.francois.libjamu.musictheory.entity.scaleNote.ScaleNote;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChordsUtils {
	
	public ChordsUtils(){
		
	}

	private static List<Integer> getChordEnrichment(List<Integer> chord, String name){

        System.out.println("nameChord = " + name);
        String regex = RegexUtils.constructRegexFromATab(ChordEnrichment.getAllNames());
        System.out.println("regex = " + regex);
        String string = RegexUtils.getFirstMatchedStringFromRegex(regex, name);
        System.out.println("RegexUtils.getFirstMatchedStringFromRegex(RegexUtils.constructRegexFromATab(ChordEnrichment.getAllNames()) = " + string );

        int rootKey = chord.get(0);

        String enrichment = RegexUtils.getFirstMatchedStringFromRegex(regex, name);
        if(enrichment == null)
            return null;

        Interval[] intervals = ChordEnrichment.getFromName(enrichment).getIntervals();

        List<Integer> chordEnrichment = new ArrayList<Integer>();
        if (intervals.length > 0)
        chordEnrichment.add(rootKey + intervals[0].getNumOfTones());
        if (intervals.length > 0 && intervals.length == 2)
            chordEnrichment.add(rootKey + intervals[1].getNumOfTones());

        return chordEnrichment;
	}

	
	public static ArrayList<ScaleNote> getChordNotesFromChordName(String name){
		
	 	Pattern pattern = Pattern.compile("[C|D|E|F|G|A|B][b?|#?]?");
	    Matcher matcher = pattern.matcher(name);
	    while (matcher.find()) {
	      break;
	    }
	    String root = null;
	    try {
	    	root = matcher.group(0);
		} catch (Exception e) {
			System.out.println(name + " n'est pas un nom d'accord valide.");
			return null;
		}
		
		String third = (name.matches("(C|D|E|F|G|A|B)(b?|#?)?m[0-9]?.?.?")) ? "minor" : "major";

		String fifth;
		if (name.matches("dim"))
			fifth = "dim";
		else if (name.matches("aug"))
			fifth = "aug";
		else 
			fifth = "perfect";
		
		int rootKey = NotesUtils.getKeyMidiNote(root);
		int fifthKey;
		switch (fifth){
		case "dim": third = "minor"; fifthKey = rootKey + 6; break;
		case "aug": third = "major"; fifthKey = rootKey + 8; break;
		default: fifthKey = rootKey + 7; break;
		}		
		int thirdKey = (third == "major") ? rootKey + 4 : rootKey + 3;
		
        List<Integer> chord = new ArrayList<Integer>();
        chord.add(rootKey);
        chord.add(thirdKey);
        chord.add(fifthKey);
        List<Integer> enr = getChordEnrichment(chord, name);
        if( enr != null )
            chord.addAll(enr);

        ArrayList<ScaleNote> scaleNotes = new ArrayList<ScaleNote>();

        for (int i = 0; i < chord.size(); i++) {
               scaleNotes.add(new ScaleNote(chord.get(i)));
        }

		return scaleNotes;
	}


    //refactoring

//    public static String getChordName(ArrayList<Key> chord){
//
//        String chordName = getTriadChordName(chord);
//
//        String enrichment = getEnrichmentName(chord);
//        chordName += (enrichment != null) ? enrichment : "" ;
//
//        return chordName;
//    }

    public static String getTriadChordName(ArrayList<Key> chord){

        String name = "";

        //add the root note
        name += chord.get(0).getStringNote();

        //check if the third is major or minor
        String third = (NotesUtils.getIntervalBetweenTwoKeys(chord.get(1).getMidiKey(), chord.get(0).getMidiKey()) == 4) ? "major" : "minor";

        //check if the fifth is diminished or augmented
        String fifth = null;
        if (NotesUtils.getIntervalBetweenTwoKeys(chord.get(2).getMidiKey(), chord.get(0).getMidiKey()) == 6)
            fifth = "dim";
        else if (NotesUtils.getIntervalBetweenTwoKeys(chord.get(2).getMidiKey(), chord.get(0).getMidiKey()) == 7)
            fifth = "perfect";
        else if (NotesUtils.getIntervalBetweenTwoKeys(chord.get(2).getMidiKey(), chord.get(0).getMidiKey()) == 8)
            fifth = "aug";

        if (third == "minor" && fifth == "dim")
            name += "dim";
        else if (third == "major" && fifth == "aug")
            name += "aug";
        else
            name += (third=="major") ? "": "m";


        return name;
    }

    private static String getEnrichmentName(ArrayList<Key> chord){
        //System.out.println(inter);
        if (chord.size() >= 4){
            ChordEnrichment enrichment;
            int inter = NotesUtils.getIntervalBetweenTwoKeys(chord.get(3).getMidiKey(), chord.get(0).getMidiKey());
            enrichment = ChordEnrichment.getFromIntervals(new Interval[]{Interval.getFromNumOfTones(inter)});
            if(enrichment == null)
                return null;
            return enrichment.getName();
        }
        else
            return null;
    }

    public static ArrayList<Chord> getChordSuiteFromTxt(String chordString){

        String[] chordsStringTab = chordString.split(" ");
        ArrayList<Chord> chords = new ArrayList<Chord>();
        for (int i = 0; i < chordsStringTab.length; i++)
            chords.add(new Chord(chordsStringTab[i]));

        return chords;
    }

}
