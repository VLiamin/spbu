let rec countNumber acc digit = 
 if digit = 0 
 then 
  acc
 else 
  countNumber 
   (acc * 2)
   (digit - 1)

let rec makeList acc n m = 
 if m = -1 then
  acc
 else
  makeList
   (countNumber (1) (n + m) :: acc)
   (n)
   (m - 1)

let list = makeList ([]) (1) (6)
printfn "Our list is: %A" list