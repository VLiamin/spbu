module MapForTree

// Type of the tree
type Tree<'a> =
| Node of 'a * Tree<'a> * Tree<'a>
| Empty

// Function that takes another to each element of the tree and returns a new
let rec mapTree f tree  = 
    match tree with
    | Empty -> Empty
    | Node(element, leftTree, rightTree) -> Node (f element, mapTree f leftTree, mapTree f rightTree)
