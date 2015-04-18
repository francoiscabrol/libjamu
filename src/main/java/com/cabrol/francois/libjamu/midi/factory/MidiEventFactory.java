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

package com.cabrol.francois.libjamu.midi.factory;

import com.cabrol.francois.libjamu.midi.entity.MidiNoteEvent;
import com.cabrol.francois.libjamu.midi.utils.TickUtils;
import com.cabrol.francois.libjamu.musictheory.entity.note.Note;

import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: francois * Date: 2014-02-20
 */
public class MidiEventFactory {

    public static List<MidiNoteEvent> getMidiNoteEvents(Note note){

        ArrayList<MidiNoteEvent> midiNoteEvents = new ArrayList<MidiNoteEvent>();
        midiNoteEvents.add(new MidiNoteEvent(ShortMessage.NOTE_ON, note.getRhythmicNote().getVelocity(), TickUtils.convertTockToTick(note.getRhythmicNote().getStart()), note.getKey().getMidiKey()));
        midiNoteEvents.add(new MidiNoteEvent(ShortMessage.NOTE_OFF, note.getRhythmicNote().getVelocity(), TickUtils.convertTockToTick(note.getRhythmicNote().getStart())+TickUtils.convertTockToTick(note.getRhythmicNote().getDuration()), note.getKey().getMidiKey()));
        return midiNoteEvents;
    }
}
