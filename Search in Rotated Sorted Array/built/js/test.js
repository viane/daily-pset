"use strict";
exports.__esModule = true;
var chai_1 = require("chai");
var finder_1 = require("./finder");
describe('Basic case', function () {
    it('Should return not find', function () {
        var finder = Object.create(new finder_1.Finder());
        chai_1.expect(finder.search([7, 8, 9, 2, 3, 4], 1).found).to.equal(false);
    });
    it('Should return 4', function () {
        var finder = Object.create(new finder_1.Finder());
        chai_1.expect(finder.search([5, 6, 7, 1, 2, 8, 9, 3, 4], 2).where).to.equal(4);
    });
});
