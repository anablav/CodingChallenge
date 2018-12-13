package com.apple.store.challenge;

import java.util.Set;

public interface AOSChallenge {

   /*
       Given an array of ints, return a new array of ints. In the returned array, the value in position n represents
       the product of all the array elements except for the array value at position n. So for a three element input
       array i, the output o should be as follows: o[0] = i[1] * i[2], o[1] = i[0] * i[2], o[2] = i[0] * i[1].

       Example:
       input: [1, 2, 3]     output: [6, 3, 2]
       input: [6, 9, 2, 6]  output: [108, 72, 324, 108]
    */
   int[] productOfOtherPositions(int[] input);


   /*
       A method that will reverse the words in a sentence.

       Example:
       input: The dog runs REALLY fast.
       output: fast REALLY runs dog The.
    */
   String reverseWordsInSentence(String input);


   /*
       A method that will return a String consisting of the numbers from 1 to max, one number per line.
       However, for multiples of 3 use the word "Apple" instead of the number and for multiples of 5 use "Online". For
       numbers that are multiples of both 3 and 5, it should read "AppleOnline"
    */
   String replaceMultiplesOf3And5WithText(int max);


   /*
       A method that will return a histogram of the input int array. The histogram should be in the same order as the
       first appearance of the int in the input.

       Example:
       input: [6,9,8,6,8]
       output: [[6,2], [9,1], [8,2]] (where 1st element is the value, 2nd is count)
    */
   Set<HistogramElement> buildHistogram(int[] input);

   interface HistogramElement {
       int getValue();
       int getCount();
   }
}