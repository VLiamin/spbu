let countFibonacci number = 

    let rec findFibonacci counter n1 n2 = 
        if counter >= number then
            n1
        else
            findFibonacci (counter + 1) (n1 + n2) n1

    match number with
    |_ when number < 0 -> None
    | 1 -> Some (1)
    | 0 -> Some (0)
    | _ -> Some (findFibonacci 2 1 1)

    
    


printfn "Value : %A" (countFibonacci 3)