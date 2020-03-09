module Tests4_2

open NUnit.Framework
open FsCheck
open task4_2

let testCases = 
    [
        2, [2; 4; 6; 1], [4; 8; 12; 2]
        4, [1; 11; 17; 5], [4; 44; 68; 20]
        1, [1; 2; 3; 4; 5; 5], [1; 2; 3; 4; 5; 5]
        10, [1; 2; 3; 4; 5; 5], [10; 20; 30; 40; 50; 50]
    ] |> List.map (fun (number, list, newList) -> TestCaseData(number, list, newList))

[<Test>]
[<TestCaseSource("testCases")>]
let func'3Test number list newList =
    Check.Quick (fun () -> (func'3 number list) = newList)