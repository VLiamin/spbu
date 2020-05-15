module Tests4_2

open NUnit.Framework
open FsUnit
open Task4_2
open FsCheck

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
let func'1Test () =
   Check.QuickThrowOnFailure (fun (x, list) -> func x list = func'1 x list)

[<Test>]
let func'2Test () =
    Check.QuickThrowOnFailure (fun (x, list) -> func x list = func'2 x list)

[<Test>]
let func'3Test () =
   Check.QuickThrowOnFailure (fun (x, list) -> func x list = func'3 x list)

[<Test>]
let func'4Test () =
    Check.QuickThrowOnFailure (fun (x, list) -> func x list = func'4 x list)