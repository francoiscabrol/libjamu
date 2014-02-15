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

public class ListUtils {


    public static int getIdOfAnInfiniteList(int size, int id){

        if(id==0)
            return 0;

        int idMax = size;
        double idInInfinite;

        while (id < 0)
            id = idMax + id;

        if ( id < idMax )
            return id;

        idInInfinite = id - (Math.ceil(id / idMax) * idMax);

        return (int)idInInfinite;
    }

}
