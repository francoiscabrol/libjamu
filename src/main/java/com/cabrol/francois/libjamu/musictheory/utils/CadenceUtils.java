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


import com.cabrol.francois.libjamu.musictheory.entity.scaleNote.AbstractScale;
import com.cabrol.francois.libjamu.musictheory.entity.scaleNote.Chord;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadenceUtils {

    public static ArrayList<Chord> getChordsFromCadenceString(String cadence, AbstractScale scale, boolean enrichment){

        cadence = cadence.toUpperCase();

        ArrayList<Chord> chords = new ArrayList<Chord>();

        ArrayList<Integer> degreeList = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("IV|VII|VI|V|IX|XI|XII|X|III|II|I");
        Matcher matcher = pattern.matcher(cadence);
        while (matcher.find()) {
            Integer degree = NumberUtils.ConvertRomanNumeralsInNumber(matcher.group());
            degreeList.add(degree);
        }

        for (Iterator iterator = degreeList.iterator(); iterator.hasNext();) {
            Integer degree = (Integer) iterator.next();
            Chord chord = scale.getChord(degree, enrichment);
            chords.add(chord);
        }

        return chords;
    }

}
