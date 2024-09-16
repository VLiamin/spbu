namespace Net

open System

/// Class that is responsible for iterating over a computer system
type IterationCompeterSystem (arrayOfComputers : System[], arrayOfRelation : int[,], rndGen : Random) =

    let prepareForIteration (arrayOfComputers : System[]) = 

        for i in 0..(arrayOfComputers.Length - 1) do 
            arrayOfComputers.[i].InfectedOnThisStep <- false

    /// Function models the behavior of the virus on the network
    member this.Iterate =

        prepareForIteration arrayOfComputers

        for count in 0..(arrayOfComputers.Length - 1) do

            if (not arrayOfComputers.[count].Infected) || (arrayOfComputers.[count].InfectedOnThisStep) then
                ()
            else
                for numberOfComputer in 0..(arrayOfComputers.Length - 1) do
                    
                    if (not arrayOfComputers.[numberOfComputer].Infected) && (arrayOfComputers.[numberOfComputer].GetProbability < (rndGen.NextDouble())) &&
                         (arrayOfRelation.[numberOfComputer, count] = 1) then
                        arrayOfComputers.[numberOfComputer].Infected <- true
                        arrayOfComputers.[numberOfComputer].InfectedOnThisStep <- true

        arrayOfComputers
