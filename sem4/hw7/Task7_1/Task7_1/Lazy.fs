namespace Lazy

type Lazy<'a> (supplier : unit -> 'a) =
    
    let mutable result = None

    interface ILazy<'a> with

        member this.Get () =
            match result with
            | Some (x) -> x
            | None -> result <- Some (supplier())
                      result.Value