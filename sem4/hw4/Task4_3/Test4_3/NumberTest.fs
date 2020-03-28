module Test4_3
open Number
open NUnit.Framework
open FsCheck
let testCases = 
    [
       "����", Some "+728271828"
       "����", Some "+643737488"
       "����", Some "+266137334"
       "����", None

    ] |> List.map (fun (name, value) -> TestCaseData(name, value))

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindNumber name value =
    Check.Quick (fun () -> (findNumber "check.txt" name) = value)