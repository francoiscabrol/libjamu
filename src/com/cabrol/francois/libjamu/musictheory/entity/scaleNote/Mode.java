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

import java.util.ArrayList;
import java.util.List;

public class Mode extends AbstractScale {

    private int degree;

    public Mode(AbstractScale scale, int degree) {
        this.notes = getModeFromScale(degree, scale);
        this.name = scale.getName();
        this.degree = degree;
    }

    private List<ScaleNote> getModeFromScale(int degree, AbstractScale scale){

        if (degree == 0)
            return scale.getScaleNotes();

        List<ScaleNote> scaleNotes = scale.getScaleNotes();
        List<ScaleNote> modeNotes = new ArrayList<ScaleNote>();
        int i = 0;
        for (ScaleNote n:scaleNotes){
            modeNotes.add(scaleNotes.get(ListUtils.getIdOfAnInfiniteList(scaleNotes.size(), i + degree)));
            i++;
        }

        return modeNotes;
    }

    public String toString(){
        String scale = "Mode " + degree + " de la gamme " + name;
        scale += " ( ";
        for (ScaleNote note: notes) {
            scale += note.toString() + " ";
        }
        scale += ")";
        return  scale;
    }


}
