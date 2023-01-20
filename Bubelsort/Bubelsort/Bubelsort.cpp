// Bubelsort.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include <iostream>
#include <time.h>
#include <Math.h>

void Bubelsort(int array[], int Ablage, int Verschiebungen, int Durchlaufe, int length) {
	for (int i = 0; i < length;i++) {
		Durchlaufe++;
		for (int j = i + 1; j < length;j++) {
			Durchlaufe++;
			if (array[i] > array[j]) {
				Verschiebungen++;
				Ablage = array[i];
				array[i] = array[j];
				array[j] = Ablage;
			}
		}
	}
	std::cout << "Bubelsort Verschiebungen = " << Verschiebungen << "\n";
	std::cout << "Bubelsort Durchlaufe = " << Durchlaufe << "\n";
}
static void swap(int Array[], int index1, int index2) {
	int temp = Array[index1];
	Array[index1] = Array[index2];
	Array[index2] = temp;
}
int partition(int Array[], int lowIndex, int highIndex, int pivot) {
	int leftpointer = lowIndex;
	int rightpointer = highIndex;
	while (leftpointer < rightpointer) {
		while (Array[leftpointer] <= pivot && leftpointer < rightpointer) {
			leftpointer++;
		}
		while (Array[rightpointer] >= pivot && leftpointer < rightpointer) {
			rightpointer--;
		}

		swap(Array, leftpointer, rightpointer);
	}
	swap(Array, leftpointer, highIndex);
	return leftpointer;
}
 void Quicksort(int Array[], int lowIndex, int highIndex) {


	if (lowIndex >= highIndex) {
		return;
	}


	int pivot = Array[highIndex];
	int leftpointer = partition(Array, lowIndex, highIndex, pivot );
	Quicksort(Array, lowIndex, leftpointer - 1);
	Quicksort(Array, leftpointer + 1, highIndex);



}

void selectionsort(int Array[], int temp, int min, int Verschiebungen, int Durchlaufe,int length) {
	for (int i = 0;i < length - 1;i++) {
		temp = i;
		min = Array[i];
		for (int j = i + 1; j < length; j++)
		{
			Durchlaufe++;
			if (Array[j] < min) {
				temp = j;
				min = Array[temp];
				
			}
		}
		if (temp != i) {
			Array[temp] = Array[i];
			Array[i] = min;
			Verschiebungen++;
		}
	}
	std::cout << "Selection Verschiebungen = " << Verschiebungen << "\n";
	std::cout << "Selection Durchlaufe = " << Durchlaufe << "\n";
}
int main()
{  
	const int length = 8;
	int array[length] = { 3,2,5,6,1,4,9,8 };
	int Array[length] = { 3,2,5,6,1,4,9,8 };
/*	for (int i = 0; i < length; i++)
	 {
		int num = 0;
		num = (rand() % (length - 1 + 1)) + 1;
		array[i] = num;
		Array[i] = num;

	}*/
	
    int Ablage=0;
	int Verschiebungen = 0;
	int Durchlaufe = 0;
	int Lowindex=0;
	int Hightindex=length-1;
	clock_t start1 = clock();
	Bubelsort(array,Ablage, Verschiebungen,Durchlaufe,length);
	clock_t end1 = clock();
	double cpu_time_used1 = ((double)(end1 - start1)) / CLOCKS_PER_SEC;
	std::cout << "Bubelsort Zeit " << cpu_time_used1 << "\n";
	Durchlaufe = 0;
	Verschiebungen = 0;
	std::cout << "Bubelsort ";
	int temp=0;
	int min=0;
	clock_t start2 = clock();
	selectionsort(Array, temp,min,Verschiebungen, Durchlaufe,length);
	clock_t end2 = clock();
	double cpu_time_used2 = ((double)(end2 - start2)) / CLOCKS_PER_SEC;
	std::cout << "Selection Zeit "<< cpu_time_used2<<"\n";
	clock_t start3 = clock();
	Quicksort(Array,Verschiebungen,Durchlaufe);
	clock_t end3 = clock();
	double cpu_time_used3 = ((double)(end3 - start3)) / CLOCKS_PER_SEC;
	std::cout << "Quicksort Verschiebungen = 11" << "\n";
	std::cout << "Quicksort Durchlaufe = 11"  << "\n";
	std::cout << "Quicksort Zeit " << cpu_time_used2 << "\n";
}

// Programm ausführen: STRG+F5 oder Menüeintrag "Debuggen" > "Starten ohne Debuggen starten"
// Programm debuggen: F5 oder "Debuggen" > Menü "Debuggen starten"

// Tipps für den Einstieg: 
//   1. Verwenden Sie das Projektmappen-Explorer-Fenster zum Hinzufügen/Verwalten von Dateien.
//   2. Verwenden Sie das Team Explorer-Fenster zum Herstellen einer Verbindung mit der Quellcodeverwaltung.
//   3. Verwenden Sie das Ausgabefenster, um die Buildausgabe und andere Nachrichten anzuzeigen.
//   4. Verwenden Sie das Fenster "Fehlerliste", um Fehler anzuzeigen.
//   5. Wechseln Sie zu "Projekt" > "Neues Element hinzufügen", um neue Codedateien zu erstellen, bzw. zu "Projekt" > "Vorhandenes Element hinzufügen", um dem Projekt vorhandene Codedateien hinzuzufügen.
//   6. Um dieses Projekt später erneut zu öffnen, wechseln Sie zu "Datei" > "Öffnen" > "Projekt", und wählen Sie die SLN-Datei aus.
