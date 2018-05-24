package com.morganStanley.assignments;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FirstNonRepeatedCharInString {
	
	/**
	 * name fistNonRepeated
	 * param String input: the String to be used for finding target character.
	 * param Boolean ignoreCase: Tell the method if it should ignore case.
	 * return char
	 * @throws Exception 
	 * */
	public static char fistNonRepeated(String input, boolean ignoreCase) throws Exception {
		if(input == null || input.length() < 2) {
			char invalid = ' ';
			return invalid;
		}
		LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<Character, Integer>();
		char array[] = ignoreCase ? input.toLowerCase().toCharArray() : input.toCharArray();
		//Iterate through the char array to know how many characters are there for each char, in order 
		for(char key : array){
			if(lhm.get(key) == null) {
				lhm.put(key, 1);
			}else {
				int value = lhm.get(key);
				lhm.put(key, value + 1);
			}
		}
		
		int i = 0;
		while(i < array.length && lhm.get(array[i]) != 1) {
			System.out.println(i+" Length:"+array.length);
			i++;
		}
		if(i == array.length) {
			throw new Exception();
		}
		return array[i];
	}

	public static void main(String[] args) {
		String[] input = {"aaa", "SapientGlobalMarkets", "abcdwabcd"};
		Arrays.stream(input).forEach(s -> {
			try {
				System.out.println(fistNonRepeated(s, true));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
