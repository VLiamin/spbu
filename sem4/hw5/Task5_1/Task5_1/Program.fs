module Task5_1

open Net
open System

/// Function that prints the virus in the system
let printComputerSystem (array : System[]) numberOfComputers = 

    for count in 0..(numberOfComputers - 1) do
         printfn "%b" (array.[count].Infected)

/// Function that shows how the virus spreads through the system
let controlSystem = 
    
    let arrayOfRelation = array2D [[|0; 1; 0; 1|] 
                                   [|1; 0; 1; 0|] 
                                   [|0; 1; 0; 0|] 
                                   [|1; 0; 0; 0|]]

    let arrayOfComputers = [|System(true, (Net.OperatingSystem("Windows", 0.0))); 
                             System(false, (Net.OperatingSystem("Linux", 0.0)));
                             System(false, (Net.OperatingSystem("Windows", 0.0))); 
                             System(false, (Net.OperatingSystem("Windows", 0.0)))|]
    let v = IterationCompeterSystem (arrayOfComputers, arrayOfRelation, new Random(int DateTime.Now.Ticks))
    printfn "Next iteration: 1\nExit: 0"
    while  (Console.ReadLine().Equals("1")) do

        printComputerSystem arrayOfComputers 4
        v.Iterate
        printfn "Next iteration: 1\nExit: 0"

