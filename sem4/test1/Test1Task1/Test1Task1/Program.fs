module Task1

let findMin list =
    let newList = List.sort list
    if (List.length newList > 0) then
        Some (List.head newList)
    else
        None
printfn "%A" (findMin [2])


