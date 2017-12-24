import { Checker } from './checker'

let test1 = new Checker()

console.log(JSON.stringify(test1.findSubstring('barfootadasdhefoobarmanbarfoo', ["foo", "bar"]), null, '\t'))
