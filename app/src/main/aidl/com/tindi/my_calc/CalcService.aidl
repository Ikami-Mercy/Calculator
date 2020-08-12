// CalcService.aidl
package com.tindi.my_calc;

// Declare any non-default types here with import statements

interface CalcService {
    /**
     * Calculator functions..

     */
double add(double firstValue, double secondValue);
double subtract(double firstValue, double secondValue);
double multiply(double firstValue, double secondValue);
double divide(double firstValue, double secondValue);
}
