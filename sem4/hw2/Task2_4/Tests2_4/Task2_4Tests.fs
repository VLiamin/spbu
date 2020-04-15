module Tests2_4

open NUnit.Framework
open FsUnit
open CountSimpleNumbers
open FsCheck

let testCases = 
    [
        2, true
        4, false
        1, false
        10, false
        13, true
        3571, true
        1004, false
    ] |> List.map (fun (number, numberIsPrime) -> TestCaseData(number, numberIsPrime))

[<Test>]
let returnAnInfiniteSequenceOfPrimesTest1 () =
    let seq = returnAnInfiniteSequenceOfPrimes ()
    Seq.take 7 seq |> should equal [2; 3; 5; 7; 11; 13; 17]

[<Test>]
[<TestCaseSource("testCases")>]
let isPrimeTest number numberIsPrime =
    Check.QuickThrowOnFailure (fun () -> (isPrime number) = numberIsPrime)