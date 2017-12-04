using System;

namespace GenerateParentheses
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            int numberOfP = 8;  // dont go over this number...
            Solution s = new Solution();

            foreach (string prime in s.GenerateParenthesis(numberOfP))
            {
                Console.WriteLine(prime);
            }
        }
    }
}
