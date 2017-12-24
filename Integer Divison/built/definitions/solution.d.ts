export declare class DivisionSolver {
    protected dividend: number;
    protected divisor: number;
    constructor(dividend: number, divisor: number);
    divide: () => 0 | {
        dividends: number[];
        divisor: number;
        q: number;
    };
}
