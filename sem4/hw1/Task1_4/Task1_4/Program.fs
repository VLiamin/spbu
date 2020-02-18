let rec countPowerOfTwo listOfPowers power = 
 if power = 0 then 
  listOfPowers
 else 
  countPowerOfTwo 
   (List.head listOfPowers * 2 :: listOfPowers)
   (power - 1)

let makeList listOfOurElements n m = 
 if m <= -1 || n < 0 then
  printfn "Incorrect data given"
  listOfOurElements
 else
  let rec doRecursion numberOfElemets list acc = 
   if numberOfElemets <= 0 then
    acc
   else
    doRecursion
     (numberOfElemets - 1)
     (List.tail list)
     (List.head list :: acc)
  let listOfPowersOfTwo = countPowerOfTwo [1] (n + m)
  doRecursion (m + 1) listOfPowersOfTwo listOfOurElements
 
let list = makeList [] 1 7
printfn "Our list is: %A" list