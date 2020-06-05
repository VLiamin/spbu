namespace Lazy

type LazyFactory<'a> =
    
    static member CreateSingleThreadedLazy supplier =
        new Lazy<'a>(supplier) :> ILazy<'a>

    static member CreateMultipleThreadedLazy supplier =
        new MultipleThreadedLazy<'a>(supplier) :> ILazy<'a>

    static member CreateLockFreeLazy supplier =
        new LockFreeLazy<'a>(supplier) :> ILazy<'a>