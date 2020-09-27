open System

let rec factorial acc x = 
 if x = 1 then 
  acc 
 else 
  factorial 
   (acc * x) 
   (x - 1)
printfn "Value: %d" (factorial 1 3)