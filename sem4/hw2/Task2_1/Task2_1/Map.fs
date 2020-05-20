module CountEvenNumbersWithMap
open System

// Function that counts the number of even elements in a list using map
let countEvenNumbersWithMap list =
    Math.Abs (List.sum (List.map (fun x -> Math.Abs (x % 2) - 1) list))

