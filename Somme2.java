package algoTP1;


//TP4 Algorithmique et Complexite 2021-2022

//Nom:HADJAZI
//Prenom: Mohammed Hisham
//Specialite:   RSSI      Groupe: 01

//Nom:Ameur
//Prenom: Wassim Malik
//Specialite:   RSSI      Groupe: 01



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Somme2 {
	static long cpt = 0;

	// The vector subarray stores current subset.
	static void Sum_Exist(int values[], int n, Vector<Integer> subarray, int target, int target2) {
		cpt++;
		// If remaining target is 0, then print all
		// values of current subset.
		if (target == 0) {
			System.out.println("The Sum of subset " + Arrays.toString(subarray.toArray()) + " = " + target2);
			return;
		}

		// If no remaining values,
		if (n == 0)
			return;

		// We consider two cases for every element.
		// a) We do not include last element.
		// b) We include last element in current subset.
		Sum_Exist(values, n - 1, subarray, target, target2);
		Vector<Integer> subarray2 = new Vector<Integer>(subarray);
		subarray2.add(values[n - 1]);
		Sum_Exist(values, n - 1, subarray2, target - values[n - 1], target2);
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the size of the Array n =\n");
		int n = keyboard.nextInt();
		int[] values = new int[n];
		Vector<Integer> v = new Vector<Integer>();

		System.out.println("Select Filling Method:\n(1) : For manual filling\n(2) : For automatic filling\n");
		int a = keyboard.nextInt();

		switch (a) {
		case 1:
			System.out.println("\nManual Filling Activated");
			for (int i = 0; i < n; i++) {
				System.out.println("Value " + (i + 1) + " =");
				values[i] = keyboard.nextInt();
			}
			break;
		case 2:
			System.out.println("\nAutomatic filling Activated");
			Random random = new Random();
			for (int i = 0; i < n; i++) {
				values[i] = random.nextInt(15);
			}
			break;
		}

		System.out.println("The target you are looking for =");
		int target = keyboard.nextInt();
		int target2 = target;
		keyboard.close();

		System.out.println("\n\n .................................... \n\n");
		System.out.println("The Array is : " + Arrays.toString(values) + "\n");
		System.out.println("The Target Sum is : " + n + "\n");
		System.out.println("The founded sums (if any) are : \n");
		Sum_Exist(values, n, v, target, target2);
		System.out.println("\nThe number of recursive calls are : " + cpt + " Times\n");
	}
}
