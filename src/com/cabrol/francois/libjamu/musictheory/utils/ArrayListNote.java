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

import com.cabrol.francois.libjamu.musictheory.entity.note.Note;

import java.util.ArrayList;

public class ArrayListNote extends ArrayList<Note> {


    @Override
    public boolean add(Note o) {
        if(size() == 0){
            return super.add(o);
        }
        int index = 0;
        for (int i = 0; i < this.size(); i++) {
            System.out.println(o.getRhythmicNote().getStart() + "<" + this.get(i).getRhythmicNote().getStart());
            if(o.getRhythmicNote().getStart() < this.get(i).getRhythmicNote().getStart()){
                index = i;
                break;
            }
        }
        if(index == 0){
            return super.add(o);
        }
        add(index, o);
        return true;
    }
}

