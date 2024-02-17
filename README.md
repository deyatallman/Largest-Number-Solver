# Assignment 04: Largest Number Solver

This assignment focuses on implementing a program that determines the largest number possible from the contents of an integer array, along with performing timing experiments to analyze its efficiency. The assignment tasks involve generic programming, algorithm analysis, and custom comparators.

## Problem Description
The program must construct the largest number by concatenating the integers of a given array in any order. Simply sorting the array in descending order and concatenating the contents will not always produce the correct result. Instead, a custom comparison method is required to compare concatenated integers to determine their order correctly. Additionally, the program should find the kth largest number from a list of integer arrays.

## Classes Overview
1. **LargestNumberSolver**: Contains methods to solve the problem, such as sorting the array, finding the largest number, finding the kth largest number, and reading arrays from a file.
2. **OutOfRangeException**: Represents an exception thrown when a numerical value is out of range for a data type.
3. **TimerTemplate**: An abstract class used for timing tests. It provides methods to setup, time the code, and perform compensation iterations.
4. **LargestNumberSolverTiming**: Extends TimerTemplate to perform timing experiments for the LargestNumberSolver methods.

## Implementation Details
- **LargestNumberSolver**: Implements algorithms to find the largest number, sort arrays, and perform related operations.
- **OutOfRangeException**: Custom exception class to handle out-of-range values.
- **TimerTemplate**: Abstract class providing a template for timing experiments.
- **LargestNumberSolverTiming**: Performs timing experiments on the LargestNumberSolver methods.

## Analysis
The `LargestNumberSolverTiming` class conducts timing experiments to evaluate the performance of the algorithms for different problem sizes.

## Authors
Deya Tallman
