module AddDataTests

open Task4_3
open NUnit.Framework
open FsUnit
open System.IO

[<Test>]
let TestSavedata () =
    let list = ["Masha"; "883828"; "Katya"; "885828"; "Dasha"; "886728"]
    let path = Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory()))) + "/check2.txt"
    File.Delete(path);
    save list path
    (readData path).Replace("\r\n", " ").Replace('\n', ' ').Trim(' ') |> should equal "Masha 883828 Katya 885828 Dasha 886728"

[<Test>]
let TestSavedataManyTimes () =
    let list = ["Masha"; "883828"; "Katya"; "885828"; "Dasha"; "886728"]
    let path = Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory()))) + "/check2.txt"
    File.Delete(path);
    let newList = []
    save (save (save list path) path) path
    (readData path).Replace("\r\n", " ").Replace('\n', ' ').Trim(' ') |> should equal "Masha 883828 Katya 885828 Dasha 886728"