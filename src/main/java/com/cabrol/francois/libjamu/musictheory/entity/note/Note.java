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

package com.cabrol.francois.libjamu.musictheory.entity.note;

import java.io.Serializable;

public class Note implements Serializable{

    private static final long serialVersionUID = 9083547034299641855L;

    RhythmicNote rhythmicNote;
    Key key;

    public Note(RhythmicNote rhythmicNote, Key key) {
        this.rhythmicNote = rhythmicNote;
        this.key = key;
    }

    /**
     * Copy constructor.
     */
    public Note(Note note) {
        this(new RhythmicNote(note.rhythmicNote), new Key(note.key));
    }

    public RhythmicNote getRhythmicNote() {
            return rhythmicNote;
    }

    public void setRhythmicNote(RhythmicNote rhythmicNote) {
            this.rhythmicNote = rhythmicNote;
    }

    public Key getKey() {
            return key;
    }

    public void setKey(Key key) {
            this.key = key;
    }

    @Override
    public String toString() {
        return "Note{" + rhythmicNote +
                ", " + key +
                '}';
    }
}