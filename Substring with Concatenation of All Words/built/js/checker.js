"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
var permutation_generator_1 = require("./permutation-generator");
var Checker = /** @class */ (function (_super) {
    __extends(Checker, _super);
    function Checker() {
        var _this = _super.call(this) || this;
        _this.result = [];
        _this.convertToStrings = function (aryOfWordsAry) {
            return aryOfWordsAry.map(function (singluarWordsAry) {
                return singluarWordsAry.join('');
            });
        };
        _this.getIndicesOf = function (searchStr, str, caseSensitive) {
            var searchStrLen = searchStr.length;
            if (searchStrLen == 0) {
                return [];
            }
            var startIndex = 0, index, indices = [];
            if (!caseSensitive) {
                str = str.toLowerCase();
                searchStr = searchStr.toLowerCase();
            }
            while ((index = str.indexOf(searchStr, startIndex)) > -1) {
                indices.push(index);
                startIndex = index + searchStrLen;
            }
            return indices;
        };
        _this.findSubstring = function (s, words) {
            var perm = new permutation_generator_1.Permutation();
            var permsArys = perm.gengeratePermutation(words);
            var permSubStrAry = this.convertToStrings(permsArys);
            for (var _i = 0, permSubStrAry_1 = permSubStrAry; _i < permSubStrAry_1.length; _i++) {
                var searchSubStr = permSubStrAry_1[_i];
                this.result.push(this.getIndicesOf(searchSubStr, s, true));
            }
            var obj = {
                original_string: s,
                search_string_componments: words,
                all_search_string: permSubStrAry.sort(),
                found_indices: JSON.parse("[" + this.result.join() + "]").sort()
            };
            return obj;
        };
        return _this;
    }
    return Checker;
}(Object));
exports.Checker = Checker;
