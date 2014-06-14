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

package com.cabrol.francois.libjamu.musictheory.utils;

import com.cabrol.francois.libjamu.musictheory.entity.intervals.ScaleInterval;
import com.cabrol.francois.libjamu.musictheory.entity.scaleNote.*;

import java.util.ArrayList;
import java.util.List;


public class ScalesUtils {
	
	private static ScalesUtils INSTANCE = null;
	
//	public static int tetracordes[][];
//	public static int scale[][];

    //define number of scales
//    public static int numScale = 22;

//	public static String scaleNameTab[];

	public ScalesUtils(){
		/*
		//define the tetracordes list
		tetracordes = new int[13][3];
		tetracordes[0] = new int[] {2, 2, 1}; //majeur
		tetracordes[1] = new int[] {2, 1, 2}; //mineur
		tetracordes[2] = new int[] {1, 2, 2}; //phrygien
		tetracordes[3] = new int[] {2, 2, 2}; //lydien
		tetracordes[4] = new int[] {1, 2, 1}; //diminu�
		tetracordes[5] = new int[] {1, 3, 1}; //harmo
		tetracordes[6] = new int[] {2, 1, 3}; //213
		tetracordes[7] = new int[] {3, 1, 2}; //312
		tetracordes[8] = new int[] {3, 1, 1}; //311
		tetracordes[9] = new int[] {3, 2, 1}; //321
        tetracordes[10] = new int[] {2, 3, 1}; //231
        tetracordes[11] = new int[] {2, 1, 3}; //213
        tetracordes[12] = new int[] {2, 1, 2}; //212
		
		//link the scales' name and two tetracordes by scale
		scale = new int[numScale][2];
		scale[0] = new int[] {0, 0};	//majeure
		scale[1] = new int[] {1, 2};	//mineure
		scale[2] = new int[] {2, 2};	//phrygien
		scale[3] = new int[] {3, 0};	//lydien
		scale[4] = new int[] {0, 1};	//mixolydien
		scale[5] = new int[] {1, 2};	//�olien
		scale[6] = new int[] {1, 0};	//m�lodique
		scale[7] = new int[] {3, 1};	//bartol
		scale[8] = new int[] {1, 5};	//harmonique
		scale[9] = new int[] {6, 1};	//roumain
		scale[10] = new int[] {5, 2};	//phrygien espagnol
		scale[11] = new int[] {0, 3};	//arabe
		scale[12] = new int[] {5, 7};	//oriental
		scale[13] = new int[] {8, 3};	//orient 2
		scale[14] = new int[] {5, 3};	//orient 3
		scale[15] = new int[] {5, 9};	//arabesque
        scale[16] = new int[] {5, 10};	//persan
        scale[17] = new int[] {5, 5};	//bohemien
        scale[18] = new int[] {11, 5};	//tzigane
        scale[19] = new int[] {11, 2};	//gitan hongrois
        scale[20] = new int[] {5, 12};	//gypsy
        scale[21] = new int[] {8, 8};	//blues
		
		//define the scales' name
		scaleNameTab = new String[numScale];
		scaleNameTab[0] = "major";
		scaleNameTab[1] = "minor";
		scaleNameTab[2] = "phrygien"; 
		scaleNameTab[3] = "lydien";
		scaleNameTab[4] = "mixolydien";
		scaleNameTab[5] = "�olien";
		scaleNameTab[6] = "m�lodique";
		scaleNameTab[7] = "Bartok";
		scaleNameTab[8] = "harmonique";
		scaleNameTab[9] = "roumain";
		scaleNameTab[10] = "phrygien espagnol";
		scaleNameTab[11] = "arabe";
		scaleNameTab[12] = "oriental";
		scaleNameTab[13] = "orient 2";
		scaleNameTab[14] = "orient 3";
		scaleNameTab[15] = "arabesque";
        scaleNameTab[16] = "persan";
        scaleNameTab[17] = "bohemien";
        scaleNameTab[18] = "tzigane";
        scaleNameTab[19] = "gitan hongrois";
        scaleNameTab[20] = "gypsy";
        scaleNameTab[21] = "blues";
		*/
	}
	
