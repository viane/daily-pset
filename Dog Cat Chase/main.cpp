/*Name:
 Class:
 Section: {1}
 Date:
 Assignment:

 This C++ program is for Solving Lab " 2d Arrays cat and dog " problem.

 Copyright(c)




 Academic Intergrity Statement : I certify that, while others may have assisted me in brain storming,
 debugging and vaildating this program, the program itself is my own work.This is all my original
 code and not copied from any individual, group, textbook or website.I understand that submitting
 code which is the work of others is a violation of the course Academic Intergrity Policy and may
 result in a zero credit for the assignment, or course failure and a report to the Academic Dishonesty
 Board.I also understand that if I Knowingly give my original work to another individual that it could
 also result in a zero credit for the assignment, or course failure and a report to the Academmic Dishonesty Board*/

#include<iostream>
#include<fstream>
#include<cmath>
#include<iomanip>
#include<ctime>
#include<string>
#include <vector>
#include <sstream>
using namespace std;

//This is the global variables for the maxmium size of the room
const int COL(10), ROW(15);

//Function name: Rand-Int
//This function helps to generate a random number between minimum and maximum
//passed: minmium value, maxmium value
//return: a random number between minimum and maximum

//Random Function to generate the random number for the 2D-array
int Rand_int(int minimum, int maximum)
{
    return rand() % (maximum - minimum + 1) + minimum;
}

bool deadEnd(vector<vector<string>>room, int moveRow, int moveCol){
    if (room[moveRow+1][moveCol] != " " && room[moveRow-1][moveCol] != " " && room[moveRow][moveCol+1] != " "&& room[moveRow][moveCol-1] != " ") {
        return true;
    }
    return false;
}

bool less_vectors(const vector<string>& a,const vector<string>& b) {
    return a.size() < b.size();
}

void simulateMoves(vector<vector<string>>room, int moveRow, int moveCol, vector<int>pathRow,vector<int>pathCol,vector<vector<string>> &resultPath){

    // sort resultPath by size
    if (resultPath.size()>0) {
        sort(resultPath.begin(),resultPath.end(),less_vectors);
    }

    if (room[moveRow][moveCol+1]=="D") {
        pathRow.push_back(moveRow);
        pathCol.push_back(moveCol);
        vector<string> path;
        for (int x = 0; x<pathRow.size(); x++) {
            string pathUnit =to_string(pathRow[x]) + ","+to_string(pathCol[x]);
            path.push_back(pathUnit);
        }
        resultPath.push_back(path);
    }else if (deadEnd(room,moveRow, moveCol)) {
        // do nothing
    }else{
		room[moveRow][moveCol] = "P";
		pathRow.push_back(moveRow);
		pathCol.push_back(moveCol);

        if (resultPath.size()>0) {
            if (pathRow.size()>=resultPath[0].size()) {

            }else{
                if (room[moveRow+1][moveCol] == " ") {
                    simulateMoves(room,moveRow+1,moveCol,pathRow,pathCol,resultPath);
                }
                if (room[moveRow-1][moveCol] == " ") {
                    simulateMoves(room,moveRow-1,moveCol,pathRow,pathCol,resultPath);
                }
                if (room[moveRow][moveCol+1] == " ") {
                    simulateMoves(room,moveRow,moveCol+1,pathRow,pathCol,resultPath);
                }
                if (room[moveRow][moveCol-1] == " ") {
                    simulateMoves(room,moveRow,moveCol-1,pathRow,pathCol,resultPath);
                }
            }
        }else{
            if (room[moveRow+1][moveCol] == " ") {
                simulateMoves(room,moveRow+1,moveCol,pathRow,pathCol,resultPath);
            }
            if (room[moveRow-1][moveCol] == " ") {
                simulateMoves(room,moveRow-1,moveCol,pathRow,pathCol,resultPath);
            }
            if (room[moveRow][moveCol+1] == " ") {
                simulateMoves(room,moveRow,moveCol+1,pathRow,pathCol,resultPath);
            }
            if (room[moveRow][moveCol-1] == " ") {
                simulateMoves(room,moveRow,moveCol-1,pathRow,pathCol,resultPath);
            }
        }


    }

}


