module OperatingSystem

    // The type that describes the operating system
    type OperatingSystem = {Type: string; Probability: float} with
        member this.GetType = 
            this.Type
        member this.GetProbability = 
            this.Probability
    let createOperatingSystem typeOfSystem probability =
        {Type = typeOfSystem; Probability = probability}
