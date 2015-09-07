import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int j = partition(array, start, end);
			quickSort(array, start, j - 1);
			quickSort(array, j + 1, end);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[low];
		int i = low;
		int j = high + 1;

		while (true) {
			while (compare(array[++i], pivot)) {
				if (i == high)
					break;
			}

			while (compare(pivot, array[--j])) {
				if (j == low)
					break;
			}

			if (i >= j) {
				break;
			}

			swap(array, i, j);
		}

		swap(array, low, j);
		return j;
	}

	private static boolean compare(int i, int j) {
		return i < j ? true : false;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 1, 2, 0, 1, 2, 1, 2 };
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}