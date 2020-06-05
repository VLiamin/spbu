module AddDataTests

open Task4_3
open NUnit.Framework
open FsUnit
open System.IO

let array1 = ["Vova"; "+266137334"; "Misha"; "+643737488"; "Katya"; "+728271828";]
let array2 = ["Katya"; "+728271828"; "Misha"; "+643737488"; "Vova"; "+266137334";]
let path = Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory()))) + "/check.txt"
[<Test>]
let TestSaveData () =
    ((readData path).Equals(array1) || (readData path).Equals(array2)) |> should equal true

[<Test>]
let TestSavedataManyTimes () =
    save (readData path) path
    ((readData path).Equals(array1) || (readData path).Equals(array2)) |> should equal true