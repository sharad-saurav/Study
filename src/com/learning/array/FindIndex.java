package com.learning.array;

class FindIndex {
	public static void main(String[] args) {
		int arr[] = { 3, 4, 3, 5, 2, 3, 4, 3, 1, 5 };
		int n = arr.length;

		int idxOfEle = 5;
		System.out.println(getIndexInSortedArray(arr, n, idxOfEle));
	}

	static int getIndexInSortedArray(int arr[], int n, int idx) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < arr[idx])
				result++;
			if (arr[i] == arr[idx] && i < idx)
				result++;
		}
		return result;
	}
}
