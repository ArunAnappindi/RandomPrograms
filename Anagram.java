package main.java;

import java.util.HashSet;
import java.util.Set;

public class Anagram {

	
	
	/**
	 * Approach 1: Using Array (Similar to HashMap)
	 * Instead of making use of a special HashMap data structure just to store the frequency of occurence of characters,
	 * we can use a simpler array data structure to store the frequencies.
	 * Then we just need to compare the two map is the same or not.
	 */
	   /* public List<Integer> findAnagrams(String s) {
	        List<Integer> rst = new ArrayList<>();
	        if (s == null || s.length() == 0 || s.length() < p.length()) {
	            return rst;
	        }

	        int[] map_p = new int[26];
	        for (int i = 0; i < p.length(); i++) {
	            map_p[p.charAt(i) - 'a']++;
	        }

	        for (int i = 0; i < s.length() - p.length(); i++) {
	            int[] map_s = new int[26];
	            for (int j = 0; j < p.length(); j++) {
	                map_s[s.charAt(i+j) - 'a']++;
	            }
	            if (isMatch(map_p, map_s)) {
	                rst.add(i);
	            }
	        }
	        return rst;
	    }

	    public boolean isMatch(int[] arr1, int[] arr2) {
	        for (int i = 0; i < arr1.length; i++) {
	            if (arr1[i] != arr2[i]) {
	                return false;
	            }
	        }
	        return true;
	    }*/
		public static String[] vowelMap = new String[5];
		
		
	
		public static void main(String[] args) {
			
			vowelMap[0] = "A";
			vowelMap[0] = "E";
			vowelMap[0] = "I";
			vowelMap[0] = "O";
			vowelMap[0] = "U";
	        Set<String> s1 =  stringCombinations("BAR");
	        System.out.println(s1.size());
	    }
	    
	    public static boolean validate(String word) {
	    	 String firstLetter = word.substring(0, 1);
	    	 for(int i =0; i < vowelMap.length; i++) {
	    		 if(firstLetter.toUpperCase().equals(vowelMap[i])) {
	    			 return false;
	    		 }
	    	 }
	    	return true;
	    }
	    
	    public static boolean checkVowel(String field) {
	    	 char[] vowel = {'a', 'e', 'i', 'o', 'u'};
	         while(true){
	             int f = 0;
	             
	             String word = field;
	             int length = word.length();
	             char[] ch = word.toCharArray();
	             for (int i = 0; i < length-2; i++) {
	                 for (int j = 0; j < 5; j++) {
	                     if ((ch[i] == vowel[j]) && (ch[i + 1] == vowel[j])) {
	                         f++;
	                         break;
	                     }
	                 }
	                 if (f == 1) {
	                	return false; 
	                 } else {
	                	 continue;
	                 }
	             }
	             return true;
	             }
	    }
	    
	    public static boolean checkConsonant(String field) {
	    	 char[] consonant = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's','t', 'y', 'v', 'w', 'x','z'};
	         while(true){
	             int f = 0;
	             
	             String word = field;
	             int length = word.length();
	             char[] ch = word.toCharArray();
	             for (int i = 0; i < length-2; i++) {
	                 for (int j = 0; j < 5; j++) {
	                     if ((ch[i] == consonant[j]) && (ch[i + 1] == consonant[j])) {
	                         f++;
	                         break;
	                     }
	                 }
	                 if (f == 1) {
	                	return false; 
	                 } else {
	                	 continue;
	                 }
	             }
	             return true;
             }
	    }
	    
    public static Set<String> stringCombinations(String str) {
		Set<String> result = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			result.add("");
			return result;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		System.out.println(rem);
		Set<String> words = stringCombinations(rem);
		System.out.println(words.size());
		for (String newString : words) {
			System.out.println("++"+newString);
			for (int i = 0; i <= newString.length(); i++) {
				String newString1 = charAdd(newString, firstChar, i);
				System.out.println("--"+newString1);
				if(validate(newString1) && checkVowel(newString1) && checkConsonant(newString1)) {
					result.add(newString1);
				}
			}
		}
		return result;
	}
	 
	public static String charAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
}
