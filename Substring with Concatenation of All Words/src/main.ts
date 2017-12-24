import { Checker } from './checker'

import now = require("performance-now")

var startTime = now()

// Implement your function here
let test1 = new Checker()

console.log(JSON.stringify(test1.findSubstring('barfootadasdhefoobarmanbarfoo', ["foo", "bar"]), null, '\t'))
// End of implementation

var endTime = now()

console.log("\nTask took " + (endTime - startTime).toFixed(1) + " milliseconds to finish.\n")



//------------------------------------------------------------

startTime = now()
// leetCode test case API
const findSubstring = function(s, words) {
    const finder = new Checker()
    return finder.findSubstring(s, words)
};

console.log(findSubstring('barfootadasdhefoobarmanbarfoo', ["foo", "bar"]))
endTime = now()

console.log("\nTask took " + (endTime - startTime).toFixed(1) + " milliseconds to finish.\n")
