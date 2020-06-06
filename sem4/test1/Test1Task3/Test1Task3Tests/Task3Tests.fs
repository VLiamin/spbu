module Test1Task3Tests

open Task3
open NUnit.Framework
open FsUnit


let mutable queue = new Queue<int>()

[<SetUp>]
let initialize () =
    queue <- new Queue<int>()

[<Test>]
let countCheck () =
    queue.Count |> should equal 0


[<Test>]
let dequeueTest () =
    queue.Enqueue(0)
    queue.Enqueue(1)
    queue.Dequeue() |> should equal 0

[<Test>]
let countTest2 () =
    queue.Enqueue(3)
    queue.Enqueue(1)
    queue.Dequeue ()
    queue.Count |> should equal 1
