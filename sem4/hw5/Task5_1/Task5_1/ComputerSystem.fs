namespace Net

/// A type that describes a computer system
type System (value: bool, typeOfSystem: OperatingSystem) = 

    /// Member who is responsible for infecting the computer
    member val Infected = value with get, set

    /// Member who is responsible for infecting the computer at the last iteration
    member val InfectedOnThisStep = false with get, set

    /// Member that returns the probability of a computer being infected with a virus
    member this.GetProbability =
        typeOfSystem.GetProbability

    /// Member that returns the type of computer OS
    member this.GetTypeOfSystem =
        typeOfSystem.GetType