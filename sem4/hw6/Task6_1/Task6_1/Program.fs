module Task6_1
open System
// Builder which considers the expression
type Rounding(round) =
    member this.Bind(x, f) = 
        f x
    member this.Return(x) = Math.Round((x :float), (round : int))  
let rounding round = new Rounding(round)

// Function which considers the expression
let count round firstValue secondValue thirdValue = 
    rounding round {
        let! a = firstValue / secondValue
        let! b = thirdValue
        return a / b
    }

let main = 
    printfn "%f" (count 3 2.0 12.0 3.5)