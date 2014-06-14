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

public class RhythmicNote implements Serializable{

    private static final long serialVersionUID = -2133041858618576129L;

    float start;   //in tock
    float duration;      //in tock
    private int velocity = 60;

    public RhythmicNote(float start, float duration) {
        this.start = start;
        this.duration = duration;
    }

    /**
     * Copy constructor.
     */
    public RhythmicNote(RhythmicNote rhythmicNote) {
        this(rhythmicNote.getStart(), rhythmicNote.getDuration());
    }

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getNumBeat(){
         return (int)Math.floor(start);
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return "RhythmicNote{" +
                "start=" + start +
                ", duration=" + duration +
                '}';
    }
}
