module CountEvenNumbersWithFilter

let countEvenNumbersWithFilter list =
    List.length (List.filter (fun x -> x % 2 = 0) list)
  
printfn "Value: %d" (countEvenNumbersWithFilter [1; 3; 4; 5; 6; 7; 8; 9])

