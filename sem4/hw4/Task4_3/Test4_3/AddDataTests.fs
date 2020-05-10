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
    readData path |> 
    should equal "Masha\r\n883828\r\nKatya\r\n885828\r\nDasha\r\n886728\r\n"

[<Test>]
let TestSavedataManyTimes () =
    let list = ["Masha"; "883828"; "Katya"; "885828"; "Dasha"; "886728"]
    let path = Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory()))) + "/check2.txt"
    File.Delete(path);
    save (save (save list path) path) path
    readData path |> 
    should equal "Masha\r\n883828\r\nKatya\r\n885828\r\nDasha\r\n886728\r\n"