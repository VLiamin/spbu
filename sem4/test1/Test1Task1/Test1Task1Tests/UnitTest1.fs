module Test1Task1Tests

open NUnit.Framework
open Task1
open FsUnit


let testCases = 
    [
        [8; 3; 9; 5; 6; 7; 8; 9], Some (3)
        [0], Some (0)
        [1; 3; 4; 5; -6; 7; 8; 9], Some (-6)
        [1; 5; 7; 9; 11; 13; 11], Some (1)
        [2; 4; 6; 8], Some (2)
    ] |> List.map (fun (list, value) -> TestCaseData(list, value))

[<Test>]
[<TestCaseSource("testCases")>]
let findMinTest list value =
    findMin list |> should equal value