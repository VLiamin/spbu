module Test6_1

open NUnit.Framework
open Task6_1
open FsUnit

let testCases = 
    [
        1, 1.0, 10.0, 1.0, 0.1
        2, 3.0, 9.0, 2.01, 0.16
        3, 5.0, 3.0, 4.0, 0.417
        2, 3.5, 2.1, 7.1, 0.24 
    ] |> List.map (fun (round, firstValue, secondValue, thirdValue, result) -> 
                                               TestCaseData(round, firstValue, secondValue, thirdValue, result))


[<Test>]
[<TestCaseSource("testCases")>]
let checkCount round firstValue secondValue thirdValue result =
    count round firstValue secondValue thirdValue |> should  (equalWithin 0.0001) result

let count2 () = 
    rounding 4 {
        let! a = 2.1 * 3.78
        let! b = 5.0 / 8.9
        let! c = 2.1
        return a * b / c
    }

[<Test>]
let checkCount2  =
    count2 () |> should  (equalWithin 0.0001) 2.1236