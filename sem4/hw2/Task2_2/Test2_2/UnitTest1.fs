module Test2_2

open NUnit.Framework
open FsUnit
open FsCheck
open MapForTree

let testCases = 
    [
        (Node(3, Node(1, Empty, Empty), Empty)), (Node(9, Node(1, Empty, Empty), Empty))
        (Empty), (Empty)
        (Node(7, Node(9, Empty, Empty), Node(3, Empty, Empty))), (Node(49, Node(81, Empty, Empty), Node(9, Empty, Empty)))
        
    ] |> List.map (fun (tree, newTree) -> TestCaseData(tree, newTree))

[<Test>]
[<TestCaseSource("testCases")>]
let TestMapForTree tree newTree =
    mapTree (fun x -> x * x) tree |> should equal newTree