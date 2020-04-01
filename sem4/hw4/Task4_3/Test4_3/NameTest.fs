module NameTest
open Name
open NUnit.Framework
open FsUnit

let testCases = 
    [
       Some "Katya", "+728271828"
       Some "Misha", "+643737488"
       Some "Vova", "+266137334"

    ] |> List.map (fun (name, value) -> TestCaseData(name, value))

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindName name value =
    findName "check.txt" value |> should equal name

[<Test>]
let TestFindName2 =
    findName "check.txt" "+38272727" |> should equal None