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

public enum Interval{

    UNISON ("unison", 0),
    MINOR_SECOND ("minor second", 1),
    MAJOR_SECOND ("second major", 2),
    THIRD_MINOR ("third minor", 3),
    THIRD_MAJOR ("third major", 4),
    FOURTH ("fourth", 5),
    FIFTH_DIM ("fifth dim", 6),
    FIFTH ("fifth", 7),
    FIFTH_AUG ("fifth aug", 8),
    SIXTH ("sixth", 9),
    SEVEN_MINOR ("minor seven", 10),
    MAJOR_SEVEN ("major seven", 11),
    OCTAVE ("octave", 12),
    FLAT_NINE ("flat nine", 13),
    NINE ("nine", 14),
    ELEVEN ("eleven", 17),
    THIRTEEN ("thirteen", 21);

    private final String name;
    private final int numOfTones;

    private Interval(String name, int numOfTons) {
        this.name = name;
        this.numOfTones = numOfTons;
    }

    public String getName() {
        return name;
    }

    public int getNumOfTones() {
        return numOfTones;
    }

    static public Interval getFromNumOfTones(int num){
        for(Interval interval: Interval.values()) {
            if(interval.getNumOfTones() == num)
                return interval;
        }
        return null;
    }
}
