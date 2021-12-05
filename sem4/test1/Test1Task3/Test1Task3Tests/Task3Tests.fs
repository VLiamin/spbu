module Test1Task3Tests

open Task3
open NUnit.Framework
open FsUnit
open System

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
let anotherCountCheckTest () =
    queue.Enqueue (3)
    queue.Enqueue (1)
    queue.Dequeue ()
    queue.Count |> should equal 1

[<Test>]
let exceptionTest () =
    
    (fun() -> queue.Dequeue () |> ignore) |> should throw typeof<InvalidOperationException>

[<Test>]
let anotherExceptionTest () =
    queue.Enqueue (3)
    queue.Enqueue (1)
    queue.Dequeue ()
    queue.Dequeue ()
    (fun() -> queue.Dequeue () |> ignore) |> should throw typeof<InvalidOperationException>


