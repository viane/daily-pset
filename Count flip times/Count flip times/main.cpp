//
//  main.cpp
//  Count flip times
//
//  Created by xiaoyu zhou on 10/27/17.
//  Copyright © 2017 xiaoyu zhou. All rights reserved.
//

//  Problem: Give random numbers of card in order, ex from 1-50, each card has corresponded value as the given order, then start counting from 1 to the total numbers of the cards, if the card's value is a multiple of the number we are counting, flip the card to the other side, do this for all cards, then count next number. You can assume the given cards always start at 1, and by default very card is facing up.

//  Sultion: Find out each card's status(face up or face down) after count all numbers.

//  @@ input:
//              unsign int total_cards_number

#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

unsigned int generateCardsCount(){
    srand(time(NULL));
    
    // in this example, we wont give our more than 80 cards
    unsigned int count = 81;
    
    do{
        count=rand() % rand() +1;
    } while (count>80);
    
    return count;
}

class Card{
    unsigned int value;
    string status;
    public:
        Card(int cvaule){
            this->value = cvaule;
            status = "Face up";
        }
    unsigned int getValue(){
        return this->value;
    }
    string getStatus(){
        return this->status;
    }
    void printStatus(){
        cout << "Card #" << this->value << " is " << this->status << endl;
    }
    void flip(){
        if (this->status=="Face up") {
            this->status = "Face down";
        }else{
            this->status = "Face up";
        }
    }
};

Card createCard(int);

void flipAndPrintCard(Card&);

int main(int argc, const char * argv[]) {
    unsigned int cardsCount = generateCardsCount();
    cout << "There are total " << cardsCount << " cards given.\n";
    cout << "Calculating now...\n";
    for (int i=1; i<cardsCount+1; i++) {
        Card currentCard = createCard(i);
        flipAndPrintCard(currentCard);
        currentCard.printStatus();
    }
    return 0;
}

Card createCard(int value){
    Card theCard = *new Card(value);
    return theCard;
}

void flipAndPrintCard(Card& theCard){
    unsigned int cardValue = theCard.getValue();
    for (int i = 1; i < cardValue+1; i++) {
        if (cardValue % i == 0) {
            theCard.flip();
        }
    }
}

