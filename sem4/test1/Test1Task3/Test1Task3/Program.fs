module Task3



/// Class is not a priority queue
type Queue<'a> () =

    /// List of values
    let mutable elements = []

    /// Method which add element in the queue
    member this.Enqueue (value : 'a) =
        elements <- elements @ [value]

     /// Method which remove element from the queue
     member this.Dequeue () =
        match elements with
        | [] -> invalidOp "The queue is empty"
        | x :: t -> elements <- t
                    x

    /// Method which get the size of the queue
    member this.Count = elements.Length