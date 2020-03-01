module CountEvenNumbersWithFold
// Function that counts the number of even elements in a list using fold
let countEvenNumbersWithFold list =
    List.fold (fun acc x -> acc + abs (x + 1) % 2) 0 list

