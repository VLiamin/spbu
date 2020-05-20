module CountEvenNumbersWithFilter

// Function that counts the number of even elements in a list using filter
let countEvenNumbersWithFilter list =
    List.length (List.filter (fun x -> x % 2 = 0) list)
 

