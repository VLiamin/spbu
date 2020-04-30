module AddElement

open System

/// Function which added name and number to a list
let addToList list =
    (printf "Write name: ") 
    let name = Console.ReadLine()
    (printf "Write number: ")
    name :: Console.ReadLine() :: list

/// Function that allows you to repeatedly record data
let add list = 
    let rec addRecord list = 
        printfn "Add : 1 \nExit: 0"
        match Console.ReadLine() with 
        | "1" -> addRecord (addToList list)
        | _ -> list
    addRecord list