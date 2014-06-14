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

import com.cabrol.francois.libjamu.musictheory.entity.intervals.EnumName;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	
	public static String constructRegexFromATab( String[] tab ){
		
		String regex = "[";
		
		for (int i = 0; i < tab.length-1; i++) {
			String string = tab[i];
			regex += string + "|";
		}
		regex += tab[tab.length-1] + "]";
		
		return regex;
	}

    public static String constructRegexFromATabWithBrakets( String[] tab ){

		String regex = "(";

        for (int i = 0; i < tab.length; i++) {
            if(tab[i] == "") tab[i] = "null";
        }

		for (int i = 0; i < tab.length-1; i++) {
			String string = tab[i];
			regex += string + "|";
		}
		regex += tab[tab.length-1] + ")";

		return regex;
	}

    public static String constructRegexFromEnum( EnumName[] e ){

        String[] tempRegex = new String[e.length];
        for (int i = 0; i < e.length; i++) {
            tempRegex[i] = e[i].getName();
        }

        return RegexUtils.constructRegexFromATabWithBrakets(tempRegex);
    }
	
	public static String getFirstMatchedStringFromRegex(String regex, String name){

        String root = null;
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            while (matcher.find()) {
              break;
            }
            root = matcher.group(0);
		} catch (Exception e) {
			return null;
		}
	    return root;
	}

    public static List<String> getAllMatchedStringFromRegex(String regex, String name){

        List<String> results = new ArrayList();
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            while (matcher.find()) {
                results.add(matcher.group(0));
            }
        } catch (Exception e) {
            return null;
        }
        return results;
    }

}
