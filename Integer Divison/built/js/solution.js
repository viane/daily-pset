"use strict";
exports.__esModule = true;
var DivisionSolver = /** @class */ (function () {
    function DivisionSolver(dividend, divisor) {
        var _this = this;
        this.dividend = dividend;
        this.divisor = divisor;
        this.MAX_INT = Math.pow(2, 53) - 1;
        this.MIN_INT = -this.MAX_INT;
        this.divide = function () {
            if (_this.dividend === 0) {
                return 0;
            }
            if (_this.divisor === 0) {
                return 'Can\'t not divide by 0';
            }
            var temp_dividend = _this.dividend;
            var temp_divisor = _this.divisor;
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
                return answer.q;
            }
            else {
                answer.q = answer.q * -1;
                return answer.q;
            }
        };
    }
    return DivisionSolver;
}());
exports.DivisionSolver = DivisionSolver;
