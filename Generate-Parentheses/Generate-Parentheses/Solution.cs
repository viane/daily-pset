using System;
using System.Linq;
using System.Collections.Generic;

namespace GenerateParentheses
{
    public class Solution
    {

        private List<string> result = new List<string>();

        public Solution()
        {
            
        }

        public IList<string> GenerateParenthesis(int n)
        {
            MakeCombo("(",n);

            result = result.Distinct().ToList<string>();

            return result;
        }

        private void MakeCombo(string source, int n){
            if(ValidCombo(source,n)){
                if(source.Length != n * 2){
                    MakeCombo(source.Insert(0, "("), n);
                    MakeCombo(source.Insert(0, ")"), n);
                    MakeCombo(source.Insert(source.Length, "("), n);
                    MakeCombo(source.Insert(source.Length, ")"), n);
                }else{
                    result.Add(source);
                }
            }
        }

        private Boolean ValidCombo(string combo, int n){
            // count if ('s more than n, ex. ((((
            int count = 0;
            foreach (char c in combo){
                if (c == '(') count++;
            }
            if (count>n)
            {
                return false;
            }
            // valid combo, ex (()))
            // for each ) in combo, compare sum of ( and sum of ) unti this position,
            // if sum of ( >= sum of ), then combo valid,
            // the above example would be invalid at last ) since sum of ( is 2 and sum of ) is 3

            for (int i = 0; i < combo.Length; i++)
            {
                if(combo.Substring(i,1) == ")"){
                    int sumOfLeft = 0;
                    int sumOfRight = 1;
                    for (int x = 0; x < i; x++)
                    {
                        if (combo.Substring(x,1)=="(")
                        {
                            sumOfLeft++;
                        }
                        if (combo.Substring(x,1)==")")
                        {
                            sumOfRight++;
                        }
                    }

                    if(sumOfLeft < sumOfRight){
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
