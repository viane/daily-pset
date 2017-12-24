import {DivisionSolver} from './solution'

let falseByNegative:DivisionSolver = new DivisionSolver(-3,3)

let result = falseByNegative.divide()

console.log(result)

let okayByPositive:DivisionSolver = new DivisionSolver(3,3)

result = okayByPositive.divide()

console.log(result)
