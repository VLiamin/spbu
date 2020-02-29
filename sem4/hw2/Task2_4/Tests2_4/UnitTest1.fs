module Tests2_4

open NUnit.Framework
open FsUnit
open FsCheck
open CountSimpleNumbers


let testCases = 
    [
        2, true
        4, false
        1, false
        10, false
        13, true
        1001, true
    ] |> List.map (fun (number, numberIsPrime) -> TestCaseData(number, numberIsPrime))

[<Test>]
[<TestCaseSource("testCases")>]
let isPrimeTest number numberIsPrime =
    Check.Quick (fun (int) -> (isPrime number) = numberIsPrime)



[<Test>]
let returnAnInfiniteSequenceOfOrimesTest1 () =
    let seq = returnAnInfiniteSequenceOfOrimes ()
    Seq.take 7 seq |> should equal [2; 3; 5; 7; 11; 13; 17]
