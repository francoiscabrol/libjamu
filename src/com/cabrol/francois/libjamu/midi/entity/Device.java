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


import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;
import java.util.HashMap;
import java.util.Map;


public final class Device {

    public final String name;

    public final String midiName;

    public MidiDevice midiDevice;

    public Receiver receiver;

    public boolean useClockSynchronization;

    public Device(String name, String midiName, boolean useClockSynchronization) {
        this.name = name;
        this.midiName = midiName;
        this.useClockSynchronization = useClockSynchronization;
    }

    public void open() {
        try {
            MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
            System.out.println(infos);
            Map<String, MidiDevice.Info> map = new HashMap<String, MidiDevice.Info>(infos.length);

            for (MidiDevice.Info info : infos) {
                map.put(info.getName(), info);
            }

            MidiDevice.Info info = map.get(midiName);

            if (info != null) {
                try {
                    MidiDevice midiDevice = MidiSystem.getMidiDevice(info);
                    if (midiDevice.getReceiver() != null) {
                        this.midiDevice = midiDevice;
                    }
                } catch (Exception e) {

                }
            }

            midiDevice.open();
            receiver = midiDevice.getReceiver();
            System.out.println("The MIDI device \"" + name + " is open");
        } catch (Exception e) {
            throw new RuntimeException("Impossible to open MIDI device", e);
        }
    }

    public void close() {

        if (midiDevice != null) {
            midiDevice.close();
            midiDevice = null;
            receiver = null;
        }
    }

}