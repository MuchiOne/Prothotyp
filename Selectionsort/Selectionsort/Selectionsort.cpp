// Selectionsort.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include <iostream>
void output(int array[],int Verschiebungen,int Durchlaufe) {
	std::cout << "fertiger Array \n";
	for ( int x = 0; x < 5; x++)
	{
		std::cout << array[x];
	}
	std::cout << "\nVerschiebungen "<< Verschiebungen<<"\n";
	std::cout << "Durchlaufe " << Durchlaufe << "\n";
}
int main()
{
	int array[5] = { 1,4,3,2,5 };
	int temp;
	int min;
	int Verschiebungen=0;
	int Durchlaufe=0;
	for (int i=0;i < 5 - 1;i++) {
		Durchlaufe++;
		temp = i;
		min = array[i];
		for ( int j = i+1; j < 5 ; j++)
		{
			if (array[j] < min) {
				temp = j;
				min = array[temp];
				Verschiebungen++;
			}
		}
		if (temp != i) {
			array[temp] = array[i];
			array[i] = min;
		}

	}
	output(array,Verschiebungen,Durchlaufe);
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
