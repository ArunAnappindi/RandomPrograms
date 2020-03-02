/**
 * 
 */
package main.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 503054866
 *
 */
public class PopulationCalc {
	
	private static Map<Integer, Integer> birthYearToCountMap = new HashMap<Integer, Integer>() ;

	private static Map<Integer, Integer> deathYearToCountMap = new HashMap<Integer, Integer>() ;

	private static void birthCountCalc(int[] birthYear) {
		for (int i = 0; i < birthYear.length; i++) {
			if (birthYearToCountMap.get(birthYear[i]) != null) {
				birthYearToCountMap.put(birthYear[i], birthYearToCountMap.get(birthYear[i]) + 1);
			} else {
				birthYearToCountMap.put(birthYear[i], 1);
			}

		}
	}

	private static void deathCountCalc(int[] deathYear) {
		for (int i = 0; i < deathYear.length; i++) {
			if (deathYearToCountMap.get(deathYear[i]) != null) {
				deathYearToCountMap.put(deathYear[i], deathYearToCountMap.get(deathYear[i]) + 1);
			} else {
				deathYearToCountMap.put(deathYear[i], 1);
			}

		}
	}

	public static void calcYearWhenPopuRed() {

		Set<Integer> deathsInCurrYear = deathYearToCountMap.keySet();
		Iterator<Integer> deathIter = deathsInCurrYear.iterator();
		while (deathIter.hasNext()) {
			int year = deathIter.next();
			int birthYear = birthYearToCountMap.get(year+1)!=null?birthYearToCountMap.get(year+1):0;
			if(deathYearToCountMap.get(year) > birthYear && birthYear != 0 ) {
				System.out.println("population reduced in  " + year);
			}
			if(deathYearToCountMap.get(year) > 0 && birthYear == 0 ) {
				System.out.println("population reduced in  " + (year +1));
			}
		}

	} 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] birthYear = {1902, 1941, 2004, 1957, 1989, 1909, 1918, 1913, 1979, 1961, 1977, 1909};
		int[] deathYear = {1991, 1978, 2008, 2005, 2010, 2002, 2003, 1991};
		birthCountCalc(birthYear);
		deathCountCalc(deathYear);
		calcYearWhenPopuRed();
	}

}
