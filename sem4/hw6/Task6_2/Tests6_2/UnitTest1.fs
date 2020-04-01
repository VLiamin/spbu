module Tests

open Task6_2
open NUnit.Framework
open FsUnit
open FsCheck

let testCases = 
    [
        "1", "2", "3"
        "12", "2", "14"
        "1r2", "2", "Your expression is not right"
    ] |> List.map (fun (firstValue, secondValue, result) -> 
                                               TestCaseData(firstValue, secondValue, result))


[<Test>]
[<TestCaseSource("testCases")>]
let checkCountResult firstValue secondValue result =
    Check.Quick (fun () -> (countResult firstValue secondValue) = result)


let countResult () = 
    calculate {
        let! x = "1"
        let! y = "2"
        let z = x + y
        return z
    }
[<Test>]
let checkCount2  =
    countResult () |> should equal "3"