    public synchronized static ScalesUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScalesUtils();
        }
        return INSTANCE;
    }

    public static ArrayList<ScaleNote> getScaleNotesFromName(String name){

        String[] tempRegex = new String[ScaleInterval.values().length];
        for (int i = 0; i < ScaleInterval.values().length; i++) {
            tempRegex[i] = ScaleInterval.values()[i].name();
        }
        String scalesNameRegex = RegexUtils.constructRegexFromATabWithBrakets(tempRegex);
        String scaleName = RegexUtils.getFirstMatchedStringFromRegex(scalesNameRegex, name);
        String keynote = RegexUtils.getFirstMatchedStringFromRegex("[C|D|E|F|G|A|B][b?|#?]?", name);
        int keynoteKey = NotesUtils.getKeyMidiNote(keynote);
        //List<ScaleInterval> scaleList = Arrays.asList(ScaleInterval.values());
        ScaleInterval scaleInterval = ScaleInterval.valueOf(scaleName);
        int[] scale = getScaleNotes(keynoteKey, scaleInterval.getIntervals());

        ArrayList<ScaleNote> scaleNotes = new ArrayList<ScaleNote>();

        for (int aScale : scale) {
            scaleNotes.add(new ScaleNote(aScale));
        }

        return scaleNotes;
    }

	public static int[] getScaleIntervals(int scaleId){
		/*
		 * return a table of intervals between the corresponding scale's notes
		 */
        return ScaleInterval.values()[scaleId].getIntervals();
	}
	
	public static int[] getScaleNotes(int keynote, int[] scaleIntervals){
		/*
		 * return a table of scale's notes generate with the fundamental note and the scale's intervals
		 */
		int[] scaleNotes = new int[scaleIntervals.length];
		scaleNotes[0] = keynote;
		for (int f=1; f< scaleNotes.length; f++){
			scaleNotes[f] = scaleNotes[f-1]+scaleIntervals[f-1];
			if (scaleNotes[f]>11)
				scaleNotes[f] = scaleNotes[f]-12;
		}
		return scaleNotes;
	}
//
//	public static int [] getScaleNotes(int keynote, int scaleId){
//		int[] scaleIntervals = getScaleIntervals(scaleId);
//		return getScaleNotes(keynote, scaleIntervals);
//	}
//
//	public static String getScaleName(int keynote, int scaleId){
//		String name = NotesUtils.everyTonicsOnlyFlat[keynote];
//		getInstance();
//		name += " " + ScalesUtils.scaleNameTab[scaleId];
//
//		return name;
//	}
//
//    public static String getScaleNameById(int id){
//        if (getInstance().scaleNameTab != null)
//            return getInstance().scaleNameTab[id];
//        else
//            return null;
//    }

    public static List<String> getScalesNamesList(){

        List<String> scales = new ArrayList<String>();
        String[] listScales = new String[ScaleInterval.values().length];
        for (int i = 0; i < ScaleInterval.values().length; i++) {
            listScales[i] = ScaleInterval.values()[i].name();
        }
        for (int i = 0; i < listScales.length; i++) {
            for (int d = 0; d < NotesUtils.everyTonicsOnlySharp.length; d++) {
                scales.add(NotesUtils.everyTonicsOnlySharp[d] + " " + listScales[i]);
            }
        }

        return scales;
    }

    //--------------------- refactored ----------------------

    public static Chord getChordByScaleDegree(int degree, AbstractScale scale, boolean enriched){

        Mode mode = scale.getMode(degree);

        ScaleNote root = mode.getScaleNote(0);
        ScaleNote triad = mode.getScaleNote(2);
        ScaleNote fifth = mode.getScaleNote(4);
        Chord chord = new Chord(root, triad, fifth);
        if (enriched){
            ScaleNote enrichisment = mode.getScaleNote(6);
            chord.addNote(enrichisment);
        }

        return chord;
    }

    public static List<Scale> getScalesList(){
        List<String> scalesName = getScalesNamesList();
        ArrayList<Scale> scales = new ArrayList<Scale>();
        for (String scaleName: scalesName)
            scales.add(new Scale(scaleName));
        return scales;
    }

    public static List<Scale> getScalesFromNotes(List<ScaleNote> notes){

        List<Scale> scales = new ArrayList<Scale>();

        List<String> listScaleName = ScalesUtils.getScalesNamesList();
        for(String scaleName:listScaleName){
            Scale scale = new Scale(scaleName);
            if (scale.isIn(notes)){
                scales.add(scale);
            }
        }


        return scales;
    }

}
