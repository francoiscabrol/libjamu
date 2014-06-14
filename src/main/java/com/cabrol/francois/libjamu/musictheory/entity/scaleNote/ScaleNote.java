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


import com.cabrol.francois.libjamu.musictheory.entity.note.Key;
import com.cabrol.francois.libjamu.musictheory.utils.KeyUtils;
import com.cabrol.francois.libjamu.musictheory.utils.NotesUtils;

import java.io.Serializable;

public class ScaleNote implements Serializable {

    private static final long serialVersionUID = 2375478567059658126L;

    int pitch;

    public ScaleNote(String note){
        this.setPitch(KeyUtils.getMidiKey(note));
    }

    public ScaleNote(int note){
        this.setPitch(note);
    }

    public int getPitch() {
        return pitch;
    }

    private void setPitch(int pitch){
        pitch = KeyUtils.getKeyTransposedOnFirstOctave(pitch);
        if (isValidNote(pitch))
            this.pitch = pitch;
        else
            System.out.println(pitch + " isn't a valid note scale pitch.") ;
    }

    public Key getKey(int octave){
        Key key =  new Key(pitch);
        key.setOctave(octave);
        return key;
    }

    private boolean isValidNote(int note){
        if( note >= 0 && note <= 11 )
            return true;
        else
            return false;
    }

    public String toString(){
        return NotesUtils.getStringNote(pitch);
    }

}
