module Preservation
open System.IO
// Function which save data to a file
let save list path = 
    let file = new StreamWriter(path, true)
    let lenght = List.length list
    let rec saveToFile list count = 
        if (count = lenght) then
            file.Close()
            ()
         else
             file.WriteLine(List.head list + "")
             saveToFile (List.tail list) (count + 1)
    saveToFile list 0

