/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {

    let result = 0;
    if(x<0){
        x = x * -1
        result = reverseDigits(x) * -1
    }else{
        result = reverseDigits(x)
    }

    if(Math.abs(result)>2147483647){
            return 0
    }

    return parseInt(result)
};


var reverseDigits = (x)=>{
    const intLength = weissteinLength(x)
    const halfLength = parseInt(intLength / 2)
    let intAry = (""+x).split("")
    for(var i = 0; i < halfLength;i++){
        const temp = intAry[intLength-i-1]
        intAry[intLength-i-1] = intAry[i]
        intAry[i] = temp
    }

    return intAry.join("")
}

let weissteinLength = function(n) {
    return (Math.log(Math.abs(n)+1) * 0.43429448190325176 | 0) + 1;
}

module.exports.reverseInt = reverse;
