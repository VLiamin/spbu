module Task4_1

// Function that checks the string for correct brackets 
let checkParentheses line =
    // Function that goes along the line and counts the brackets
    let rec lineTraversal parentheses1 parentheses2 parentheses3 count =
        if (count = String.length(line)) then
            if (parentheses1 = 0) && (parentheses2 = 0) && (parentheses3 = 0) then
                true
            else
                false
        else if (parentheses1 < 0) || (parentheses2 < 0) || (parentheses3 < 0) then
                false
            else 
                match (line.[count]) with
                | '(' -> lineTraversal (parentheses1 + 1) parentheses2 parentheses3 (count + 1)
                | ')' -> lineTraversal (parentheses1 - 1) parentheses2 parentheses3 (count + 1)
                | '[' -> lineTraversal parentheses1 (parentheses2 + 1) parentheses3 (count + 1)
                | ']' -> lineTraversal parentheses1 (parentheses2 - 1) parentheses3 (count + 1)
                | '{' -> lineTraversal parentheses1 parentheses2 (parentheses3 + 1) (count + 1)
                | '}' -> lineTraversal parentheses1 parentheses2 (parentheses3 - 1) (count + 1)
                | _ -> lineTraversal parentheses1 parentheses2 parentheses3 (count + 1)
    lineTraversal 0 0 0 0 

printfn "%A" (checkParentheses "((())fjjfjf)")