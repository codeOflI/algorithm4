package com.mars.algorithms.chapter3_searching.chapter3_5_applications;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Lenovo
 */
public class WhiteFilter {

	public static void main(String[] args) {
		SET<String> set = new SET<String>();
		In in = new In(args[0]);
		while (!in.isEmpty()) {
			set.add(in.readString());
		}
		while (!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if (set.contains(word)) {
				StdOut.print(word + " ");
			}
		}
	}
}
