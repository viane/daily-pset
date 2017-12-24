import { Checker } from './checker'

let test1 = new Checker()

console.log(JSON.stringify(test1.findSubstring('barfootadasdhefoobarmanbarfoo', ["foo", "bar"]), null, '\t'))


// leetCode test case API
var findSubstring = function(s, words) {
    const finder = new Checker()
    return finder.findSubstring(s, words)
};

console.log(findSubstring('barfootadasdhefoobarmanbarfoo', ["foo", "bar"]))
