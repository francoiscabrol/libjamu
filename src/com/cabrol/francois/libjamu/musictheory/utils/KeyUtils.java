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


import java.util.Arrays;
import java.util.List;

public class KeyUtils {

    public static String[] everyTonicsSharpAndFlat = {"C", "C#", "Db", "D", "D#", "Eb", "E", "E#", "Fb", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B", "B#", "Cb"};

    public static String[] everyTonicsOnlyFlat = {"C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};

    public static String[] everyTonicsOnlySharp = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};


    public static int getMidiKey(String stringNote){
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

    public static String getStringNote(int midiKey){
        if(midiKey >= 0 && midiKey <= 127)
            return everyTonicsOnlySharp[getKeyTransposedOnFirstOctave(midiKey)];
        else
            return "No valid ("+midiKey+")";
    }

    public static int getTransposeKey(int midiKey, int octave){
        return getKeyTransposedOnFirstOctave(midiKey) + 12 * (octave);
    }

    public static int getKeyTransposedOnFirstOctave(int midiKey){
        return midiKey - (12 * getMidiKeyOctave(midiKey));
    }

    public static int getMidiKeyOctave(int midiKey){
        return (int) Math.floor(midiKey / 12);
    }


}
