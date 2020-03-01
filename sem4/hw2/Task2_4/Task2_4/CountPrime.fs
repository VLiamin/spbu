module CountSimpleNumbers

// Function that checks whether a number is prime or not 
let isPrime x = 
    let rec check i =
        x > 1 && i > x / 2 || (x % i <> 0 && check (i + 1))
    match x with
    | x when x <= 1 -> false
    | _ -> check 2

// Function that returns an infinite sequence of primes
let returnAnInfiniteSequenceOfOrimes () = 
    Seq.initInfinite (fun number -> number) 
    |> Seq.filter (fun number -> isPrime number)
