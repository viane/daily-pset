//
//  prime_finder.h
//  Ptr-test
//
//  Created by Xiaoyu Zhou on 2/4/18.
//  Copyright © 2018 Xiaoyu Zhou. All rights reserved.
//

#ifndef prime_finder_h
#define prime_finder_h
#include <stdlib.h>
#include <stdbool.h>

////////////////////////////////////////////////////////////
/// Convert string into llu1 llu2 sparate by space
////////////////////////////////////////////////////////////

bool parseBound(unsigned long long* bounds, char* readString){
    char* readPtr = readString;
    unsigned long long counter[] = {0LL,0LL}; // store each number's ending index
    unsigned long long temp = 0LL;
    while (readPtr[temp] != '\0') {
        counter[1]++;
        if (readPtr[temp] == ' ') {
            if (counter[0] != 0) { // if more than 1 space is found, use 1st space to identify the 2 bounds
                break;
            }
            counter[0] = temp;
        }
        temp++;
    }
    
    // split to substring by space
    char bound1[counter[0]+1], bound2[counter[1]-counter[0]];
    memcpy(bound1, readString, counter[0]);
    bound1[counter[0]] = '\0';
    
    memcpy(bound2, readString+counter[0]+1, counter[1]);
    bound2[counter[1]-counter[0]-1] = '\0';
    
//    printf("%s %s\n",bound1, bound2);
    
    // convert to long, and sort
    if (atof(bound1) <= atof(bound2)) {
        bounds[0] = atof(bound1);
        bounds[1] = atof(bound2);
    }else{
        bounds[1] = atof(bound1);
        bounds[0] = atof(bound2);
    }
    
    if (bounds[0] > 0 && bounds[1] > 0 && bounds[0] != bounds[1]) {
        return true;
    }else{
        return false;
    }
}

////////////////////////////////////////////////////////////////////////
/// Find primes between giving bounds, return list ending with int 0
////////////////////////////////////////////////////////////////////////

unsigned long long* findPrime(unsigned long long bounds[]){
    unsigned long long *pPrimes = NULL;  // Storage poll ptr
    int count = 0; // number of prime found
    bool found = false; // indicate weather found a prime
    
    // initial mem pool
    size_t capacity = 10;
    pPrimes = calloc(capacity, sizeof(unsigned long long));
    
    if (!pPrimes) {
        printf("Failed on allocating system memory. Stoping program...\n");
        return pPrimes;
    }
    
    // predifine first 3 primes
    *pPrimes = 2LL;
    *(pPrimes+1)= 3LL;
    *(pPrimes+2) =5LL;
    count = 3;
    
    // Find all the prmes required starting with next candidate
    unsigned long long trial = *(pPrimes+2) + 2ULL;
    unsigned long long *pTemp = NULL; // temp ptr
    while (trial <= bounds[1]) {
        // Divide the prime, if any divide exactly, then it's not a prime
        for (int i = 1; i<count; i++) {
            if (!(found = (trial % *(pPrimes+i)))) { // if one of the division has 0 reminder => perfectly divided
                break;                               // found => false
            }
        }
        
        if (found) {
            if (count == capacity) { // reached memory pool capacity
                capacity += CAP_INCR;
                pTemp = realloc(pPrimes, capacity*sizeof(unsigned long long) + 1); // 1 extra space for ending indicator
                if (!pTemp) {
                    printf("Failed on allocting system memory. Stopping program...\n");
                    pPrimes = NULL;
                    return pPrimes;
                }
                pPrimes = pTemp;
            }
            
            *(pPrimes+count++) = trial; // append current prime to list
            
        }
        trial+=2ULL; // prepare next candidate prime by adding 2
    }
    
    
    
    // reformat and return primes only in giving range
    unsigned long long* returnList = calloc(capacity+1,count*sizeof(unsigned long long));
    unsigned long long indexCounter = 0LL;
    long long i = 0;
    for (; indexCounter<capacity+1; indexCounter++) {
        if (*(pPrimes+indexCounter)>=bounds[0] && *(pPrimes+indexCounter)<=bounds[1]) {
            *(returnList+i++) = *(pPrimes+indexCounter);
        }
    }
    return returnList;
}


#endif /* prime_finder_h */
