/** Import Modules */
import now = require("performance-now")
import { Finder } from './finder'

// Implement your function here
const defaultTestSet = {run:null, ["missing-integer"]: 0 }

const main = (): void => {
  let startTime: number = now(), endTime: number

  // random array
  let foo = [];

  for (var i = 1; i <= 10000; i++) {
    foo.push(i);
  }

  const missingIndex = Math.floor(Math.random() * 10000)
  // set missing integer
  const missingInteger = foo[missingIndex]
  defaultTestSet["missing-integer"] = missingInteger
  foo[missingIndex] = -1

  // find...
  const f: Finder = Object.create(new Finder())

  const findResult: number = f.firstMissingPositive(foo)

  console.log(`Set missing integer: ${missingInteger}, actual found: ${findResult}`)

  endTime = now()

  console.log("\nTask took " + (endTime - startTime).toFixed(1) + " milliseconds to finish.\n")
}

main()

defaultTestSet.run = main

// Export function set
export default {
  defaultTestSet
}

// End of implementation
