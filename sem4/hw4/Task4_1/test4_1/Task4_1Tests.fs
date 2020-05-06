module Tests4_1

open NUnit.Framework
open FsUnit
open Task4_1

let testCases = 
    [
        "(1 + 2) *3", true
        "(1 - 7 * 8", false
        "I can (run}", false
        "[5 = 9]", true
        "((())fjjfjf)", true
        "[[jfjj]]]()", false
        "[(djdjj]kkf)", false
        "[(])", false
        "()[]{}", true
        "(djdjdj){dmmdm[dkd}djdk]", false
    ] |> List.map (fun (line, isCorrect) -> TestCaseData(line, isCorrect))

[<Test>]
[<TestCaseSource("testCases")>]
let checkParentheses line isCorrect =
    checkParentheses line |> should equal isCorrect