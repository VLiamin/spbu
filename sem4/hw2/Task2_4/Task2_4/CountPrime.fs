module CountSimpleNumbers

// Function that checks whether a number is prime or not 
let isPrime x = 
    let rec check i =
         if (i = 1) then
             true
         elif (x % i = 0) then
             false
         else
             check (i - 1)
        
    match x with
    | x when x <= 1 -> false
    | x -> check (x - 1)

// Function that returns an infinite sequence of primes
let returnAnInfiniteSequenceOfPrimes () = 
    Seq.initInfinite (fun number -> number) 
    |> Seq.filter (fun number -> isPrime number)