bool startChase(string (&room)[15][10], int startRow, int startCol, string chaser)
{
	if (chaser == "j" || chaser == "J")
	{
		chaser = "Johnny";
	}
	if (chaser == "h" || chaser == "H")
	{
		chaser = "Harvey";
	}

	cout << "Finding paths...\n";
    vector<vector<string>> roomT;
    for (int row = 0; row < 15; row++) {
        vector<string> perRow;
        for (int col=0; col<10; col++) {
            perRow.push_back(room[row][col]);
        }
        roomT.push_back(perRow);
    }

    vector<int> pathRow;
    vector<int> pathCol;
    vector<vector<string>> resultPath; // pass by reference
	// will modify resultPath
    simulateMoves(roomT,startRow,startCol+1,pathRow,pathCol,resultPath);
	cout << "\n";
	if (resultPath.size()==0)
	{
		cout << "Result: Not possible cross the room." << endl;
		return false;
	}

	// find shortest path
	int shortestPathIndex = 0;
	int shortestPathStepCount = 9999;
	for (size_t i = 0; i < resultPath.size(); i++)
	{
		if (shortestPathStepCount > resultPath[i].size()) {
			shortestPathStepCount = resultPath[i].size();
			shortestPathIndex = i;
		}
	}

	// mark path on room map
	vector<int> resultPathRowCoords;
	vector<int> resultPathColCoords;

	for (size_t i = 0; i < resultPath[shortestPathIndex].size(); i++)
	{
		string stepCoordinate = resultPath[shortestPathIndex][i];
		//cout << stepCoordinate << " ";

		vector<int> vect;
		stringstream ss(stepCoordinate);
		int number;
		int dlimer = 1;
		while (ss >> number)
		{
			if (dlimer==1)
			{
				resultPathRowCoords.push_back(number);
				dlimer++;
			}
			else {
				resultPathColCoords.push_back(number);
			}

			if (ss.peek() == ',')
				ss.ignore();
		}
	}

	for (int i = 0; i < resultPathRowCoords.size(); i++)
	{
		roomT[resultPathRowCoords[i]][resultPathColCoords[i]] = "P";
	}

	// display result map
	cout << '\n';
	for (int i = 0; i<roomT.size(); i++) {
		for (int x = 0; x<roomT[i].size(); x++) {
			cout << roomT[i][x] << " ";
		}
		cout << endl;
	}

	// display result in text
	if (chaser == "Johnny" && resultPath[shortestPathIndex].size() > 50)
	{
		cout << "\nResult: There is a path but Johnny can not make it because the path is out of his stamina\n";
		return false;
	}
	cout << "\nResult: Winner " << chaser << " made through the chase!\n";
	return true;
}



int main()
{
    //Define all of the variables
	srand(time(NULL));
    int minimum(1), maxmium(14), data_number;//Variable for seed number for Random Function, and the max and min number, also the value in the start of the file.
    string room_l;
    locale loc;



    // input data file
    ifstream data_in;

    //open data file
    data_in.open("rooms.txt");

    //check the data file
    if (data_in.fail())
    {
        cout << "Error opening file!" << endl;
		system("pause");
        return 0;
    }
    else{
        //Get the value from the first line from the file
        string mapCounts;
        getline(data_in, mapCounts);

        for (int map = 0; map< stoi(mapCounts); map++) {
            // read map to memory
            string room[15][10];
            string sourceLine;
            int mapLineCount = 0; // same index reference as room row index
            while (mapLineCount< 15 && getline(data_in,  sourceLine)) {
                if (sourceLine.length()<10) {
                    continue;
                }else{
                    for (int colIndex = 0; colIndex<10; colIndex++) {
                        room[mapLineCount][colIndex] = sourceLine[colIndex];
                    }
                    mapLineCount++;
                }
            }

            // set doors
            int row_begin = Rand_int(minimum, maxmium - 1);
            int row_end = Rand_int(minimum, maxmium - 1);
            room[row_begin][0] = "D";//find which the door to start
            room[row_end][9] = "D"; //find which the door to end

            // print loaded map setup
            cout << "Current Map Setup: \n\n";
            for (int row = 0; row < ROW; row++)
            {
                for (int column = 0; column < COL; column++)
                {
                    cout << room[row][column] << ' ';
                }
                cout<<'\n';
            }
			cout << '\n';

            // simulate chase
            string chaser;
            do{
                cout<<"Who do you want Johnny (J) or Harvey (H) to start the chasing: ";

                cin >> chaser;

            }while (chaser!="j" && chaser!="h"&& chaser!="johnny" && chaser!="harvey" && chaser != "J" && chaser != "H" && chaser != "Johnny" && chaser != "Harvey");

            startChase(room, row_begin,0, chaser);

			cout << endl;
			cout << endl;
			cout << endl;
        }

        //Read in all the characters from the file to the 2D array

        data_in.close();//close the data file


    }

    //end  of program
	system("pause");
    return 0;
}

