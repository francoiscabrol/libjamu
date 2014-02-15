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

import com.cabrol.francois.libjamu.musictheory.entity.scaleNote.ScaleNote;
import com.cabrol.francois.libjamu.musictheory.utils.KeyUtils;

import java.io.Serializable;

public class Key implements Serializable{

    private static final long serialVersionUID = 923557116146240667L;

    int midiKey;

    public Key(String note){
        this.setMidiKey(KeyUtils.getMidiKey(note));
    }

    public Key(int midiKey){
        this.setMidiKey(midiKey);
    }

    /**
     * Copy constructor.
     */
    public Key(Key key) {
        this(key.getMidiKey());
    }

    public String getStringNote(){
        return KeyUtils.getStringNote(midiKey);
    }

    public String getStringNoteAndOctave(){
        return KeyUtils.getStringNote(midiKey) + (KeyUtils.getMidiKeyOctave(midiKey)-2);
    }

    public int getOctave(){
        return KeyUtils.getMidiKeyOctave(midiKey);
    }

    public void setOctave(int octave){
        this.setMidiKey(KeyUtils.getTransposeKey(midiKey, octave));
    }

    public void transpose(int semiTones){
        this.setMidiKey(midiKey + semiTones);
    }

    public int getMidiKey(){
        return midiKey;
    }

    private void setMidiKey(int midiKey){
        this.midiKey = midiKey;
    }

    public ScaleNote getScaleNote(){
        return new ScaleNote(midiKey);
    }

    private boolean isValidMidiKey(int midiKey){
          if( midiKey >= 0 && midiKey <= 127 )
              return true;
        else
              return false;
    }

    @Override
    public String toString() {
        return "Key{"+ this.getStringNoteAndOctave() +
                '}';
    }

}
