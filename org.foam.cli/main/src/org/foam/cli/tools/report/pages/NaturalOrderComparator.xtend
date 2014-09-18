package org.foam.cli.tools.report.pages;

/*
Based on the NaturalOrderComparator.java -- Perform 'natural order' comparisons of strings in Java.
Copyright (C) 2003 by Pierre-Luc Paour <natorder@paour.com>

Based on the C version by Martin Pool, of which this is more or less a straight conversion.
Copyright (C) 2000 by Martin Pool <mbp@humbug.org.au>

This software is provided 'as-is', without any express or implied
warranty.  In no event will the authors be held liable for any damages
arising from the use of this software.

Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute it
freely, subject to the following restrictions:

1. The origin of this software must not be misrepresented; you must not
claim that you wrote the original software. If you use this software
in a product, an acknowledgment in the product documentation would be
appreciated but is not required.
2. Altered source versions must be plainly marked as such, and must not be
misrepresented as being the original software.
3. This notice may not be removed or altered from any source distribution.
*/

import java.io.Serializable
import java.util.Comparator

public class NaturalOrderComparator implements Comparator<String>, Serializable {

    def int compareRight(String a, String b) {
        var bias = 0
        var i = 0

        // The longest run of digits wins. That aside, the greatest
        // value wins, but we can't know that it will until we've scanned
        // both numbers to know that they have the same magnitude, so we
        // remember it in BIAS.
        var char ca = ' '
        var char cb = ' '
        while (ca != 0 || cb != 0) {
            ca = charAt(a, i)
            cb = charAt(b, i)

            if (!Character.isDigit(ca) && !Character.isDigit(cb)) {
                return bias
            } else if (!Character.isDigit(ca)) {
                return -1
            } else if (!Character.isDigit(cb)) {
                return 1
            } else if (ca < cb) {
                if (bias == 0)
                    bias = -1
            } else if (ca > cb) {
                if (bias == 0)
                    bias = 1
            }
            // else -> ca == cb -> continue
            i += 1
        }
        
        return bias
    }
    
    override compare(String o1, String o2) {
    	if (o1 == null) {
    		return 1
    	}
    	if (o2 == null) {
    		return -1
    	}
    	
        val a = o1.toString
        val b = o2.toString

        var ia = 0; var ib = 0
        var nza = 0; var nzb = 0
        var char ca; var char cb
        var int result

        while (true) {
            // only count the number of zeroes leading the last number compared
            nza = nzb = 0;

            ca = charAt(a, ia)
            cb = charAt(b, ib)

            // skip over leading spaces or zeros
            while (Character.isSpaceChar(ca) || ca == '0') {
                if (ca == '0') {
                    nza++
                } else {
                    // only count consecutive zeroes
                    nza = 0
                }

                ca = charAt(a, ia += 1)
            }

            while (Character.isSpaceChar(cb) || cb == '0') {
                if (cb == '0') {
                    nzb++
                } else {
                    // only count consecutive zeroes
                    nzb = 0;
                }

                cb = charAt(b, ib += 1)
            }

            // process run of digits
            if (Character.isDigit(ca) && Character.isDigit(cb)) {
                if ((result = compareRight(a.substring(ia), b.substring(ib))) != 0) {
                    return result
                }
            }

            if (ca == 0 && cb == 0) {
                // The strings compare the same. Perhaps the caller
                // will want to call strcmp to break the tie.
                return nza - nzb
            }

            if (ca < cb) {
                return -1
            } else if (ca > cb) {
                return 1
            }

			ia += 1
			ib += 1
        }
    }

    def static char charAt(String s, int i) {
        if (i >= s.length()) {
            return 0 as char
        } else {
            return s.charAt(i)
        }
    }

}
