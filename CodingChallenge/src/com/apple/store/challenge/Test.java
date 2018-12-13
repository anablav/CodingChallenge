package com.apple.store.challenge;

import java.util.LinkedHashSet;
import java.util.Set;

import com.apple.store.challenge.AOSChallenge.HistogramElement;

public class Test {
	
	public static int[] productOfOtherPositions(int[] input) {
		int[] outputArr = new int[input.length];
		int product = 1;
		for(int i=0; i<input.length; i++) {
			product = 1;
			for(int j=0; j<input.length; j++) {
				if (i!=j) {
					product = product * input[j];
				}
			}
			outputArr[i] = product;
		}
		
		return outputArr;
	}
	
	public static String reverseWordsInSentence(String input) {
		String[] wordArr = input.split(" ");
		StringBuilder reverse = new StringBuilder();
		
		for(int i=wordArr.length-1; i>=0; i--) {
			if(i!=0) {
				reverse.append(wordArr[i].replace(".", "")).append(" ");
			} else {
				reverse.append(wordArr[i]);
			}
		}
		reverse.append(".");
		return reverse.toString();
	}
	
	public static String replaceMultiplesOf3And5WithText(int max) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=max; i++) {
			if(i%3 == 0 && i%5 == 0) {
				sb.append("AppleOnline");
			} else if(i%3 == 0) {
				sb.append("Apple");
			} else if(i%5 == 0) {
				sb.append("Online");
			} else {
				sb.append(i);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static Set<HistogramElement> buildHistogram(int[] input) {
		Set<HistogramElement> set = new LinkedHashSet<>();
		for(int i=0; i<input.length; i++) {
			int count = 0;
			for(int j=0; j<input.length; j++) {
				if (input[i] == input[j]) { 
					count++;
				}
			}
			HistogramElement he = new HistogramElementImpl(input[i], count);
			set.add(he);
		}
		
		return set;
	}
	
	public static void main(String[] args) {
		int[] input = {6, 9, 2, 6};
		int[] output = productOfOtherPositions(input);
		for(int i=0; i<output.length; i++) {
			System.out.print(output[i] + ",");
		}
		
		System.out.println();
		
		String reverse = reverseWordsInSentence("The dog runs REALLY fast.");
		System.out.println(reverse);
		
		System.out.println();
		String str = replaceMultiplesOf3And5WithText(20);
		System.out.println(str);
		
		System.out.println();
		int[] inputArr = {6,9,8,6,8};
		Set<HistogramElement> buildHistogramSet = buildHistogram(inputArr);
		for(HistogramElement he : buildHistogramSet) {
			System.out.println(he.getValue() + ", " + he.getCount());
		}
	}
}
