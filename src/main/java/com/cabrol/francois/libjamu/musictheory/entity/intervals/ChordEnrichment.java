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

public enum ChordEnrichment implements EnumName{

    MAJOR_SEVEN("Maj7", new Interval[]{Interval.MAJOR_SEVEN}),
    SEVEN("7", new Interval[]{Interval.SEVEN_MINOR}),
    SIXTH("6", new Interval[]{Interval.SIXTH}),
    FLAT_NINE("9b", new Interval[]{Interval.FLAT_NINE}),
    NINE("9", new Interval[]{Interval.NINE}),
    ELEVEN("11", new Interval[]{Interval.ELEVEN}),
    THIRTEEN("13", new Interval[]{Interval.THIRTEEN});

    private final String name;
    private final Interval[] intervals;

    private ChordEnrichment(String name, Interval[] intervals) {
        this.name = name;
        this.intervals = intervals;
    }

    public String getName() {
        return name;
    }

    public Interval[] getIntervals() {
        return intervals;
    }

    static public String[] getAllNames(){
        String[] values = new String[ChordEnrichment.values().length];
        int i=0;
        for(ChordEnrichment chordEnrichment: ChordEnrichment.values()) {
            values[i] = chordEnrichment.getName();
            i++;
        }
        return values;
    }

    static public ChordEnrichment getFromName(String name){
        for(ChordEnrichment chordEnrichment: ChordEnrichment.values()) {
            if(chordEnrichment.getName().equals(name))
                return chordEnrichment;
        }
        return null;
    }

    static public ChordEnrichment getFromIntervals(Interval[] intervals){
        for(ChordEnrichment chordEnrichment: ChordEnrichment.values()) {
            for (Interval interval: intervals)
                if(chordEnrichment.getIntervals()[0].equals(interval))
                    return chordEnrichment;
        }
        return null;
    }

    @Override
    public EnumName getByName(String name) {
        for(ChordEnrichment en : ChordEnrichment.values()){
            if(en.getName() == name)
                return en;
        }
        return null;
    }

}
