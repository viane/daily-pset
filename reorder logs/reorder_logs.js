// You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

// There are two types of logs:

//     Letter-logs: All words (except the identifier) consist of lowercase English letters.
//     Digit-logs: All words (except the identifier) consist of digits.

// Reorder these logs so that:

//     The letter-logs come before all digit-logs.
//     The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
//     The digit-logs maintain their relative ordering.

// Return the final order of the logs.

logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]

/**
 * @param {string[]} logs
 * @return {string[]}
 */
var reorderLogFiles = function(logs) {

    letter_logs = []
    digit_logs = []
    for (let i = 0; i < logs.length; i++) {
        const element = logs[i];
        tokens = element.split(' ')
        if(!isNaN(parseInt(tokens[1]))){
            digit_logs.push(element)
        }else{
            letter_logs.push(element)
        }
    }

    const result = letter_logs.sort(compare).concat(digit_logs)

    console.log(result);
    return result
};

const compare = (a, b)=>{
    let a_content = a
    let b_content = b

    // compare content
    let val = a_content.split(' ').slice(1).join(' ').localeCompare(b_content.split(' ').slice(1).join(' '))

    if(val == 0){
        val = a_content.split(' ')[0].localeCompare(b_content.split(' ')[0])
    }

    return val;
}

reorderLogFiles(logs)
