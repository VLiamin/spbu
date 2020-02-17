let list = [1; 0]

let rec countFibonacci list n i = 
 if (n = 1) || (n = 0) then
  1
 else
  if n = i then
   List.head list
  else
   countFibonacci
    (List.head list + List.nth list 1 :: list) 
    (n)
    (i + 1)
printfn "Value: %d" (countFibonacci list 5 1)