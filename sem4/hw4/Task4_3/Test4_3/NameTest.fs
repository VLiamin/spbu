module NameTest

open Task4_3
open NUnit.Framework
open FsUnit
open System.IO

let testCases = 
    [
       Some "Katya", "+728271828"
       Some "Misha", "+643737488"
       Some "Vova", "+266137334"

    ] |> List.map (fun (name, value) -> TestCaseData(name, value))

let dataBase = ["Katya"; "+728271828"; "Misha"; "+643737488"; "Vova"; "+266137334"]

[<Test>]
[<TestCaseSource("testCases")>]
let TestFindName name value =
    findName value dataBase |> should equal name

[<Test>]
let TestFindName2 =
    findName "+38272727" dataBase |> should equal None

[<Test>]
let TestFindName3 =
    findName "654" ["Blabla"; "654"] |> should equal (Some "Blabla")