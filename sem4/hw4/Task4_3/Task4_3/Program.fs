module Task4_3
open System
open System.IO
open Add
open Preservation
open Number
open Name


let doTelephoneDirectory = 
    printfn "Exit: 1\nAdd record (name and phone): 2\n%s\n%s\n%s"
        "Find phone by name: 3\nFind name by phone: 4"
        "Display all current contents of the database: 5"
        "Save current data to file: 6\nRead data from file: 7"
    let list = []
    let path = "database.txt"
    let text = ""
    let file = File.Open(path, FileMode.OpenOrCreate)
    file.Close()
    let rec fulfillUserRequests newList text = 
        printf "Your number: "
        match Console.ReadLine() with 
        | "2" -> fulfillUserRequests (add newList) text
        | "3" -> printf "Write name: "
                 findNumber path (Console.ReadLine())
                 fulfillUserRequests newList text
        | "4" -> printf "Write number: "
                 findName path (Console.ReadLine())
                 fulfillUserRequests newList text
        | "5" -> printfn "%s" (File.ReadAllText(path))
                 fulfillUserRequests newList text
        | "6" -> save newList path
                 fulfillUserRequests newList text
        | "7" -> fulfillUserRequests newList (File.ReadAllText(path))
        | _ -> file.Close ()
    fulfillUserRequests list text
doTelephoneDirectory
