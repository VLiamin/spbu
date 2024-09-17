module Test2_1

open NUnit.Framework
open FsUnit
open FsCheck
open CountEvenNumbersWithMap
open CountEvenNumbersWithFold
open CountEvenNumbersWithFilter

let testCases = 
    [
        [], 0
        [8; 3; 9; 5; 6; 7; 8; 9], 3
        [0], 1
        [1; 3; 4; 5; -6; 7; 8; 9], 3
        [1; 5; 7; 9; 11; 13; 11], 0
        [2; 4; 6; 8], 4
        [0; -3], 1
    ] |> List.map (fun (list, value) -> TestCaseData(list, value))

[<Test>]
[<TestCaseSource("testCases")>]
let CountEvenNumbersWithMapTest list value =
    countEvenNumbersWithMap(list) |> should equal value

[<Test>]
[<TestCaseSource("testCases")>]
let CountEvenNumbersWithFoldTest list value =
    countEvenNumbersWithFold(list) |> should equal value

[<Test>]
[<TestCaseSource("testCases")>]
let CountEvenNumbersWithFilterTest list value =
    countEvenNumbersWithFilter(list) |> should equal value

[<Test>]
let CountEvenNumbersWithFilterAndFolderTest () = 
    Check.QuickThrowOnFailure (fun (list: List<int>) -> (countEvenNumbersWithFilter list) = (countEvenNumbersWithFold list))

[<Test>]
let CountEvenNumbersWithFilterAndMapTest () = 
    Check.QuickThrowOnFailure (fun (list: List<int>) -> (countEvenNumbersWithFilter list) = (countEvenNumbersWithMap list))