module Test4_3
open Number
open NUnit.Framework
open FsCheck
let testCases = 
    [
       "Катя", Some "+728271828"
       "Миша", Some "+643737488"
       "Вова", Some "+266137334"
       "Лида", None

    ] |> List.map (fun (name, value) -> TestCaseData(name, value))

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindNumber name value =
    Check.Quick (fun () -> (findNumber "check.txt" name) = value)