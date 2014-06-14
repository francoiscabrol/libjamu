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

import com.cabrol.francois.libjamu.musictheory.utils.ChordsUtils;
import com.cabrol.francois.libjamu.musictheory.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class ChordSuite {

    ArrayList<Chord> chords;

    public ChordSuite(ArrayList<Chord> chords){
        this.chords = chords;
    }

    public ChordSuite(String string){
        chords = ChordsUtils.getChordSuiteFromTxt(string);
    }

    public List<ChordSuite> getEveryChordSuitePossible(){
        List<ChordSuite> chordsSuites = new ArrayList<ChordSuite>();
            for (int numOfChords = 1; numOfChords <= this.chords.size(); numOfChords++) {
                for (int idChord = 0; idChord < this.chords.size(); idChord++) {
                    ArrayList<Chord> chords = new ArrayList<Chord>();
                    for (int i = 0; i < numOfChords; i++) {
                        int id = ListUtils.getIdOfAnInfiniteList(this.chords.size(), idChord + i);
                        chords.add(new Chord(this.chords.get(id).getScaleNotes()));
                    }
                    chordsSuites.add(new ChordSuite(chords));
                    if(numOfChords == this.chords.size())
                        break;
                }
            }
        return chordsSuites;
    }

    public ArrayList<Chord> getChords() {
        return chords;
    }

    public void setChords(ArrayList<Chord> chords) {
        this.chords = chords;
    }

    public String getTxtChordSuite(){
        String string = "";
        for (Chord chord : chords)
            string += chord.getName() + " ";
        return string;
    }

    @Override
    public String toString() {
        String string = "ChordSuite{";
        for(Chord chord : chords)
            string += " " + chord;
        string += " }";
        return string;
    }
}
