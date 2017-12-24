import { Permutation } from './permutation-generator'

export class Checker extends Object {
  protected result: number[] = []
  constructor() { super() }
  protected convertToStrings = (aryOfWordsAry: string[][]) => {
    return aryOfWordsAry.map((singluarWordsAry) => {
      return singluarWordsAry.join('')
    })
  }

  protected getIndicesOf = (searchStr: string, str: string, caseSensitive?: boolean): number[] => {
    const searchStrLen = searchStr.length;
    if (searchStrLen == 0) {
      return [];
    }
    let startIndex = 0, index, indices: number[] = [];
    if (!caseSensitive) {
      str = str.toLowerCase();
      searchStr = searchStr.toLowerCase();
    }
    while ((index = str.indexOf(searchStr, startIndex)) > -1) {
      indices.push(index);
      startIndex = index + searchStrLen;
    }
    return indices;
  }


  findSubstring = function(s: string, words: string[]) {
    let perm: Permutation = new Permutation()
    const permsArys: string[] = perm.gengeratePermutation(words)
    const permSubStrAry = this.convertToStrings(permsArys)

    for (const searchSubStr of permSubStrAry) {
      this.result.push(this.getIndicesOf(searchSubStr, s, true))
    }

    const obj = {
      original_string: s,
      search_string_componments: words,
      all_search_string: permSubStrAry.sort(),
      found_indices: JSON.parse("[" + this.result.join() + "]").sort()
    }
    return obj
  }
}
