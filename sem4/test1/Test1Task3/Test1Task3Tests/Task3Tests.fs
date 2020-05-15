module Test1Task3Tests

open Task3
open NUnit.Framework
open FsUnit


let mutable queue = new PriorityQueue<int>()

[<SetUp>]
let ``Initialize`` () =
    queue <- new PriorityQueue<int>()

[<Test>]
let ``Count of empty queue should be zero`` () =
    queue.Count |> should equal 0


[<Test>]
let ``Count after multiple enqueue should be correct`` () =
    queue.Enqueue 0 0
    queue.Enqueue 1 2
    queue.Count |> should equal 2

[<Test>]
let ``Count after enqueue and dequeue should be zero`` () =
    queue.Enqueue 1 2
    queue.Dequeue () |> ignore
    queue.Count |> should equal 0

[<Test>]
let ``Enqueue with priority should work properly`` () =
    queue.Enqueue 5 0
    queue.Enqueue 2 0
    queue.Enqueue 3 1
    queue.Dequeue () |> should equal 3