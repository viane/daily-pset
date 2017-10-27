//
//  main.cpp
//  Sum Two
//
//  Created by xiaoyu zhou on 10/27/17.
//  Copyright © 2017 xiaoyu zhou. All rights reserved.
//

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

//  Example:
//  Given nums = [2, 7, 11, 15], target = 9,

//  Because nums[0] + nums[1] = 2 + 7 = 9,
//  return [0, 1].


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> returnAry;
        for(int i = 0; i<nums.size();i++){
            for(int n = i+1; n < nums.size();n++){
                if(nums[i]+nums[n]==target){
                    returnAry.push_back(i);
                    returnAry.push_back(n);
                }
            }
        }
        return returnAry;
    }
};

int main(int argc, const char * argv[]) {
    
    vector<int> testVec = {3,2,4};
    int target = 6;
    
    cout << "Test vector [3,2,4]" << " Target 6\n" << "except [1,2] got ";
    
    Solution sol = *new Solution();
    
    vector<int> result = sol.twoSum(testVec, target);
    
    cout << "[";
    
    for (int i = 0; i<result.size(); i++) {
        if(i != result.size()-1){
            cout << result[i] << ",";
        }else{
            cout << result[i];
        }
    }
    
    cout << "]\n";
    return 0;
}


