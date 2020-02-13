package service.util;

import java.util.List;

import daten.teilnehmer.PersonAusBuilder;

public class ServiceSortiereAlter {

	

	public static int[] sort(List<PersonAusBuilder> liste) {
		int[] intArray = new int[15];
		for (int i = 0; i < liste.size(); i++) {
			int alter = liste.get(i).getAlter();
			intArray[i] = alter;
		}

		return intArray;
	}

	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

	}


	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

	}

}
