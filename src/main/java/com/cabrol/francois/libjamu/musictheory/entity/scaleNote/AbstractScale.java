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

import com.cabrol.francois.libjamu.musictheory.utils.ScalesUtils;

import java.util.ArrayList;

public abstract class AbstractScale extends ScaleNotesList{

    private static final long serialVersionUID = -1480861979413611088L;

    protected String name;

    public AbstractScale(ArrayList<ScaleNote> scalesNotes){
        this.notes = scalesNotes;
    }

    public AbstractScale(String name){
        this.notes = ScalesUtils.getScaleNotesFromName(name);
        this.name = name;
    }

    protected AbstractScale() {
    }

    public Cadence getCadence(String cadence, boolean enrichment){
        return new Cadence(cadence, this, enrichment);
    }

    public Chord getChord(int degree, boolean enrichment){
        return ScalesUtils.getChordByScaleDegree(degree, this, enrichment);
    }

    public ArrayList<Chord> getChords(boolean enrichment){
        ArrayList<Chord> chords = new ArrayList<Chord>();
        for (int i = 0; i < notes.size(); i++) {
            chords.add(getChord(i, enrichment));
        }
        return chords;
    }

    public Mode getMode(int degree) {
        return new Mode(this, degree);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AbstractScale{" +
                "name='" + name + '\'' + "notes" + super.toString() +
                '}';
    }
}
