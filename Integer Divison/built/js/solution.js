"use strict";
exports.__esModule = true;
var DivisionSolver = /** @class */ (function () {
    function DivisionSolver(dividend, divisor) {
        var _this = this;
        this.dividend = dividend;
        this.divisor = divisor;
        this.divide = function () {
            var temp_dividend = _this.dividend;
            var temp_divisor = _this.divisor;
            if (_this.dividend == 0 || (_this.dividend < _this.divisor)) {
                return 0;
            }
            var answer = {
                dividends: [_this.dividend],
                divisor: _this.divisor,
                q: 0
            };
            while ((temp_dividend = Math.abs(temp_dividend) - Math.abs(temp_divisor)) >= 0) {
                answer.dividends.push(Math.abs(temp_dividend));
                answer.q++;
            }
            // positive case
            if ((_this.dividend > 0 && _this.divisor > 0) || (_this.dividend < 0 && _this.divisor < 0)) {
                return answer;
            }
            else {
                answer.q = answer.q * -1;
                return answer;
            }
        };
    }
    return DivisionSolver;
}());
exports.DivisionSolver = DivisionSolver;
