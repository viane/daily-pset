//
//  main.c
//  Ptr-test
//
//  Created by Xiaoyu Zhou on 2/4/18.
//  Copyright © 2018 Xiaoyu Zhou. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include "read_to_string.h"
#include "prime_finder.h"
#include <stdbool.h>


int main(int argc, const char * argv[]) {
    unsigned long long bounds[] = {0LL,0LL};  // upper and lower bound of prime
    
    char *stdInput;
    
    do{
        printf("Enter the range of prime numbers you want to find (sparate by space):\n");
        stdInput= inputString(stdin, 10);
    }while(!parseBound(bounds,stdInput));
    
    unsigned long long *pPrimes = findPrime(bounds);
    unsigned long long counter = 0;
    while (*(pPrimes+counter) != 0) {
        printf("%llu ",*(pPrimes+counter));
        if ((counter+1) % 5 == 0) {
            printf("\n");
        }
        counter++;
    }
    printf("\nTotal %llu prime numbers found.\n",counter);
    
    free(stdInput);
    
    return 0;
}
