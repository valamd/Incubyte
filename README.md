# String Calculator – TDD by Manish Vala

This project implements a **String Calculator** using **Test-Driven Development (TDD)** in Java.

## Features Covered 

=> Returns `0` for an empty string  
=> Returns number itself for a single number  
=> Returns sum for two comma-delimited numbers  
=> Supports newline `\n` as a valid delimiter  
=> Supports custom single-character delimiter using format: `//[delimiter]\n`  
=> Supports multiple custom delimiters (e.g., `//[*][%]\n1*2%3`)  
=> Supports multi-character delimiters (e.g., `//[***]\n1***2***3`)  
=> Ignores numbers greater than 1000  
=> Throws an exception when negative numbers are passed (e.g., `-1,-2`)  
=> Shows all negative numbers in the exception message  
=> Handles combination of multiple and multi-character delimiters

## About Project

 **Core File:** `StringCalculator.java`  
 **Tests File:** `StringCalculatorTest.java`  
  Testing Framework: **JUnit**

## Developer Info

Name: Manish Vala  
Approach: Pure TDD (Red -> Green -> Refactor)  
Git: Each test added & committed separately as per Incubyte standards.

## Thank You   
Thanks to **Incubyte** for this hands-on TDD assessment.
