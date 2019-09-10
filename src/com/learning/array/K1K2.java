package com.learning.array;

import java.util.Arrays;

public class K1K2 {
	static int sumBetweenTwoKth(int arr[], int n, int k1, int k2) {
		Arrays.sort(arr);
		int result = 0;

		for (int i = k1; i < k2 - 1; i++)
			result += arr[i];

		return result;
	}

	public static void main(String[] args) {

		int arr[] = { 20, 8, 22, 4, 12, 10, 14 };
		int k1 = 3, k2 = 6;
		int n = arr.length;

		System.out.print(sumBetweenTwoKth(arr, n, k1, k2));
	}
}
