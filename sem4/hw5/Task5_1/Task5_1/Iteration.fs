module Iteration
open ComputerSystem
open System
// Function that allows iteration several times 
let prepareForIteration (arrayOfComputers : System[]) = 
    let rec iterateArray (arrayOfComputers : System[]) count = 
        if (count = arrayOfComputers.Length) then
            arrayOfComputers
        else
            arrayOfComputers.[count].InfectedOnThisType <- false
            iterateArray arrayOfComputers (count + 1)
    iterateArray arrayOfComputers 0

// Function models the behavior of the virus on the network
let iterate (arrayOfComputers : System[]) (arrayOfRelation : int[,]) =
    let rec infectComputers count (arrayOfComputersInSystem : System[])  = 
        if (count = arrayOfComputers.Length) then
            arrayOfComputersInSystem 
        elif (arrayOfComputers.[count].Infected = false) || (arrayOfComputers.[count].InfectedOnThisType = true) then
            infectComputers (count + 1) arrayOfComputersInSystem
        else
            let rec iterateSystem (array : System[]) numberOfComputer = 
                let rndGen = new Random(int DateTime.Now.Ticks)
                if (array.Length = numberOfComputer) then
                    array
                elif (array.[numberOfComputer].Infected = false) && (array.[numberOfComputer].GetProbability < (rndGen.NextDouble())) &&
                     (arrayOfRelation.[numberOfComputer, count] = 1) then
                    array.[numberOfComputer].Infected <- true
                    array.[numberOfComputer].InfectedOnThisType <- true
                    iterateSystem array (numberOfComputer + 1)
                else
                    iterateSystem array (numberOfComputer + 1)    
            infectComputers (count + 1) (iterateSystem arrayOfComputersInSystem 0)
    infectComputers 0 (prepareForIteration arrayOfComputers)