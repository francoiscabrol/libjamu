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


import com.cabrol.francois.libjamu.musictheory.utils.ListUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScaleNotesList implements Serializable {

    private static final long serialVersionUID = 6049663731136962993L;

    protected List<ScaleNote> notes;

    public ScaleNotesList() {
        notes = new ArrayList<ScaleNote>();
    }

    public ScaleNote getScaleNote(int i){
        int id = ListUtils.getIdOfAnInfiniteList(notes.size(), i);
        return notes.get(id);
    }

    public List<ScaleNote> getScaleNotes() {
        return notes;
    }

    public int getNotePosition(ScaleNote note){
        for (int i = 0; i < notes.size(); i++) {
            if(note.getPitch() == notes.get(i).getPitch())
                return i;
        }
        return -1;
    }

    public boolean isIn(ScaleNote scaleNote){
        if (getNotePosition(scaleNote) == -1)
            return false;
        else
            return true;
    }

    public boolean isIn(List<ScaleNote> scaleNote){
        for (ScaleNote note: scaleNote){
            if(!isIn(note))
                return false;
        }
        return true;
    }

    public String toString(){
        String list = "";
        for (ScaleNote note: notes) {
            list += note.toString() + " ";
        }
        return list;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScaleNotesList) {
            return toString().equals(((ScaleNotesList)obj).toString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}

