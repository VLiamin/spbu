module Task2Tests
open Task2
open NUnit.Framework
open FsUnit

[<Test>]
let findMaxValueTest () =
    find () |> should equal 906609