module CountEvenNumbersWithMap

let countEvenNumbersWithMap list =
    let newList = List.sort (List.map (fun x -> x % 2 * x) list)
    let isNotZero x = x > 0

    match List.tryFindIndex isNotZero newList with
    | Some value -> value
    | None -> List.length newList
