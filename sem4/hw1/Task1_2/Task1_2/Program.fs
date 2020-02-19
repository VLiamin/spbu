let countFibonacci number = 
    if number < 0 then
        printfn "Incorrect data"
        None
    else
        if (number = 1) || (number = 0) then
            Some (number)
        else
            let rec doRecursion counter n1 n2 = 
                if counter >= number then
                    n1
                else
                    doRecursion (counter + 1) (n1 + n2) n1

            Some (doRecursion 2 1 1)

printfn "Value : %A" (countFibonacci 5)