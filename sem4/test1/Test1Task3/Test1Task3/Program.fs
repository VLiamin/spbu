module Task3

open Microsoft.FSharp.Core

/// Priority queue structure
type PriorityQueue<'a> () =

    /// List of pairs
    let mutable listOfElements = []

    /// Dequeues item with the highest priority
    member this.Dequeue () =
        match listOfElements with
        | [] ->
            invalidOp("Can't dequeue")
        | h :: t ->
            listOfElements <- t
            fst h

     /// Enqueues item with priority
     member this.Enqueue value priority =
        let rec insertInTheQueue before after =
            match after with
            | [] ->
                [(value, priority)]
            | (x, y) :: t ->
                if y < priority then
                    before @ [(value, priority)] @ after
                else
                    insertInTheQueue (before @ [(x, y)]) t
        listOfElements <- insertInTheQueue [] listOfElements

    member this.Count = listOfElements.Length