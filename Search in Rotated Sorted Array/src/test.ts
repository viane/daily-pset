import {expect} from 'chai'
import {Finder} from './finder'

describe('Basic case',()=>{
  it('Should return not find',()=>{
    let finder: Finder = Object.create(new Finder())
    expect(finder.search([7,8,9,2,3,4],1).found).to.equal(false)
  })

  it('Should return 4',()=>{
    let finder: Finder = Object.create(new Finder())
    expect(finder.search([5,6,7,1,2,8,9,3,4],2).where).to.equal(4)
  })
})
