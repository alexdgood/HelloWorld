/* Author: Alex Good
 * Date: 2/9/15
 * Merge Sort
 */

import java.util.Scanner;


public class ArrayMerge {

	public static void main(String[] args) {
		int size,i;
		long startTime,endTime,runTime;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Input how many random numbers would you like to sort: ");
		size = kb.nextInt();
		
		int[] randomNums = new int[size];
		
		for (i=0;i<size;i++)
			randomNums[i] = (int)(Math.random()*100);
			
		startTime = System.currentTimeMillis();
		randomNums = mergeSort(randomNums);
		endTime = System.currentTimeMillis();
		
		runTime = endTime - startTime;
		
		System.out.println("It took "+runTime+" millisecond(s) to merge sort an array of "+size+" random numbers");
		

		}
	
	public static int[] mergeSort(int[] list) {
		int n = 0,a,b;
		
		if (list.length<=1)
			return list;
		int[] lista = new int[list.length/2];
		int[] listb = new int[list.length - lista.length];
		
		for (a=0;a<lista.length;a++) {
			lista[a] = list[n++];
		}
		
		for (b=0;b<listb.length;b++) {
			listb[b] = list[n++];
		}
		
		lista = mergeSort(lista);
		listb = mergeSort(listb);
		list = merge(lista,listb);
		return list;
	}
		

	
	public static int[] merge(int[] listA, int[] listB) {
		int[] result = new int[listA.length + listB.length];
		int a=0,b=0,r=0;
		
		while (a<listA.length && b<listB.length) {
			if (listA[a] <= listB[b])
				result[r++] = listA[a++];
			else
				result[r++] = listB[b++];
		}
		while (a<listA.length)
			result[r++] = listA[a++];
		
		while (b<listB.length)
			result[r++] = listB[b++];
		
		return result;
	}

}
