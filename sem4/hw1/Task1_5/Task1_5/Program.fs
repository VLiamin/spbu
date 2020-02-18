let rec getFirstPosition number list = 
 let rec doRecursion counter number list = 
  if List.length list = 0 then
   printfn "This item is not in the list"
   None
  else
   if List.head list = number then
    Some(counter)  
   else
    doRecursion
     (counter + 1)
     number
     (List.tail list)
 doRecursion 0 number list 
printfn "The number of first position: %A" (getFirstPosition 3 [1; 2; 3; 4; 3]) 
