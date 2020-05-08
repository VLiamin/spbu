module Task4_1

/// Function that checks the string for correct brackets 
let checkParentheses line =
    /// Function that goes along the line and counts the brackets
    let rec lineTraversal newLine list =
        if (List.length newLine = 0) then
            List.length list = 0
        elif (List.length list > 0 && (List.head newLine).Equals(List.head list) = false || List.length list = 0) && 
             (List.head newLine = ')' || List.head newLine = ']' || List.head newLine = '}') then
            false
        elif (List.head newLine = ')' || List.head newLine = ']' || List.head newLine = '}') && (List.length list = 0) then
            false
        else 
            match (List.head newLine) with
            | '(' -> lineTraversal (List.tail newLine) (')' :: list)
            | ')' -> lineTraversal (List.tail newLine) (List.tail list)
            | '[' -> lineTraversal (List.tail newLine) (']' :: list)
            | ']' -> lineTraversal (List.tail newLine) (List.tail list)
            | '{' -> lineTraversal (List.tail newLine) ('}' :: list)
            | '}' -> lineTraversal (List.tail newLine) (List.tail list)
            | _ -> lineTraversal (List.tail newLine) list
    lineTraversal (Seq.toList(line)) []

printfn "%A" (checkParentheses "[6655")