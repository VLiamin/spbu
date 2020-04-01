﻿module Task6_2
open System
// Builder which considers the expression
type Calculate() =
    member this.Bind(x, f) =
        try
            f (int x)
        with
        | msg ->  "Your expression is not right"
    member this.Return(x) = (string x) 
let calculate = new Calculate()

// Function which shows the work of builder
let countResult firstValue secondValue = 
    calculate {
        let! x = firstValue
        let! y = secondValue
        let z = x + y
        return z
    }

let main = 
    printfn "%s" (countResult "1y" "2")