let countFibonacci number = 
 if (number = 1) || (number = 0) then
   number
 else
  let rec doRecursion counter n1 n2 = 
   if counter >= number then
    n1
   else
    doRecursion
     (counter + 1)
     (n1 + n2) 
     n1
  doRecursion 2 1 1
printfn "Value: %d" (countFibonacci 7)