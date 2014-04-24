package google;

import java.util.Arrays;

//The input is a sequence x1,x2,...,xn of integers in an arbitrary order, and another sequence 
//a1,a2,..,an of distinct integers from 1 to n (namely a1,a2,...,an is a permutation of 
//1, 2,..., n). Both sequences are given as arrays. Design an 0(n logn) algorithm to order 
//the first sequence according to the order imposed by the permutation. In other words, for 
//each i, Xi should appear in the position given in ai. For example, if x = 17, 5, 1,9, and a = 
//3, 2, 4, 1, then the outcome should be x = 9, 5, 17, 1. The algorithm should be in-place, so 
//you cannot use an additional array.

public class SequenceSort {
	public static void main(String[] args) {
		int[] a = { 3, 2, 4, 1 };
		int[] x = { 17, 5, 1, 9 };
		sort(a, x);
		System.out.print(Arrays.toString(x));
	}

	static void sort(int[] a, int[] x) {
		for (int i = 0; i < a.length; i++) {
			while (a[i] - 1 != i)
				doubleSwap(a, a[i] - 1, i, x);
		}
	}

	static void doubleSwap(int[] a, int i, int j, int[] x) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
		aux = x[i];
		x[i] = x[j];
		x[j] = aux;
	}
}
