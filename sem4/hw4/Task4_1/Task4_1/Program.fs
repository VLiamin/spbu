module Task4_1

// Function that checks the string for correct brackets 
let checkParentheses line =
    // Function that goes along the line and counts the brackets
    let rec lineTraversal parentheses1 parentheses2 parentheses3 count list =
        if (count = String.length(line)) then
            (parentheses1 = 0) && (parentheses2 = 0) && (parentheses3 = 0)
        elif (parentheses1 < 0) || (parentheses2 < 0) || (parentheses3 < 0) || 
             ((List.length list > 0) && (line.[count].Equals(List.head list) = false) && ((line.[count] = ')') || (line.[count] = ']') || (line.[count] = '}'))) then
            false
        elif ((line.[count] = ')') || (line.[count] = ']') || (line.[count] = '}')) && (List.length list = 0) then
            false
        else 
            match (line.[count]) with
            | '(' -> lineTraversal (parentheses1 + 1) parentheses2 parentheses3 (count + 1) (')' :: list)
            | ')' -> lineTraversal (parentheses1 - 1) parentheses2 parentheses3 (count + 1) (List.tail list)
            | '[' -> lineTraversal parentheses1 (parentheses2 + 1) parentheses3 (count + 1) (']' :: list)
            | ']' -> lineTraversal parentheses1 (parentheses2 - 1) parentheses3 (count + 1) (List.tail list)
            | '{' -> lineTraversal parentheses1 parentheses2 (parentheses3 + 1) (count + 1) ('}' :: list)
            | '}' -> lineTraversal parentheses1 parentheses2 (parentheses3 - 1) (count + 1) (List.tail list)
            | _ -> lineTraversal parentheses1 parentheses2 parentheses3 (count + 1) list
    lineTraversal 0 0 0 0 []

printfn "%A" (checkParentheses "[(])")