namespace Net

/// The type that describes the operating system
type OperatingSystem (Type: string, Probability: float) =

    /// Member that returns the type of computer OS
    member this.GetType = 
        Type

     /// Member that returns the probability of a computer being infected with a virus
     member this.GetProbability = 
         Probability

