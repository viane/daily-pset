export class Finder extends Object {
  constructor() {
    super()
  }

  firstMissingPositive = (nums): number => {
    for (var i = 1; i <= nums.length + 1; i++) {
      if (!nums.includes(i)) {
        return i
      }
    }

    return 1
  }
}
