export declare class DivisionSolver {
    protected dividend: number;
    protected divisor: number;
    protected MAX_INT: number;
    protected MIN_INT: number;
    constructor(dividend: number, divisor: number);
    divide: () => number | "Can't not divide by 0";
}
