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

import com.cabrol.francois.libjamu.musictheory.utils.CadenceUtils;
import com.cabrol.francois.libjamu.musictheory.utils.ListUtils;

import java.util.ArrayList;

public class Cadence {

    ArrayList<Chord> chords;
    AbstractScale scale;
    boolean enrichment;


    public Cadence(ArrayList<Chord> chords, AbstractScale scale, boolean enrichment) {
        this.chords = chords;
        this.scale = scale;
        this.enrichment = enrichment;
    }

    public Cadence(String cadence, AbstractScale scale, boolean enrichment){
        this(CadenceUtils.getChordsFromCadenceString(cadence, scale, enrichment), scale, enrichment);
    }

    public Chord getChord(int i){
        int id = ListUtils.getIdOfAnInfiniteList(chords.size(), i);
        return chords.get(id);
    }

    public ArrayList<Chord> getChords() {
        return chords;
    }

    public AbstractScale getScale() {
        return scale;
    }

    public boolean isEnrichment() {
        return enrichment;
    }

    public ChordSuite getChordsSuite(){
        return new ChordSuite(chords);
    }

    @Override
    public String toString() {
        return "Cadence{" +
                "chords=" + chords +
                ", scale=" + scale +
                ", enrichment=" + enrichment +
                '}';
    }
}
