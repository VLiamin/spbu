module Test2Task2

let countDivider value = 
    let rec multiplyNumber number count = 
        if (count <= 2) then
            number * 10
        else
            multiplyNumber (number * 10) (count - 1)
    multiplyNumber 1 (String.length (value.ToString()))


let findMaxPalindrome value oldMax = 
    let rec checkValue number =
        if (number < 10) then
            true
        elif (number / (countDivider number) = number % 10) then
            checkValue (number % (countDivider number * 10) / 10)
        else
            false
    if (true = checkValue value) && (value > oldMax) then
        value
    else
        oldMax


let find () = 
   let rec findMax maxPalindrome firstValue secondValue = 
       if (firstValue <= 999) then
           findMax (findMaxPalindrome (firstValue * secondValue) maxPalindrome) (firstValue + 1) secondValue
       elif (secondValue <= 999) then
           findMax (findMaxPalindrome (firstValue * secondValue) maxPalindrome) (101) (secondValue + 1)
       else
           maxPalindrome
   findMax 101 101 101

printfn "%d" (find ())

