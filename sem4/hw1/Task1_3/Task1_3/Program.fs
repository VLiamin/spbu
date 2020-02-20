let makeReverse list = 
    if List.length list = 0 then
        list
    else
        let rec makeReverseTheList list newList = 
            match list with
            | [] -> newList
            | h :: t -> makeReverseTheList t (h :: newList)
        
        makeReverseTheList list []
        
printfn "New list: %A" (makeReverse [1; 2; 8]) 