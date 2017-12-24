export class DivisionSolver {
  protected MAX_INT:number = Math.pow(2, 53) -1;
  protected  MIN_INT:number = - this.MAX_INT;

  constructor(protected dividend: number, protected divisor: number) { }
  divide = () => {
    if (this.dividend === 0) {
      return 0
    }
    if (this.divisor === 0) {
      return 'Can\'t not divide by 0'
    }

    let temp_dividend = this.dividend
    let temp_divisor = this.divisor

    let answer = {
      dividends: [this.dividend],
      divisor: this.divisor,
      q: 0
    }

    while ((temp_dividend = Math.abs(temp_dividend) - Math.abs(temp_divisor)) >= 0) {
      answer.dividends.push(Math.abs(temp_dividend))
      answer.q++
    }

    // positive case
    if ((this.dividend > 0 && this.divisor > 0) || (this.dividend < 0 && this.divisor < 0)) {
      return answer.q
    } else {
      answer.q = answer.q * -1
      return answer.q
    }
  }
}
