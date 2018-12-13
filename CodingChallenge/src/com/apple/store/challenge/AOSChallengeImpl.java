package com.apple.store.challenge;

import java.util.LinkedHashSet;
import java.util.Set;

import com.apple.store.challenge.AOSChallenge.HistogramElement;

public class AOSChallengeImpl implements AOSChallenge{

	/*
    Given an array of ints, return a new array of ints. In the returned array, the value in position n represents
    the product of all the array elements except for the array value at position n. So for a three element input
    array i, the output o should be as follows: o[0] = i[1] * i[2], o[1] = i[0] * i[2], o[2] = i[0] * i[1].

    Example:
    input: [1, 2, 3]     output: [6, 3, 2]
    input: [6, 9, 2, 6]  output: [108, 72, 324, 108]
    */
	@Override
	public int[] productOfOtherPositions(int[] input) {
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

	/*
    A method that will reverse the words in a sentence.

    Example:
    input: The dog runs REALLY fast.
    output: fast REALLY runs dog The.
    */
	@Override
	public String reverseWordsInSentence(String input) {
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

	/*
    A method that will return a String consisting of the numbers from 1 to max, one number per line.
    However, for multiples of 3 use the word "Apple" instead of the number and for multiples of 5 use "Online". For
    numbers that are multiples of both 3 and 5, it should read "AppleOnline"
    */
	@Override
	public String replaceMultiplesOf3And5WithText(int max) {
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

	/*
    A method that will return a histogram of the input int array. The histogram should be in the same order as the
    first appearance of the int in the input.

    Example:
    input: [6,9,8,6,8]
    output: [[6,2], [9,1], [8,2]] (where 1st element is the value, 2nd is count)
    */
	@Override
	public Set<HistogramElement> buildHistogram(int[] input) {
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
}

class HistogramElementImpl implements HistogramElement{
	int value;
	int count;
	
	public HistogramElementImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HistogramElementImpl(int value, int count) {
		super();
		this.value = value;
		this.count = count;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int hashCode() {
		return 9 * getValue();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof HistogramElementImpl) {
			HistogramElementImpl hg = (HistogramElementImpl) obj;
			if(hg.getValue() == this.getValue()) {
				return true;
			} 
		}
		return false;
	}
}