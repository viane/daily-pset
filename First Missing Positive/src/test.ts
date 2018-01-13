import { expect } from 'chai'
import now = require("performance-now")
import exportFunctionSet from './main'

describe('Default test', (): void => {
  it('Should return same number as passed from main()', function () {
      expect(exportFunctionSet.defaultTestSet.run()).to.equal(exportFunctionSet.defaultTestSet["missing-integer"])
  });
})
