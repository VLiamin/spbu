module Number
open System.IO
open System
let findNumber path name = 
    let file = new StreamReader(new FileStream(path, FileMode.Open))
    let rec findNumberInString count number = 
        if (count = 1) then
            file.Close()
            Some(number)
        elif (file.EndOfStream) then
            printfn "This number not exists"
            file.Close()
            None
        else 
            if (file.ReadLine() = name) then
                let phone = file.ReadLine()
                printfn "Your number is: %s" phone
                findNumberInString 1 phone
            else
                findNumberInString count number
    findNumberInString 0 ""

