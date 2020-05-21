module HtmlCount

open Foq
open FSharp.Data
open System.Text.RegularExpressions
open Request

/// Class for counting characters on pages
type HtmlProcessor (access: IHtmlRequest) =

    let redex = "^http:\/\/"

    let countSymbols (url: string) =
        async {
            let! loading = url |> access.AccessHtmlAsync |> Async.StartChild
            let! html = loading
            return url, html.Length
        }

    let findAddress (htmlText: string) =
        async {
            let address = 
                (HtmlDocument.Parse htmlText).Descendants ["a"] |>
                Seq.choose (fun t -> t.TryGetAttribute "href") |>
                Seq.map (fun v -> v.Value ()) |>
                Seq.filter (fun x -> Regex.IsMatch(x, redex))
            return address
        }
        
    /// Method for counting characters on pages
    member this.CountLinkedPagesSymbols (url: string) =

        async {            
            let! loading = url |> access.AccessHtmlAsync |> Async.StartChild
            let! mainHtml = loading
            let! links = mainHtml |> findAddress
            let! results = links |> Seq.map countSymbols |> Async.Parallel
            printfn "%A" results   
            return results
        }


let loaderMock = Mock<IHtmlRequest>().Setup(fun x -> <@ x.AccessHtmlAsync(any()) @>).Returns(async {
    return "<a href=\"http://yandex.ru/\" />" }).Create()

let processor = HtmlProcessor(loaderMock)
let result = Async.RunSynchronously(processor.CountLinkedPagesSymbols "yandex")