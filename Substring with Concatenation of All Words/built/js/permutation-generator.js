"use strict";
exports.__esModule = true;
var Permutation = /** @class */ (function () {
    function Permutation() {
        var _this = this;
        this.heapsPermute = function (inputArr) {
            var results = [];
            function permute(arr, memo) {
                var cur, memo = memo || [];
                for (var i = 0; i < arr.length; i++) {
                    cur = arr.splice(i, 1);
                    if (arr.length === 0) {
                        results.push(memo.concat(cur));
                    }
                    permute(arr.slice(), memo.concat(cur));
                    arr.splice(i, 0, cur[0]);
                }
                return results;
            }
            return permute(inputArr);
        };
        this.gengeratePermutation = function (words) {
            return _this.heapsPermute(words);
        };
    }
    return Permutation;
}());
exports.Permutation = Permutation;
