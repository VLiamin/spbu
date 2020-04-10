module Task1

let findMinValue firstValue secondValue =
    if (firstValue < secondValue) then
        firstValue
    else
        secondValue

let findMin list =
    if (List.length list = 0) then
        None
    else
        Some (List.fold (fun acc x -> findMinValue acc x ) (List.head list) list)
printfn "%A" (findMin [2; 4; -2; 0])


