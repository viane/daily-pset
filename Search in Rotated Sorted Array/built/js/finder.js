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
var Finder = /** @class */ (function (_super) {
    __extends(Finder, _super);
    function Finder() {
        var _this = _super.call(this) || this;
        _this.result = {
            found: false,
            search_space: '0',
            where: 0
        };
        _this.search = function (nums, target) {
            if (nums.length === 0) {
                return _this.result;
            }
            else {
                for (var i = 0, leftIndex = 0, rightIndex = 0, previous_pivot_index = leftIndex; i < nums.length; i++) {
                    if (i > 1) {
                        if (nums[i] - nums[i - 1] != 1) {
                            if (_this.indentifyTarget(nums, leftIndex, i - 1, target)) {
                                return _this.result;
                            }
                            leftIndex = i;
                        }
                        else {
                            if (nums[i] === target) {
                                _this.result.found = true;
                                _this.result.search_space = Number((i / (nums.length - 1)).toFixed(3)) * 100 + '%',
                                    _this.result.where = i;
                            }
                        }
                    }
                    else {
                        if (_this.indentifyTarget(nums, leftIndex, rightIndex, target)) {
                            return _this.result;
                        }
                    }
                }
            }
            return _this.result;
        };
        _this.indentifyTarget = function (nums, leftIndex, rightIndex, target) {
            if (nums[leftIndex] <= target && nums[rightIndex] >= target) {
                _this.result.found = true;
                _this.result.search_space = Number((rightIndex / (nums.length - 1)).toFixed(3)) * 100 + '%';
                for (var i = 0; i < nums.slice(leftIndex, rightIndex + 1).length; i++) {
                    if (nums.slice(leftIndex, rightIndex + 1)[i] === target) {
                        _this.result.where = leftIndex + i;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        };
        return _this;
    }
    return Finder;
}(Object));
exports.Finder = Finder;
