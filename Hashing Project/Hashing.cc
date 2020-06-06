//Vamsi Avinash Gunji
//Dr.Puya
//Data Structures

#include <iostream>
#include <string>
#include <stdlib.h>
#include <time.h>
#include <math.h>

using namespace std;

//Purpose: This will return the hash of the key that matches with the index 
int HashKey(const int & Key, int SizeOfTable) {
	return Key % SizeOfTable;
}
 
void popArray(int array[]) {
	for (int i = 0; i < 13001; i++) {
		array[i] = -1;
	}
}

//This function will generate a random seed
int main()
{
	
	srandom(time(NULL));

	//Below are the hash tables for a) cubic probing, 
	//b) quadtratic probing, and c) Linear probing 
	
	
	int HashTable1[13001];

	int HashTable2[13001];
	int HashTable3[13001];
	int ArrayNumber[7500];

	//Purpose: popArray is populating each of the hash tables
	popArray(HashTable1);
	popArray(HashTable2);
	popArray(HashTable3);

	
	int NumberOfCollisions1 = 0;

	int NumberOfCollisions2 = 0;

	int NumberOfCollisions3 = 0;


	for (int i = 0; i < 7500; i++) {
		ArrayNumber[i] = random() % 10000 + 1;
	}

	
	for (int i = 0; i < 7500; i++) {
	    
		//Purpose: Hashing step
		int Number = ArrayNumber[i];
		//Purpose: Hashing the index
		int Index = HashKey(Number, 13001);

		// Purpose: If and Else for c) Linear Probing (hash(x) + i) 
		if (HashTable1[Index] == -1) {
			HashTable1[Index] = Number;
		}
		else {
			//Purpose: This increases the incrementation by adding 1 to the collision
			NumberOfCollisions1++;
			//Purpose: An additional index which differs from the one above
			int index3 = (Index + 1) % 13001;
			//Purpose: A loop that will heck HashTable1 for a collision
			while (HashTable1[index3] != -1) {
				index3 = (index3 + 1) % 13001;
				NumberOfCollisions1++;
			}
			
			//Purpose: Finds the available index
			HashTable1[index3] = Number;
		}
		
		//Purpose: If and Else for b) Quadratic Probing (hash(x) + i^2) 
		if (HashTable2[Index] == -1) {
			HashTable2[Index] = Number;
		}
		else {
	       	//This increases the incrementation by adding 1 to the collision
			NumberOfCollisions2++;
	       	//Purpose: A counter is needed for quadratic probing so that is added below
			int counter = 1;
	       	//Purpose: An additional index which differs from the one above
			int index4 = (Index + (int) pow(counter, 2)) % 13001;
			while (HashTable2[index4] != -1) {
				counter++;
				index4 = (Index + (int) pow(counter, 2)) % 13001;
				NumberOfCollisions2++;
			}

			//Finds the available index
			HashTable2[index4] = Number;
		}

		//If and Else for a) Cubic Probing (hash(x) + i^3)
		if (HashTable3[Index] == -1) {
			HashTable3[Index] = Number;
		}
		else {
			//This increases the incrementation by adding 1 to the collision 
			NumberOfCollisions3++;
			//Purpose: A counter is needed for cubic probing so that is added below
			int counter2 = 1;
			//Purpose: An additional index which differs from the one above 
			int index5 = (Index + (int) pow(counter2, 3)) % 13001;
			while (HashTable3[index5] != -1) {
				counter2++;
				index5 = (Index + (int) pow(counter2, 3)) % 13001;
				NumberOfCollisions3++;
			}

			//Finds the available index
			HashTable3[index5] = Number;
		}
	}

	cout << "Collisions (Linear Probing): " << NumberOfCollisions1 << endl;
	cout << "Collisions (Quadratic Probing): " << NumberOfCollisions2 << endl;
	cout << "Collisions (Cubic Probing): " << NumberOfCollisions3 << endl;

    return 0;
}

//Sources: Worked with Sarvesh to get my bug fixed.
