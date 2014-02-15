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

public enum TriadChordInterval implements EnumName {

    Minor("-", new Interval[]{Interval.UNISON, Interval.THIRD_MINOR, Interval.FIFTH}),
    Diminished("dim", new Interval[]{Interval.UNISON, Interval.THIRD_MINOR, Interval.FIFTH_DIM}),
    Augmented("aug", new Interval[]{Interval.UNISON, Interval.THIRD_MAJOR, Interval.FIFTH_AUG}),
    Major("", new Interval[]{Interval.UNISON, Interval.THIRD_MAJOR, Interval.FIFTH});

    private final String name;
    private final Interval[] intervals;

    private TriadChordInterval(String name, Interval[] intervals) {
        this.name = name;
        this.intervals = intervals;
    }

    public Interval[] getIntervals() {
        return intervals;
    }

    public String getName() {

        return name;
    }

    static public TriadChordInterval getFromName(String name){
        for(TriadChordInterval triad: TriadChordInterval.values()) {
            if(triad.getName().equals(name))
                return triad;
        }
        return null;
    }

    @Override
         public EnumName getByName(String name) {
        for(TriadChordInterval triad : TriadChordInterval.values()){
            if(triad.getName() == name)
                return triad;
        }
        return null;
    }

}
