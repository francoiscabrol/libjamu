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

package com.cabrol.francois.libjamu.midi.utils;

import com.cabrol.francois.libjamu.midi.Settings;

/**
 * Created with IntelliJ IDEA.
 * User: francois * Date: 2014-02-20
 */
public class TickUtils {

    //with a resolution of 4 ticks per quarter notes, the shortest note possible is sixteen note
    public static final int sequenceResolution = Settings.sequenceResolution;

    public static float convertTickToTock(float tick){
        return tick / sequenceResolution;
    }

    public static long convertTockToTick(float tock){
        return (long) (tock * sequenceResolution);
    }

}
