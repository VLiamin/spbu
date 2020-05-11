module Task4_3

open System
open System.IO

/// Function that searches for a name by number
let findName path number list = 
    use file = new StreamReader(new FileStream(path, FileMode.Open))
    let rec findNumberInString text count list = 
        if (count = 1) then
            Some(text)
        elif (file.EndOfStream) then
            match list with
            | [] -> None
            | x :: t when x.Equals(number) -> Some(text)
            | x :: t -> findNumberInString x count t
        else 
            let string = file.ReadLine()
            if (string = number) then
                findNumberInString text 1 list
            else
                findNumberInString string count list

    findNumberInString "" 0 list

/// Function that searches for a number by name
let findNumber path name list = 
    use file = new StreamReader(new FileStream(path, FileMode.Open))
    let rec findNumberInString count number newList = 
        if (count = 1) then
            Some(number)
        elif (file.EndOfStream) then
            match newList with
            | [] -> None
            | x :: t when x.Equals(name) -> Some(t.Head)
            | x :: t -> findNumberInString count number t
        else 
            if (file.ReadLine() = name) then
                let phone = file.ReadLine()
                findNumberInString 1 phone newList
            else
                findNumberInString count number newList

    findNumberInString 0 "" list

/// Function which added name and number to a list
let addToList path list =
    (printf "Write name: ") 
    let name = Console.ReadLine()
    (printf "Write number: ")
    let number = Console.ReadLine()

    if (findName path number list = None) then
        name :: number :: list
    else
        list

/// Function that allows you to repeatedly record data
let add path list = 
    let rec addRecord path list = 
        printfn "Add : 1 \nExit: 0"
        match Console.ReadLine() with 
        | "1" -> addRecord path (addToList path list)
        | _ -> list

    addRecord path list

/// Function which save data to a file
let save list path = 
    use file = new StreamWriter(path, true)
    let lenght = List.length list
    let rec saveToFile list count = 
        if (count = lenght) then
            []
         else
             file.WriteLine(List.head list + "")
             saveToFile (List.tail list) (count + 1)

    saveToFile list 0

/// Function which read data from file
let readData path = 
    (File.ReadAllText(path))

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
    let text = ""
    let file = File.Open(path, FileMode.OpenOrCreate)
    file.Close()
    let rec fulfillUserRequests newList text = 
        printf "Your number: "
        match Console.ReadLine() with 
        | "2" -> fulfillUserRequests (add path newList) text
        | "3" -> printf "Write name: "
                 printfn "%A" (findNumber path (Console.ReadLine()) newList)
                 fulfillUserRequests newList text
        | "4" -> printf "Write number: "
                 printfn "%A" (findName path (Console.ReadLine())) 
                 fulfillUserRequests newList text
        | "5" -> printf "%s" (File.ReadAllText(path))
                 printList newList
                 printf "\n"
                 fulfillUserRequests newList text
        | "6" -> fulfillUserRequests (save newList path) text
        | "7" -> fulfillUserRequests newList (readData path)
        | _ -> file.Close ()

    fulfillUserRequests list text

doTelephoneDirectory ()


