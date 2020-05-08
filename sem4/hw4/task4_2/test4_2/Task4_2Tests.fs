module Tests4_2

open NUnit.Framework
open FsUnit
open Task4_2

let testCases = 
    [
        2, [2; 4; 6; 1], [4; 8; 12; 2]
        4, [1; 11; 17; 5], [4; 44; 68; 20]
        1, [1; 2; 3; 4; 5; 5], [1; 2; 3; 4; 5; 5]
        10, [1; 2; 3; 4; 5; 5], [10; 20; 30; 40; 50; 50]
    ] |> List.map (fun (number, list, newList) -> TestCaseData(number, list, newList))

[<Test>]
[<TestCaseSource("testCases")>]
let funcTest number list newList =
    func number list |> should equal newList

[<Test>]
[<TestCaseSource("testCases")>]
let func'1Test number list newList =
    func'1 number list |> should equal (func number list)

[<Test>]
[<TestCaseSource("testCases")>]
let func'2Test number list newList =
    func'2 number list |> should equal (func number list)

[<Test>]
[<TestCaseSource("testCases")>]
let func'3Test number list newList =
    func'3 number list |> should equal (func number list)

[<Test>]
[<TestCaseSource("testCases")>]
let func'4Test number list newList =
    func'4 number list |> should equal (func number list)