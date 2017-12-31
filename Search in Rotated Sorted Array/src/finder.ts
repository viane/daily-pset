export class Finder extends Object {
  constructor() { super() }

  protected result = {
    found: false,
    search_space: '0',
    where: 0
  }

  search: any = (nums: number[], target: number) => {
    if (nums.length === 0) {
      return this.result
    } else {
      for (let i = 0, leftIndex = 0, rightIndex = 0, previous_pivot_index = leftIndex; i < nums.length; i++) {
        if (i > 1) {
          if (nums[i] - nums[i - 1] != 1) { // Entering a rotated segment, eg. ...,4,5,6,[1],...
            if (this.indentifyTarget(nums, leftIndex, i - 1, target)) {
              return this.result
            }
            leftIndex = i
          }else{
            if (nums[i]===target) {
              this.result.found = true
              this.result.search_space = Number((i / (nums.length - 1)).toFixed(3)) * 100+ '%',
              this.result.where = i
            }
          }
        }else{ // Mannually check for index 0
          if (this.indentifyTarget(nums, leftIndex, rightIndex, target)) {
            return this.result
          }
        }
      }
    }

    return this.result
  }

  indentifyTarget = (nums: number[], leftIndex: number, rightIndex: number, target: number): boolean => {
    if (nums[leftIndex] <= target && nums[rightIndex] >= target) {
      this.result.found = true
      this.result.search_space = Number((rightIndex / (nums.length - 1)).toFixed(3)) * 100 + '%'
      for (let i = 0; i < nums.slice(leftIndex, rightIndex + 1).length; i++) {
          if(nums.slice(leftIndex, rightIndex + 1)[i] === target){
            this.result.where = leftIndex + i
          }
      }
      return true
    } else {
      return false
    }
  }
}
