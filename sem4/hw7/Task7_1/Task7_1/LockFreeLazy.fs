namespace Lazy

open System.Threading

type LockFreeLazy<'a> (supplier : unit -> 'a) =
    let mutable result = None

    interface ILazy<'a> with
        
        /// Launches calculation and returns the result
        member this.Get () =
            match result with
            | Some x -> x
            | None -> 
                      let value = supplier ()
                      Interlocked.CompareExchange(&result, Some value, None) |> ignore
                      result.Value

            