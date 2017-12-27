export class Checker extends Object {
  constructor() { super() }
  protected compareParentheses = (s: string): number => {
    let sample_string: any = s
    let left_parenthes_count = 0
    let right_parenthes_count = 0

    for (const char of sample_string) {
      if (char === '(') {
        left_parenthes_count++
      } else {
        right_parenthes_count++
      }
    }

    if (left_parenthes_count == right_parenthes_count) {
      return 0
    } else if (left_parenthes_count > right_parenthes_count) {
      return 1
    } else {
      return -1
    }

  }

  public LVP = (s: string): any => {
    if (s.length === 0) {
      return 0
    }

    let result = {
      lvp: [],
      lvp_length: 0,
      longest_lvp:"",
      longest_lvp_length:0
    }

    let lvp_string: string = ""

    let lvp_checking_index: number = 0

    // forward direction scan
    for (lvp_checking_index; lvp_checking_index < s.length; lvp_checking_index++) {
      let copy_of_lvp = lvp_string

      copy_of_lvp += s[lvp_checking_index] // add current char and predict if valid

      if (this.compareParentheses(copy_of_lvp) === -1) { // if not valid
        if (this.compareParentheses(lvp_string) === 0 && lvp_string.length != 0) { // if # of ( sequal # of ) before adding
          result.lvp.unshift(lvp_string)
          lvp_string = ""
        }
      } else {
        lvp_string = copy_of_lvp
      }

      // after last char of string
      if (lvp_checking_index === s.length - 1 && this.compareParentheses(lvp_string) === 0 && lvp_string.length != 0) { // if # of ( sequal # of ) before adding
        result.lvp.unshift(lvp_string)
      }
    }

    // backward direction scan


    // format result
    if(result.lvp.length>0){
      result.lvp.sort((a: string, b: string): number => { return b.length - a.length })
      result.longest_lvp = result.lvp[0]
      result.longest_lvp_length = result.lvp[0].length
    }

    result.lvp_length = result.lvp.length

    return result
  }
}
