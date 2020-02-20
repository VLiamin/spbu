let countPowerOfTwo power numberOfFirstElement = 
    let rec fillInTheList list power numberOfFirstElement counter = 
        match counter with
        | _ when counter <= numberOfFirstElement -> fillInTheList (List.head list * 2 :: List.tail list) power numberOfFirstElement (counter + 1)
        | _ when counter <= power -> fillInTheList (List.head list * 2 :: list) power numberOfFirstElement (counter + 1) 
        | _ -> list

    fillInTheList [1] power numberOfFirstElement 1

let makeListOfPowersOfTwo n m = 
    let makeList listOfOurElements n m = 
        let rec makeReverse list acc = 
            match list with
            | [] -> acc
            | h :: t -> makeReverse t (h :: acc)

        let listOfPowersOfTwo = countPowerOfTwo (n + m) n
        makeReverse listOfPowersOfTwo listOfOurElements
    if m <= -1 || n < 0 then
        []
    else
        makeList [] n m
 
let list = makeListOfPowersOfTwo -1 5
printfn "Our list is: %A" list