module task4_2
// Function given by condition
let func x l = List.map (fun y -> y * x) l

// Removed the list variable
let func'1 x: (int) list -> (int) list = 
    List.map(fun y -> x * y)

// Moved the list item variable to the right 
let func'2 x: (int) list -> (int) list =
    List.map (fun y -> (*) x y)

// Removed the list item variable
let func'3 x: (int) list -> (int) list = 
    List.map((*) x)
