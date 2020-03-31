module ComputerSystem
open OperatingSystem

    // A type that describes a computer system
    type System(value: bool, typeOfSystem: OperatingSystem) = 
        member val Infected = value with get, set
        member private this.Type = typeOfSystem
        member val InfectedOnThisType = false with get, set
        member this.GetProbability =
            this.Type.GetProbability
        member this.GetTypeOfSystem =
            this.Type