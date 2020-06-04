module Request

open System.Net
open System.IO

/// Interface for accessing html pages
type IHtmlRequest =

    /// Method that accesses html pages
    abstract member AccessHtmlAsync : url: string -> string Async

/// Class for accessing html pages
type HtmlRequest () =

    interface IHtmlRequest with

    /// Method that accesses html pages
        member this.AccessHtmlAsync url =
            async {
                let request = WebRequest.Create url
                use! response = request.AsyncGetResponse()
                use stream = response.GetResponseStream()
                use reader = new StreamReader(stream)
                return! Async.AwaitTask <| reader.ReadToEndAsync()
            }