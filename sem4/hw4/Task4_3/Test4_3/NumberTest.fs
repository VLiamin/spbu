module Test4_3
open Number
open NUnit.Framework
open FsUnit
let testCases = 
    [
       "Katya", Some "+728271828"
       "Misha", Some "+643737488"
       "Vova", Some "+266137334"

    ] |> List.map (fun (name, value) -> TestCaseData(name, value))

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindNumber name value =
    findNumber "check.txt" name  |> should equal value

[<Test>]
let TestFindNumber2 =
    findNumber "check.txt" "Blabla"  |> should equal None