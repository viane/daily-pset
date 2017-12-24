export declare class Checker extends Object {
    protected result: number[];
    constructor();
    protected convertToStrings: (aryOfWordsAry: string[][]) => string[];
    protected getIndicesOf: (searchStr: string, str: string, caseSensitive?: boolean) => number[];
    findSubstring: (s: string, words: string[]) => {
        original_string: string;
        search_string_componments: string[];
        all_search_string: any;
        found_indices: any;
    };
}
