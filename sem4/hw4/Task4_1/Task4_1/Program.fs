module Task4_1

/// Function that checks the string for correct brackets 
let checkParentheses line =
    /// Function that goes along the line and counts the brackets
    let rec lineTraversal parentheses1 parentheses2 parentheses3 newLine list =
        if (List.length newLine = 0) then
            (parentheses1 = 0) && (parentheses2 = 0) && (parentheses3 = 0)
        elif (parentheses1 < 0) || (parentheses2 < 0) || (parentheses3 < 0) || 
             ((List.length list > 0) && ((List.head newLine).Equals(List.head list) = false) && ((List.head newLine = ')') || (List.head newLine = ']') || ((List.head newLine = '}')))) then
            false
        elif ((List.head newLine = ')') || (List.head newLine = ']') || (List.head newLine = '}')) && (List.length list = 0) then
            false
        else 
            match (List.head newLine) with
            | '(' -> lineTraversal (parentheses1 + 1) parentheses2 parentheses3 (List.tail newLine) (')' :: list)
            | ')' -> lineTraversal (parentheses1 - 1) parentheses2 parentheses3 (List.tail newLine) (List.tail list)
            | '[' -> lineTraversal parentheses1 (parentheses2 + 1) parentheses3 (List.tail newLine) (']' :: list)
            | ']' -> lineTraversal parentheses1 (parentheses2 - 1) parentheses3 (List.tail newLine) (List.tail list)
            | '{' -> lineTraversal parentheses1 parentheses2 (parentheses3 + 1) (List.tail newLine) ('}' :: list)
            | '}' -> lineTraversal parentheses1 parentheses2 (parentheses3 - 1) (List.tail newLine) (List.tail list)
            | _ -> lineTraversal parentheses1 parentheses2 parentheses3 (List.tail newLine) list
    lineTraversal 0 0 0 (Seq.toList(line)) []

printfn "%A" (checkParentheses "[(])")