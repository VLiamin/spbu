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

let dataBase = ["Katya"; "+728271828"; "Misha"; "+643737488"; "Vova"; "+266137334"]

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindNumber name value =
    findNumber name dataBase |> should equal value

[<Test>]
let TestFindNumber2 =
    findNumber "Blabla" dataBase |> should equal None

[<Test>]
let TestFindNumber3 =
    findNumber "Blabla" ["Katya"; "+728271828"; "Blabla"; "+67898"; "Misha"; "+643737488"; "Vova"; "+266137334"] |> should equal (Some "+67898")