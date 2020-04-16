module Task2_3

// Structure of the tree
type Tree =
| Leaf of int
| Multiplication of Tree * Tree
| Division of Tree * Tree
| Addition of Tree * Tree
| Subtraction of Tree * Tree

// Method which count the tree expression
let rec countExpression Tree =
    match Tree with
    | Leaf (number) -> number
    | Multiplication (leftTree, rightTree) -> (countExpression leftTree) * (countExpression rightTree)
    | Division (leftTree, rightTree) -> (countExpression leftTree) / (countExpression rightTree)
    | Addition (leftTree, rightTree) ->  (countExpression leftTree) + (countExpression rightTree)
    | Subtraction (leftTree, rightTree) -> (countExpression leftTree) - (countExpression rightTree)

