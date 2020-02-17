let rec getFirstPosition acc number list = 
 if List.head list = number then
  acc
 else
  getFirstPosition
   (acc + 1)
   (number)
   (List.tail list)
printfn "The number of first position: %d" (getFirstPosition 0 3 [1; 2; 3]) 
