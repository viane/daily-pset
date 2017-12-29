import {Checker} from './checker'
import {expect} from 'chai'

describe('Test checker, return longest valid parentheses substring length', () => {
    it('Should return 0 by passing ""',  () => {
      let c:Checker = Object.create(new Checker())
      expect(c.LVP("")).equal(0)
    });

    it('Should return 6 by passing ()()()',  () => {
      let c:Checker = Object.create(new Checker())
      expect(c.LVP("()()()").longest_lvp_length).equal(6)
    });

    it('Should return 6 by passing )())()()()((',  () => {
      let c:Checker = Object.create(new Checker())
      expect(c.LVP(")())()()()((").longest_lvp_length).equal(6)
    });
})
