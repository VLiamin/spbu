module Task4_3

open System
open System.IO

/// Function that searches for a name by number
let findName number list = 

    let rec findNumberInString text list = 
        
        match list with
        | [] -> None
        | x :: t when x.Equals(number) -> Some(text)
        | x :: t -> findNumberInString x t

    findNumberInString "" list

/// Function that searches for a number by name
let findNumber name list = 

    let rec findNumberInString number newList = 

        match newList with
        | [] -> None
        | x :: t when x.Equals(name) -> Some(t.Head)
        | x :: t -> findNumberInString number t

    findNumberInString "" list

/// Function which added name and number to a list
let addToList list =
    (printf "Write name: ") 
    let name = Console.ReadLine()
    (printf "Write number: ")
    let number = Console.ReadLine()

    if (findName number list = None) then
        name :: number :: list
    else
        list

/// Function that allows you to repeatedly record data
let add path list = 
    let rec addRecord path list = 
        printfn "Add : 1 \nExit: 0"
        match Console.ReadLine() with 
        | "1" -> addRecord path (addToList list)
        | _ -> list

    addRecord path list

/// Function which save data to a file
let save list path = 
    use file = new StreamWriter(path, false)
    let length = List.length list
    let rec saveToFile list count = 
        if (count = length) then
            ()
         else
             file.WriteLine(List.head list + "")
             saveToFile (List.tail list) (count + 1)

    saveToFile list 0

/// Function which read data from file
let readData path =
    use file = new StreamReader(new FileStream(path, FileMode.Open))
    let rec fillTheList (list : List<string>) = 
        if (file.EndOfStream) then
            list
        else
           let text = file.ReadLine()
           fillTheList (text :: file.ReadLine() :: list)
    fillTheList []

/// Function which print the list 
let printList list = 
    let rec printListElements elements = 
        match elements with
        | [] -> ()
        | x :: t -> printfn "%s" x
                    printListElements t

    printListElements list

/// Function which implements telephone directory functions
let doTelephoneDirectory () = 
    printfn "Exit: 1\nAdd record (name and phone): 2\n%s\n%s\n%s"
        "Find phone by name: 3\nFind name by phone: 4"
        "Display all current contents of the database: 5"
        "Save current data to file: 6\nRead data from file: 7"
    let list = []
    let beginPath = Path.GetDirectoryName(Path.GetDirectoryName(Path.GetDirectoryName(Directory.GetCurrentDirectory())))
    let path = beginPath + "/database.txt"

    use file = File.Open(path, FileMode.OpenOrCreate)
    file.Close()
    let rec fulfillUserRequests newList = 
        printf "Your number: "
        match Console.ReadLine() with 
        | "2" -> if (list.IsEmpty) then
                     fulfillUserRequests (add path (readData path))
                 else
                     fulfillUserRequests (add path (readData path))
        | "3" -> printf "Write name: "
                 printfn "%A" (findNumber (Console.ReadLine()) newList)
                 fulfillUserRequests newList
        | "4" -> printf "Write number: "
                 printfn "%A" (findName (Console.ReadLine()) newList) 
                 fulfillUserRequests newList
        | "5" -> printList newList
                 printf "\n"
                 fulfillUserRequests newList
        | "6" -> (save newList path)
                 fulfillUserRequests newList
        | "7" -> fulfillUserRequests (readData path)
        | _ -> file.Close ()

    fulfillUserRequests list

doTelephoneDirectory ()
