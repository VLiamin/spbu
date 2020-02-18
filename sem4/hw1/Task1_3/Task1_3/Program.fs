let makeReverse list = 
    if List.length list = 0 then
        list
    else
        let rec doRecursion list newList = 
            if List.length list = 0 then
                newList
            else 
                doRecursion (List.tail list) (List.head list :: newList)
        
        doRecursion list []
        
printfn "New list: %A" (makeReverse [1; 2; 3; 7]) 