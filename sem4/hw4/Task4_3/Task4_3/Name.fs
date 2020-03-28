module Name
open System.IO

// Function that searches for a name by number
let findName path name = 
    let file = new StreamReader(new FileStream(path, FileMode.Open))
    let rec findNumberInString text count = 
        if (count = 1) then
            file.Close()
            Some(text)
        elif (file.EndOfStream) then
            printfn "This name not exists"
            file.Close()
            None
        else 
            let string = file.ReadLine()
            if (string = name) then
                printfn "Your name is: %s" text
                findNumberInString string 1
            else
                findNumberInString string count
    findNumberInString "" 0
