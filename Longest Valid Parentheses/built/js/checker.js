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
var Checker = /** @class */ (function (_super) {
    __extends(Checker, _super);
    function Checker() {
        var _this = _super.call(this) || this;
        _this.compareParentheses = function (s) {
            var sample_string = s;
            var left_parenthes_count = 0;
            var right_parenthes_count = 0;
            for (var _i = 0, sample_string_1 = sample_string; _i < sample_string_1.length; _i++) {
                var char = sample_string_1[_i];
                if (char === '(') {
                    left_parenthes_count++;
                }
                else {
                    right_parenthes_count++;
                }
            }
            if (left_parenthes_count == right_parenthes_count) {
                return 0;
            }
            else if (left_parenthes_count > right_parenthes_count) {
                return 1;
            }
            else {
                return -1;
            }
        };
        _this.LVP = function (s) {
            if (s.length === 0) {
                return 0;
            }
            var result = {
                lvp: [],
                lvp_length: 0,
                longest_lvp: "",
                longest_lvp_length: 0
            };
            var lvp_string = "";
            var lvp_checking_index = 0;
            // forward direction scan
            for (lvp_checking_index; lvp_checking_index < s.length; lvp_checking_index++) {
                var copy_of_lvp = lvp_string;
                copy_of_lvp += s[lvp_checking_index]; // add current char and predict if valid
                if (_this.compareParentheses(copy_of_lvp) === -1) {
                    if (_this.compareParentheses(lvp_string) === 0 && lvp_string.length != 0) {
                        result.lvp.unshift(lvp_string);
                        lvp_string = "";
                    }
                }
                else {
                    lvp_string = copy_of_lvp;
                }
                // after last char of string
                if (lvp_checking_index === s.length - 1 && _this.compareParentheses(lvp_string) === 0 && lvp_string.length != 0) {
                    result.lvp.unshift(lvp_string);
                }
            }
            // backward direction scan
            // format result
            if (result.lvp.length > 0) {
                result.lvp.sort(function (a, b) { return b.length - a.length; });
                result.longest_lvp = result.lvp[0];
                result.longest_lvp_length = result.lvp[0].length;
            }
            result.lvp_length = result.lvp.length;
            return result;
        };
        return _this;
    }
    return Checker;
}(Object));
exports.Checker = Checker;
