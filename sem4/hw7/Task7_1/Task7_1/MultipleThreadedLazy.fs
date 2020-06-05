namespace Lazy

open System

type MultipleThreadedLazy<'a> (supplier : unit -> 'a) =
    
    let mutable result = None
    let lockObject = new Object()

    interface ILazy<'a> with
    
            member this.Get () =
                match result with
                | None -> lock lockObject (fun () ->
                          match result with
                          | Some (x) -> x
                          | None -> result <- Some(supplier())
                                    result.Value)

                | Some (x) -> x