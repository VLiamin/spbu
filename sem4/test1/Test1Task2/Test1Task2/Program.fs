module Task2

// Function that prints a figure with asterisks
let print value = 
    let rec printForm number =
        if (number = value) then
            ()
        else
            let rec printAsterisk count = 
                if (count = value) then
                    ()
                elif (number = 0) || (number = value - 1) || (count = 0) || (count = value - 1) then
                    printf "*"
                    printAsterisk (count + 1)
                else
                    printf " "
                    printAsterisk (count + 1)
                 
            printAsterisk 0
            printfn ""
            printForm (number + 1)
    printForm 0
print 4
