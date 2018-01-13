/** Import Modules */
import now = require("performance-now")
import { Finder } from './finder'

// Implement your function here

const main = (): void => {
  let startTime: number = now(), endTime: number

  let foo = [];

  for (var i = 1; i <= 10000; i++) {
    foo.push(i);
  }

  const missingIndex = Math.floor(Math.random() * 10000)
  const missingInteger = foo[missingIndex]
  foo[missingIndex] = -1

  const f: Finder = Object.create(new Finder())

  const findResult: number = f.firstMissingPositive(foo)

  console.log(`Set missing integer: ${missingInteger}, actual found: ${findResult}`)

  endTime = now()

  console.log("\nTask took " + (endTime - startTime).toFixed(1) + " milliseconds to finish.\n")
}

main()


// Export function set
export default {
  defaultTest: { run: main }
}

// End of implementation
