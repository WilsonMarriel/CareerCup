package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Write a function to find all the combinations of three numbers that sum to zero 
//Sample input: 
//[2, 3, 1, -2, -1, 0, 2, -3, 0] 
//Sample output: 
//2, -2, 0 
//1, -1, 0 
//3, -2, -1 
//3, 0, -3 
//3, 0, -3

public class SumOfThreeEqualsZero {
	static void getSumZero(Integer[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer key = nums[i];
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}

		List<String> list = new ArrayList<String>();
		// to get just one permutation of (i, j k) we will assume i <= j <= k
		for (Integer i : map.keySet()) {
			for (Integer j : map.keySet()) {
				if (j >= i) {
					if (i == j && i == 0) {
						// i == j == k == 0 case
						int count_i = map.get(i);
						int count_i_choose_3 = count_i * (count_i - 1) * (count_i - 2) / 6;
						for (int m = 0; m < count_i_choose_3; m++) {
							list.add("[0, 0, 0]");
						}
					} else if (i == j) {
						// i == j < k case
						Integer k = -(i + j);
						if (k > j) {
							int count_i = map.get(i);
							int count_i_choose_2 = count_i * (count_i - 1) / 2;

							if (map.containsKey(k)) {
								int times = count_i_choose_2 * map.get(k);
								for (int m = 0; m < times; m++) {
									list.add("[" + i + ", " + j + ", " + k + "]");
								}
							}
						}
					} else if (j > i) {
						Integer k = -(i + j);
						if (k == j) {
							// i < j == k case
							int count_j = map.get(j);
							int count_j_choose_2 = count_j * (count_j - 1) / 2;
							int times = count_j_choose_2 * map.get(i);
							for (int m = 0; m < times; m++) {
								list.add("[" + i + ", " + j + ", " + k + "]");
							}
						} else if (k > j && map.containsKey(k)) {
							// i < j < k case
							int times = map.get(i) * map.get(j) * map.get(k);
							for (int m = 0; m < times; m++) {
								list.add("[" + i + ", " + j + ", " + k + "]");
							}
						}
					}
				}
			}
		}
		for (String str : list) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 2, 3, 1, -2, -1, 0, 2, -3, 0 };
		getSumZero(a);
	}

}
