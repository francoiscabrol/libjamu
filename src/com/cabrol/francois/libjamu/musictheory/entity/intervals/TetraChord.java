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

package com.cabrol.francois.libjamu.musictheory.entity.intervals;

public enum TetraChord {

    major (new int[] {2, 2, 1}),
    minor (new int[] {2, 1, 2}),
    diminished (new int[] {1, 2, 1}),
    harmonic (new int[] {1, 3, 1}),
    phrygian (new int[] {1, 2, 2}),
    lydian (new int[] {2, 2, 2});

//    tetracordes[6] =  //213
//    tetracordes[7] = new int[] {3, 1, 2}; //312
//    tetracordes[8] = new int[] {3, 1, 1}; //311
//    tetracordes[9] = new int[] {3, 2, 1}; //321
//    tetracordes[10] = new int[] {2, 3, 1}; //231
//    tetracordes[11] = new int[] {2, 1, 3}; //213
//    tetracordes[12] = new int[] {2, 1, 2}; //212

    private final int[] intervals;

    private TetraChord(int[] intervals) {
        this.intervals = intervals;
    }

    public int[] getIntervals() {
        return intervals;
    }


}
