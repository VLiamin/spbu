module Task4_1

/// Function that returns a closing bracket of the same type
let getOpposite x = 
   match x with
   | '(' -> ')'
   | '[' -> ']'
   | '{' -> '}'
   | _ -> x

/// Function that checks the string for correct brackets 
let checkParentheses line =
    /// Function that goes along the line and counts the brackets
    let rec lineTraversal newLine (list : List<char>) =
        match newLine with
        | [] -> list.Length = 0
        | x :: t when (x  = '(') || (x = '{') || (x = '[') -> lineTraversal t (getOpposite x :: list)
        | x :: t when (x  = ')') || (x = '}') || (x = ']') ->  match list with
                                                               | [] -> false
                                                               | y :: l -> if (x.Equals(y)) then 
                                                                               lineTraversal t l
                                                                           else
                                                                               false
        | x :: t -> lineTraversal t list
    lineTraversal (Seq.toList(line)) []

printfn "%A" (checkParentheses "(djdjdj){dmmdm[dkd}djdk]")