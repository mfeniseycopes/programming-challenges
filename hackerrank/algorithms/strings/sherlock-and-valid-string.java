// Sherlock and the Valid String
// https://www.hackerrank.com/challenges/sherlock-and-valid-string

// Sherlock and the Valid String
// https://www.hackerrank.com/challenges/sherlock-and-valid-string

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static String isValid(String s){

		HashMap<Character, Integer> charFreqs = new HashMap<Character, Integer>();

    int maxCount = 0;

		for (int i = 0; i < s.length(); i++) {
			Character c = new Character(s.charAt(i));
			Integer count = charFreqs.get(s.charAt(i));

			charFreqs.put(c, count == null ? 1 : count + 1);

      count = charFreqs.get(s.charAt(i));
      if (count > maxCount) maxCount = count;
		}

    int requiredFreq, exceptionFreq;
    boolean exceptionTaken = false;
		Object[] chars = charFreqs.keySet().toArray();

    // the "exception" character will have 1 more than every other
    if (maxCount == (s.length() / charFreqs.size()) + 1) {
      // an exception to the rule
      if (maxCount == 2) {
        requiredFreq = 2;
        exceptionFreq = 1;
      } else {
        requiredFreq = maxCount - 1;
        exceptionFreq = maxCount;
      }

    // there is no "exception" character (count even for all)
    } else if (maxCount == (s.length() / charFreqs.size())) {
      requiredFreq = maxCount;
      exceptionFreq = 0;
      exceptionTaken = true;

    // the "exception" character will have a count of 1
    } else {
      requiredFreq = s.length() / (charFreqs.size() - 1);
      exceptionFreq = 1;
    }

    for (int i = 0; i < chars.length; i++) {
      Integer freq = charFreqs.get(chars[i]);

      if (freq != requiredFreq) {
        if (!exceptionTaken && freq == exceptionFreq) exceptionTaken = true;
        else return "NO";
      }
    }

    return "YES";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = isValid(s);
		System.out.println(result);
	}
}
