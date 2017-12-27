import now = require("performance-now")
import {Checker} from './checker'

var startTime = now()

// Implement your function here

let s:Checker = Object.create(new Checker())
console.log(JSON.stringify(s.LVP("(()"),null,'\t'))

// End of implementation

var endTime = now()

console.log("\nTask took " + (endTime - startTime).toFixed(1) + " milliseconds to finish.\n")
