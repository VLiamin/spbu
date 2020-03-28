module NameTest
open Name
open NUnit.Framework
open FsCheck

let testCases = 
    [
       Some "Катя", "+728271828"
       Some "Миша", "+643737488"
       Some "Вова", "+266137334"
       None, "+88383828823772" 

    ] |> List.map (fun (name, value) -> TestCaseData(name, value))

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindNumber name value =
    Check.Quick (fun () -> (findName "check.txt" value) = name)