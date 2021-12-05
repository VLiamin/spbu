namespace Lazy

module Task7_1Tests =

    open NUnit.Framework
    open FsUnit
    open System.Threading

    [<Test>]
    let singleThreadTest () =
        let result = LazyFactory.CreateSingleThreadedLazy(fun () -> 1)
        result.Get () |> should equal 1

    [<Test>]
    let singleThreadTest2 () =
        let result = LazyFactory.CreateSingleThreadedLazy(fun () -> 5)
        result.Get () |> should equal 5
        result.Get() |> should equal 5

    [<Test>]
    let lockFreeTest () =
        let lazyObject = LazyFactory.CreateLockFreeLazy(fun () -> new System.Object())
        
        let expected = lazyObject.Get ()
        for i in 1..100 do
            ThreadPool.QueueUserWorkItem (fun obj -> 
            expected |> (lazyObject.Get ()).Equals |> should be True) |> ignore

    [<Test>]
    let multipleThreadTest () =
        let mutable result = 0
        let lazyObject = LazyFactory<int>.CreateMultipleThreadedLazy(fun unit -> Interlocked.Increment(ref result))
        for i in 1 .. 1000 do
            lazyObject.Get() |> should equal 1

