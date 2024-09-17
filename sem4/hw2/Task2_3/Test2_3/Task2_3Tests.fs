module Test2_3

open NUnit.Framework
open FsUnit
open Task2_3

let testCases = 
    [
        Subtraction (Leaf 2, Leaf 4), -2
        Addition (Division (Leaf 9, Leaf 3), Leaf 3), 6
        Subtraction (Leaf 3, Leaf 3), 0
        Multiplication (Multiplication (Leaf 9, Leaf 10), Leaf 3), 270
    ] |> List.map (fun (tree, value) -> TestCaseData(tree, value))

[<Test>]
[<TestCaseSource("testCases")>]
let countExpressionTest tree value =
    countExpression tree |> should equal value