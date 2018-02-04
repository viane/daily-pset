//
//  read_to_string.h
//  Ptr-test
//
//  Created by Xiaoyu Zhou on 2/4/18.
//  Copyright © 2018 Xiaoyu Zhou. All rights reserved.
//

#ifndef read_to_string_h
#define read_to_string_h
#define CAP_INCR 10  // New memory increase

////////////////////////////////////////////////////////////
/// Read C string with dynamically increase string size
////////////////////////////////////////////////////////////

char *inputString(FILE* fp, size_t size){
    //The size is extended by the input with the value of the provisional
    char *str;
    int ch;
    size_t len = 0;
    str = realloc(NULL, sizeof(char)*size);//size is start size
    if(!str){
        printf("Failed to locate memory while reading.\n");
        return str;
    }
    while(EOF!=(ch=fgetc(fp)) && ch != '\n'){
        str[len++]=ch;
        if(len==size){
            str = realloc(str, sizeof(char)*(size+=CAP_INCR));
            if(!str)return str;
        }
    }
    str[len++]='\0';
    
    return realloc(str, sizeof(char)*len);
}


#endif /* read_to_string_h */
