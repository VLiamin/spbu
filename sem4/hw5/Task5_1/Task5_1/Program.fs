module Task5_1
open System
open ComputerSystem
open Iteration

// Function that prints the virus in the system
let printComputerSystem (array : System[]) numberOfComputers = 
    let rec printInConsole count = 
        if (count = numberOfComputers) then
            ()
        else
            printfn "%b" (array.[count].Infected)
            printInConsole (count + 1)
    printInConsole 0

// Function that shows how the virus spreads through the system
let controlSystem = 
    let arrayOfRelation = array2D [[|0; 1; 0; 1|] 
                                   [|1; 0; 1; 0|] 
                                   [|0; 1; 0; 0|] 
                                   [|1; 0; 0; 0|]]

    let arrayOfComputers = [|System(true, (OperatingSystem.createOperatingSystem "Windows" 0.0)); 
                             System(false, (OperatingSystem.createOperatingSystem "Linux" 0.0));
                             System(false, (OperatingSystem.createOperatingSystem "Windows" 0.0)); 
                             System(false, (OperatingSystem.createOperatingSystem "Windows" 0.0))|]
    let rec iteration (arrayOfComputers : System[]) =
        printfn "Next iteration: 1\nExit: 0"
        let message = Console.ReadLine()
        if (message.Equals("0")) then
            ()
        else
            printComputerSystem arrayOfComputers 4
            iteration (iterate arrayOfComputers arrayOfRelation)
    iteration arrayOfComputers

