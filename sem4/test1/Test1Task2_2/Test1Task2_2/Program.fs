module Task2
open System

/// A function that searches for a number that can highlight the high order
let countDivider value = 
    let rec multiplyNumber number count = 
        if (count <= 2) then
            number * 10
        else
            multiplyNumber (number * 10) (count - 1)
    multiplyNumber 1 (String.length (value.ToString()))

/// A function that checks for a polynomial number and allocates more
let findMaxPalindrome value oldMax = 
    let rec checkValue number count =
        if ((number < 10 && count = 1) || (number = 0 && count = 0)) then
            true
        elif (number < 10) then
            false
        elif (number % 10 = 0) && (count = (int) (Math.Log10((float) number)) + 2) then 
            checkValue (number / 10) (count - 2)
        elif (number / (countDivider number) = number % 10) && (count = ((int) (Math.Log10((float) number)) + 1)) then

            checkValue (number % (countDivider number) / 10) (count - 2)
        else
            false
    if (value > oldMax) && (checkValue value ((int) (Math.Log10((float) value)) + 1)) then
        value
    else
        oldMax

/// The function that finds the largest polynomial
let find () = 
   let rec findMax maxPalindrome firstValue secondValue = 
       if (secondValue < 600 && maxPalindrome > 101) then
            maxPalindrome
       elif (firstValue >= 101) then
           findMax (findMaxPalindrome (firstValue * secondValue) maxPalindrome) (firstValue - 1) secondValue
       elif (secondValue >= 101) then
           findMax (findMaxPalindrome (firstValue * secondValue) maxPalindrome) (999) (secondValue - 1)
       else
           maxPalindrome
   findMax 101 999 999


printfn "%d" (find ())
