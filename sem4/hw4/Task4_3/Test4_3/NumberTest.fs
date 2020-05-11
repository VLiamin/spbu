module Test4_3

open Task4_3
open NUnit.Framework
open FsUnit
open System.IO

let testCases = 
    [
       "Katya", Some "+728271828"
       "Misha", Some "+643737488"
       "Vova", Some "+266137334"

    ] |> List.map (fun (name, value) -> TestCaseData(name, value))

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindNumber name value =
    findNumber (Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory()))) + "/check.txt") name [] |> should equal value

[<Test>]
let TestFindNumber2 =
    findNumber (Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory()))) + "/check.txt") "Blabla" [] |> should equal None

[<Test>]
let TestFindNumber3 =
    findNumber (Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory()))) + "/check.txt") "Blabla" ["Blabla"; "+67898"] |> should equal (Some "+67898")