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

public enum ScaleInterval {

    major (TetraChord.major, TetraChord.major),
    minor (TetraChord.minor, TetraChord.phrygian),
    mixolydien (TetraChord.major, TetraChord.minor),
    bartok(TetraChord.lydian, TetraChord.minor),
    harmonic(TetraChord.minor, TetraChord.harmonic),
    melodic(TetraChord.minor, TetraChord.major),
    arab(TetraChord.major, TetraChord.lydian),
    orient3(TetraChord.harmonic, TetraChord.lydian),
    bohemian(TetraChord.harmonic, TetraChord.harmonic),

    pentatonicMinor(new int[]{3, 2, 2, 3, 2}),
    pentatonic(new int[]{2, 2, 3, 2, 3}),

    diminished(new int []{1, 2, 1, 2, 1, 2, 1, 2}),

    parTon(new int[]{2, 2, 2, 2, 2, 2});

    //scale[2] = new int[] {2, 2};	//phrygien
    //scale[3] = new int[] {3, 0};	//lydien
    //scale[4] = new int[] {0, 1};	//mixolydien
    //scale[5] = new int[] {1, 2};	//�olien
    //scale[9] = new int[] {6, 1};	//roumain
    //scale[10] = new int[] {5, 2};	//phrygien espagnol
    //scale[12] = new int[] {5, 7};	//oriental
    //scale[13] = new int[] {8, 3};	//orient 2
    //scale[15] = new int[] {5, 9};	//arabesque
    //scale[16] = new int[] {5, 10};	//persan
    //scale[18] = new int[] {11, 5};	//tzigane
    //scale[19] = new int[] {11, 2};	//gitan hongrois
    //scale[20] = new int[] {5, 12};	//gypsy
    //scale[21] = new int[] {8, 8};	//blues

    private final int[] intervals;

    private ScaleInterval(TetraChord first, TetraChord second) {
        //copy des deux tetra
        int[] firstTetra = first.getIntervals();
        int[] secondTetra = second.getIntervals();
        int[] intervals = new int[firstTetra.length + 1 + secondTetra.length];

        int somme = 0;
        for(int i : firstTetra)
            somme += i;
        for(int i : secondTetra)
            somme += i;

        int rest = 12 - somme;
        intervals[firstTetra.length] = rest;

        System.arraycopy(firstTetra, 0, intervals, 0, firstTetra.length);
        System.arraycopy(secondTetra, 0, intervals, firstTetra.length + 1, secondTetra.length);
        this.intervals = intervals;
    }

    private ScaleInterval(int[] intervalsInSemiTones){
        this.intervals = intervalsInSemiTones;
    }

    public int[] getIntervals() {
        return intervals;
    }

}
