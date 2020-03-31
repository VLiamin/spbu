module Test5_1

open ComputerSystem
open Iteration
open NUnit.Framework
open FsUnit
let testCases = 
    [
        [|System(true, (OperatingSystem.createOperatingSystem "Windows" 1.0)); 
        System(false, (OperatingSystem.createOperatingSystem "Linux" 1.0));
        System(false, (OperatingSystem.createOperatingSystem "Windows" 1.0)); 
        System(false, (OperatingSystem.createOperatingSystem "Windows" 1.0))|], array2D [[|0; 1; 0; 1|]; 
                                                                                         [|1; 0; 1; 0|]; 
                                                                                         [|0; 1; 0; 0|]; 
                                                                                         [|1; 0; 0; 0|]], false
        [|System(true, (OperatingSystem.createOperatingSystem "Windows" 0.0)); 
        System(false, (OperatingSystem.createOperatingSystem "Linux" 0.0));
        System(false, (OperatingSystem.createOperatingSystem "Windows" 0.0)); 
        System(false, (OperatingSystem.createOperatingSystem "Windows" 0.0))|], array2D [[|0; 1; 0; 1|]; 
                                                                                         [|1; 0; 1; 0|];
                                                                                         [|0; 1; 0; 0|]; 
                                                                                         [|1; 0; 0; 0|]], true
    ] |> List.map (fun (computers, relation, isInfected) -> TestCaseData(computers, relation, isInfected))

[<Test>]
[<TestCaseSource("testCases")>]
let iterateTest1 (computers : System[]) relation isInfected =

    (iterate computers relation).[2].Infected |> should equal false


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
    (iterate computers relation).[2].Infected |> should equal isInfected