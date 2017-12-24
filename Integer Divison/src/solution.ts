export class DivisionSolver {
  constructor(protected dividend: number, protected divisor: number) { }
  divide = () => {
    let temp_dividend = this.dividend
    let temp_divisor = this.divisor
    if (this.dividend == 0 || (this.dividend < this.divisor)) {
      return 0;
    }

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
      return answer
    } else {
      answer.q = answer.q * -1
      return answer
    }

  }
}
