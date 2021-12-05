module Task3_3Tests

open NUnit.Framework
open Task3_3
open FsUnit

[<Test>]
let simpleInterpreterTest () =
    let expression = (Expression(Function('a', Element('a')), Element('b')))

    makeBetaReduction expression |> should equal (Element('b'))

[<Test>]
let singleVariableTest () =
    makeBetaReduction (Element('a')) |> should equal (Element('a'))

[<Test>]
let normalFormTest () =
    let expression = Function ('x', Expression (Function ('y', Element ('y')), Element('x')))
    let result = Function ('x', Element ('x'))

    makeBetaReduction expression |> should equal result