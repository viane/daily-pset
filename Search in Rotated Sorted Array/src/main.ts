import now = require("performance-now")
import {Finder} from './finder'

var startTime, endTime

startTime = now()

// Implement your function here
let result = Object.create(new Finder())

console.log(result.search([5,6,1,2,3,4,7,8,9],3))
// End of implementation

endTime = now()

console.log("\nTask took " + (endTime - startTime).toFixed(1) + " milliseconds to finish.\n")


export function helloWorld(){
  return "Hello World"
}
