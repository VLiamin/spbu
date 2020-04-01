module Test6_2
open NUnit.Framework
open FsUnit
open FsCheck

let testCases = 
    [
        "1", "2", "3"
        "12", "2", "14"
       // "1r2", "2", "Your expression is not right"
    ] |> List.map (fun (firstValue, secondValue, result) -> 
                                               TestCaseData(firstValue, secondValue, result))


[<Test>]
[<TestCaseSource("testCases")>]
let checkCountResult firstValue secondValue result =
    result |> should equal (Task_6_2.countResult firstValue secondValue)