/*
Test Result:

 Current Map Setup:

 W W W W W W W W W W
 W       F F       W
 W   F   F F   F   W
 W   F   F F   F   W
 W   F   F F   F   W
 W   F   F F   F   W
 W   F   F F   F   W
 W   F   F F   F   W
 D   F         F   D
 W   F         F   W
 W             F   W
 W     F       F   W
 W     F       F   W
 W             F   W
 W W W W W W W W W W

 Who do you want Johnny (J) or Harvey (H) to start the chasing: J
 Finding paths...


 W W W W W W W W W W
 W       F F P P P W
 W   F   F F P F P W
 W   F   F F P F P W
 W   F   F F P F P W
 W   F   F F P F P W
 W   F   F F P F P W
 W   F   F F P F P W
 D P F P P P P F P D
 W P F P       F   W
 W P P P       F   W
 W     F       F   W
 W     F       F   W
 W             F   W
 W W W W W W W W W W

 Result: Winner Johnny made through the chase!



 Current Map Setup:

 W W W W W W W W W W
 W       F F       W
 W   F   F F   F F W
 W   F   F F   F F W
 W   F   F F   F F W
 D   F   F F   F F W
 W   F   F F   F F W
 W   F   F F   F F W
 W   F         F F W
 W   F         F F W
 W             F F W
 W F   F       F F W
 W F   F       F F D
 W             F F W
 W W W W W W W W W W

 Who do you want Johnny (J) or Harvey (H) to start the chasing: J
 Finding paths...

 Result: Not possible cross the room.



 Current Map Setup:

 W W W W W W W W W W
 W F F F F F   F   W
 D F     F F   F   W
 W F     F F   F   W
 W F F F   F   F   D
 W F F F   F   F   W
 W F F F   F   F   W
 W         F       W
 W         F   F   W
 W F F F       F   W
 W F F F F     F   W
 W F   F F     F   W
 W F   F F F   F   W
 W F F F F F   F   W
 W W W W W W W W W W

 Who do you want Johnny (J) or Harvey (H) to start the chasing: J
 Finding paths...

 Result: Not possible cross the room.



 Current Map Setup:

 W W W W W W W W W W
 D     F           W
 W     F F F F     W
 W           F F   W
 W           F     D
 W   F F F   F     W
 W   F       F     W
 W   F   F F F     W
 W   F     F F     W
 W   F             W
 W F F   F F F     W
 W F F     F F     W
 W   F F   F F     W
 W         F       W
 W W W W W W W W W W

 Who do you want Johnny (J) or Harvey (H) to start the chasing: J
 Finding paths...


 W W W W W W W W W W
 D P   F           W
 W P   F F F F     W
 W P         F F   W
 W P P P P P F P P D
 W   F F F P F P   W
 W   F P P P F P   W
 W   F P F F F P   W
 W   F P   F F P   W
 W   F P P P P P   W
 W F F   F F F     W
 W F F     F F     W
 W   F F   F F     W
 W         F       W
 W W W W W W W W W W

 Result: Winner Johnny made through the chase!


*/
