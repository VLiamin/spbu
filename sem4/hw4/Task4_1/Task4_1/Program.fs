module Task4_1

/// Function that returns a closing bracket of the same type
let getOpposite x = 
   match x with
   | '(' -> ')'
   | '[' -> ']'
   | '{' -> '}'
   | x -> x

/// Function that checks the string for correct brackets 
let checkParentheses line =
    /// Function that goes along the line and counts the brackets
    let rec lineTraversal newLine list =
        if (List.length newLine = 0) then
            List.length list = 0
        elif (List.head newLine = ')' || List.head newLine = ']' || List.head newLine = '}') && 
             (List.length list > 0 && (List.head newLine).Equals(List.head list) = false || List.length list = 0) then
            false
        else 
            match (List.head newLine) with
            | x when x = '(' || x = '[' || x = '{' -> lineTraversal (List.tail newLine) (getOpposite x :: list)
            | x when x = ')' || x = '}' || x = ']' -> lineTraversal (List.tail newLine) (List.tail list)
            | _ -> lineTraversal (List.tail newLine) list
    lineTraversal (Seq.toList(line)) []

printfn "%A" (checkParentheses "[6655")