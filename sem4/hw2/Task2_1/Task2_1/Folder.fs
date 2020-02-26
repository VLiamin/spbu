module CountEvenNumbersWithFold

let countEvenNumbersWithFold list =
    List.fold (fun acc x -> acc + abs (x + 1) % 2) 0 list

