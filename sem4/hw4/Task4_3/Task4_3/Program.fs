module Task4_3

open System
open System.IO
open AddElement

/// Function that searches for a name by number
let findName path name = 
    use file = new StreamReader(new FileStream(path, FileMode.Open))
    let rec findNumberInString text count = 
        if (count = 1) then
            Some(text)
        elif (file.EndOfStream) then
            printfn "This name not exists"
            None
        else 
            let string = file.ReadLine()
            if (string = name) then
                printfn "Your name is: %s" text
                findNumberInString text 1
            else
                findNumberInString string count
    findNumberInString "" 0

/// Function that searches for a number by name
let findNumber path name = 
    use file = new StreamReader(new FileStream(path, FileMode.Open))
    let rec findNumberInString count number = 
        if (count = 1) then
            Some(number)
        elif (file.EndOfStream) then
            printfn "This number not exists"
            None
        else 
            if (file.ReadLine() = name) then
                let phone = file.ReadLine()
                printfn "Your number is: %s" phone
                findNumberInString 1 phone
            else
                findNumberInString count number
    findNumberInString 0 ""

/// Function which save data to a file
let save list path = 
    use file = new StreamWriter(path, true)
    let lenght = List.length list
    let rec saveToFile list count = 
        if (count = lenght) then
            ()
         else
             file.WriteLine(List.head list + "")
             saveToFile (List.tail list) (count + 1)
    saveToFile list 0

/// Function which implements telephone directory functions
let doTelephoneDirectory = 
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


