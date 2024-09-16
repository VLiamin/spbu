module Test5_1

open Net
open NUnit.Framework
open FsUnit
open System

let testCases = 
    [
        [|System(true, (Net.OperatingSystem("Windows", 1.0))); 
        System(false, (Net.OperatingSystem("Linux", 1.0)));
        System(false, (Net.OperatingSystem("Windows", 1.0))); 
        System(false, (Net.OperatingSystem("Windows", 1.0)))|], array2D [[|0; 1; 0; 1|]; 
                                                                                         [|1; 0; 1; 0|]; 
                                                                                         [|0; 1; 0; 0|]; 
                                                                                         [|1; 0; 0; 0|]], false
        [|System(true, (Net.OperatingSystem("Windows", 0.0))); 
        System(false, (Net.OperatingSystem("Linux", 0.0)));
        System(false, (Net.OperatingSystem("Windows", 0.0))); 
        System(false, (Net.OperatingSystem("Windows", 0.0)))|], array2D [[|0; 1; 0; 1|]; 
                                                                                         [|1; 0; 1; 0|];
                                                                                         [|0; 1; 0; 0|]; 
                                                                                         [|1; 0; 0; 0|]], true
    ] |> List.map (fun (computers, relation, isInfected) -> TestCaseData(computers, relation, isInfected))

[<Test>]
[<TestCaseSource("testCases")>]
let iterateTest1 (computers : System[]) relation isInfected =

    (IterationCompeterSystem(computers, relation, new Random(int DateTime.Now.Ticks)).Iterate).[2].Infected |> should equal false


[<Test>]
[<TestCaseSource("testCases")>]
let iterateTest2 (computers : System[]) relation isInfected =

    computers.[1].Infected |> should equal isInfected


[<Test>]
[<TestCaseSource("testCases")>]
let iterateTest3 (computers : System[]) relation isInfected =

    computers.[3].Infected |> should equal isInfected


[<Test>]
[<TestCaseSource("testCases")>]
let iterateTest4 computers relation isInfected =
    (IterationCompeterSystem(computers, relation, new Random(int DateTime.Now.Ticks)).Iterate).[2].Infected |> should equal isInfected