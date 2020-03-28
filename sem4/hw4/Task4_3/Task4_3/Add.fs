module Add
open System
// Function which added name and number to a list
let add list = 
    let rec addRecord list = 
        printfn "Add : 1 \nExit: 0"
        match Console.ReadLine() with 
        | "1" -> (printf "Write name: ") 
                 let name = Console.ReadLine()
                 (printf "Write number: ")
                 addRecord (name :: Console.ReadLine() :: list)
        | _ -> list
    addRecord list
