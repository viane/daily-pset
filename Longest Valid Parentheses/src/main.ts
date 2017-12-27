import now = require("performance-now")

var startTime = now()

// Implement your function here
const sleep = (miliseconds)=> {
   var currentTime = new Date().getTime();

   while (currentTime + miliseconds >= new Date().getTime()) {
   }
}
sleep(827);
// End of implementation

var endTime = now()

console.log("\nTask took " + (endTime - startTime).toFixed(1) + " milliseconds to finish.\n")
