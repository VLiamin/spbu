module Task2_3

// Structure of the tree
type tree =
| Leaf of int
| Node of char * tree * tree

// Method which count the tree expression
let rec countExpression tree =
    match tree with
    | Leaf(number) -> number
    | Node(element, leftTree, rightTree) ->
        match element with
        | '+' -> (countExpression leftTree) + (countExpression rightTree)
        | '-' -> (countExpression leftTree) - (countExpression rightTree)
        | '*' -> (countExpression leftTree) * (countExpression rightTree)
        | _ -> (countExpression leftTree) / (countExpression rightTree)
