export declare class Finder extends Object {
    constructor();
    protected result: {
        found: boolean;
        search_space: string;
        where: number;
    };
    search: any;
    indentifyTarget: (nums: number[], leftIndex: number, rightIndex: number, target: number) => boolean;
}
