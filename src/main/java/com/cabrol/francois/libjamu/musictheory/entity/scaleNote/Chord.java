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

package com.cabrol.francois.libjamu.musictheory.entity.scaleNote;

import com.cabrol.francois.libjamu.musictheory.entity.intervals.ChordEnrichment;
import com.cabrol.francois.libjamu.musictheory.entity.intervals.Interval;
import com.cabrol.francois.libjamu.musictheory.entity.intervals.TriadChordInterval;
import com.cabrol.francois.libjamu.musictheory.entity.note.Key;
import com.cabrol.francois.libjamu.musictheory.utils.ListUtils;
import com.cabrol.francois.libjamu.musictheory.utils.RegexUtils;
import com.cabrol.francois.libjamu.musictheory.utils.ScalesUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chord extends ScaleNotesList{

    private static final long serialVersionUID = -1424148240384734597L;

    private String name;

    public Chord(String name) {
        this.notes = getChordNoteFromName(name);//ChordsUtils.getChordNotesFromChordName(name);
        this.name = name;
    }


    public Chord(List<ScaleNote> notes) {
        this.notes = notes;
        this.name = getChordName();
    }

    public Chord( ScaleNote root, ScaleNote triad, ScaleNote fifth ) {
        this.notes = new ArrayList<ScaleNote>();
        this.notes.add(root);
        this.notes.add(triad);
        this.notes.add(fifth);
        this.name = getChordName();
    }

    public void addNote( ScaleNote note){
        this.notes.add(note);
        this.name = getChordName();
    }

    public ScaleNote getRoot(){
        return notes.get(0);
    }


    private List<ScaleNote> getChordNoteFromName(String name) {

        String root = RegexUtils.getFirstMatchedStringFromRegex("^(C|D|E|F|G|A|B)[b?|#?]?", name);

        //triadChord name matching
        String regex1 = RegexUtils.constructRegexFromEnum(TriadChordInterval.values());
        String triadChordName = RegexUtils.getFirstMatchedStringFromRegex(regex1, name);
        TriadChordInterval triadChordInterval;
        if(triadChordName == null)
            triadChordInterval  = TriadChordInterval.Major;
        else
            triadChordInterval = TriadChordInterval.getFromName(triadChordName);

        //enrichmentName name matching
        String regex2 = RegexUtils.constructRegexFromEnum(ChordEnrichment.values());
        List<String> enrichment = RegexUtils.getAllMatchedStringFromRegex(regex2, name);
        List<ChordEnrichment> chordEnrichment = new ArrayList();
        for(String en : enrichment)
            chordEnrichment.add(ChordEnrichment.getFromName(en));

        ScaleNote rootNote = new ScaleNote(root);
        List<ScaleNote> listNotes = new ArrayList();
        for(Interval i : triadChordInterval.getIntervals())
            listNotes.add(new ScaleNote(rootNote.getPitch() + i.getNumOfTones()));

        for(ChordEnrichment en : chordEnrichment){
            for(Interval i : en.getIntervals())
                listNotes.add(new ScaleNote(rootNote.getPitch() + i.getNumOfTones()));
        }


        return listNotes;
    }

    public String getChordName(){
        String name = "";

        //add the root note
        name += notes.get(0).getKey(0).getStringNote();

        TriadChordInterval triadChord = getTriadChordName();
        List<ChordEnrichment> chordEnrichment = getChordEnrichment();
        name += triadChord.getName();

        for(ChordEnrichment en : chordEnrichment)
            name += en.getName();

        return name;
    }

    public TriadChordInterval getTriadChordName(){
        List<Interval> chordIntervals = getIntervals();
        for(TriadChordInterval ch : TriadChordInterval.values()){
            List<Interval> l = Arrays.asList(ch.getIntervals());
            if(chordIntervals.containsAll(l)){
                 return ch;
            }
        }
        return null;
    }

    public List<ChordEnrichment> getChordEnrichment(){
        List<ChordEnrichment> enrichments = new ArrayList();
        List<Interval> chordIntervals = getIntervals();
        for(ChordEnrichment ch : ChordEnrichment.values()){
            if(chordIntervals.containsAll(Arrays.asList(ch.getIntervals()))){
                 enrichments.add(ch);
            }
        }
        return enrichments;
    }

    public ArrayList<Key> getKeyChord(int reverse, int octave){

        ArrayList<Key> keyChord = new ArrayList<Key>();
        for (int i = 0; i < notes.size(); i++) {
            ScaleNote note =  notes.get(ListUtils.getIdOfAnInfiniteList(notes.size(), reverse + i));
            //&& note.getKey(octave).getMidiKey() < keyChord.get(i-1).getMidiKey()
//            if ( i >= reverse && ( keyChord.size() <= 1 || note.getKey(octave).getMidiKey() > keyChord.get(i-1).getMidiKey() ) )
//                keyChord.add(note.getKey(octave));
//            else{
//                int nextNoteOctave = octave;
                while(keyChord.size() > 0 && note.getKey(octave).getMidiKey() < keyChord.get(i-1).getMidiKey())
                    octave++;
                keyChord.add(note.getKey(octave));
//            }
        }

        return keyChord;
    }

    public ArrayList<Key> getKeyChord(){
        return getKeyChord(0, 0);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Mode> getModesAvailable(){
        ArrayList<Mode> modes = new ArrayList<Mode>();
        List<String> listScaleName = ScalesUtils.getScalesNamesList();
        for(String scaleName:listScaleName){
            Scale scale = new Scale(scaleName);
            if (scale.isIn(notes)){
                int rootId = scale.getNotePosition(getRoot());
                modes.add(new Mode(scale, rootId));
            }
        }
        return modes;
    }

    public String toString(){
        String strNotes = "";
        for(ScaleNote note: this.notes){
            strNotes += note.toString() + "-";
        }
        String name = this.getName();
        return name + "(" + strNotes + ")";
    }


    public List<Interval> getIntervals() {
        List<Key> keys = getKeyChord();
        List<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < keys.size(); i++) {
            intervals.add(Interval.getFromNumOfTones(keys.get(i).getMidiKey() - keys.get(0).getMidiKey()));
        }
        return intervals;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Chord) {
            return name.equals(((Chord)obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


}
