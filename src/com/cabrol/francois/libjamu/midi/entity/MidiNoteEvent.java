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

package com.cabrol.francois.libjamu.midi.entity;

public class MidiNoteEvent {

    private int noteMessageType;
    private int velocity;
    private long tick; //tick position
    private int key; //midi key if note on

    public MidiNoteEvent(int noteMessageType, int velocity, long tick, int key) {
        this.noteMessageType = noteMessageType;
        this.velocity = velocity;
        this.tick = tick;
        this.key = key;
    }

    public int getVelocity() {
        return velocity;
    }

    public long getTick() {
        return tick;
    }

    public int getKey() {
        return key;
    }

    public int getNoteMessageType() {
        return noteMessageType;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setTick(long tick) {
        this.tick = tick;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setNoteMessageType(int noteMessageType) {
        this.noteMessageType = noteMessageType;
    }

    @Override
    public String toString() {
        return "MidiNoteEvent{" +
                "noteMessageType=" + noteMessageType +
                ", velocity=" + velocity +
                ", tick=" + tick +
                ", key=" + key +
                '}';
    }
}
