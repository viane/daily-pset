"use strict";
exports.__esModule = true;
var checker_1 = require("./checker");
var chai_1 = require("chai");
describe('Test checker, return longest valid parentheses substring length', function () {
    it('Should return 0 by passing ""', function () {
        var c = Object.create(new checker_1.Checker());
        chai_1.expect(c.LVP("")).equal(0);
    });
    it('Should return 6 by passing ()()()', function () {
        var c = Object.create(new checker_1.Checker());
        chai_1.expect(c.LVP("()()()").longest_lvp_length).equal(6);
    });
    it('Should return 6 by passing )())()()()((', function () {
        var c = Object.create(new checker_1.Checker());
        chai_1.expect(c.LVP(")())()()()((").longest_lvp_length).equal(6);
    });
});
