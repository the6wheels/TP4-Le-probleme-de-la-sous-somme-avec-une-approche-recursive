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

public class Somme {
	// counter initialization
	static long cpt = 0;

	// Returns true if there exists a subsequence of `A[0…n]` with the given sum
	private static boolean Sum_Exist(int[] values, int targetSum, int n) {
		// increase counter by cpt = cpt + 1
		cpt++;
		// return true if subset is found
		if (targetSum == 0) {
			return true;
		}
		// base case: no items left, or sum becomes negative
		if (n == 0 && targetSum > 0) {
			return false;
		}
		// last element greater than the sum remove it and continue.
		// We can’t include this item in the subset. We don’t have a choice.
		if (values[n - 1] > targetSum) {
			return Sum_Exist(values, targetSum, n - 1);
		}
		// include last or exclude last.
		// We have a choice to either include this item in the subset or don’t.
		// Whichever choice leads us to the target sum will be chosen.
		return Sum_Exist(values, targetSum - values[n - 1], n - 1) || Sum_Exist(values, targetSum, n - 1);
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the size of the Array n =");
		int n = keyboard.nextInt();
		int[] values = new int[n];

		System.out.println("\nSelect Filling Method:\n(1) : For manual filling\n(2) : For automatic filling\n");
		int a = keyboard.nextInt();

		switch (a) {
		case 1:
			System.out.println("\nManual Filling Activated");
			for (int i = 0; i < n; i++) {
				System.out.println("Value " + (i + 1) + " =\n");
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

		System.out.println("The target sum you are looking for =\n");
		int target = keyboard.nextInt();
		keyboard.close();

		System.out.println("\n\n .................................... \n\n");
		System.out.println("The Array is : " + Arrays.toString(values) + "\n");
		System.out.println("The Target Sum is : " + n + "\n");
		System.out.println("The Array Contains a Subset sum: " + Sum_Exist(values, target, n));
		System.out.println("\nThe number of recursive calls are : " + cpt + " Times\n");
	}
}