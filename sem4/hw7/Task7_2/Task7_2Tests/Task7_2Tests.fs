module HtmlCount.Tests

open NUnit.Framework
open FsUnit
open Foq
open Request

[<Test>]
let notCorrectAddressTest () =
    let mock = Mock<IHtmlRequest>().Setup(fun x -> <@ x.AccessHtmlAsync(any()) @>).Returns(async {
        return "<a efds=\"gdty\" />" }).Create()
    let processor = HtmlProcessor(mock)
    let result = Async.RunSynchronously(processor.CountLinkedPagesSymbols "gdty")
    result.Length |> should equal 0

[<Test>]
let singleAddressTest () =
    let mock = Mock<IHtmlRequest>().Setup(fun x -> <@ x.AccessHtmlAsync(any()) @>).Returns(async {
        return "<a href=\"http://yandex.ru/\" />" }).Create()
    let processor = HtmlProcessor(mock)
    let result = Async.RunSynchronously(processor.CountLinkedPagesSymbols "yandex")
    result.Length |> should equal 1
    result |> should contain ("http://yandex.ru/", 30)

[<Test>]
let multipleAddressTest () =

    let page2 = async { return "12" }
    let page3 = async { return "123" }
    let page4 = async { return "1234" }

    let html = "<a href=\"http://second.ru/\" />
        <a href=\"http://third.ru/\" />
        <a href=\"http://fourth.ru/\" />"

    let mainPage = async { return html }

    let mock =
        Mock<IHtmlRequest>()
            .Setup(fun x -> <@ x.AccessHtmlAsync("main") @>).Returns(mainPage)
            .Setup(fun x -> <@ x.AccessHtmlAsync("http://second.ru/") @>).Returns(page2)
            .Setup(fun x -> <@ x.AccessHtmlAsync("http://third.ru/") @>).Returns(page3)
            .Setup(fun x -> <@ x.AccessHtmlAsync("http://fourth.ru/") @>).Returns(page4)
            .Create()
    let processor = HtmlProcessor(mock)
    let result = Async.RunSynchronously(processor.CountLinkedPagesSymbols "main")
    result.Length |> should equal 3
    result |> should contain ("http://second.ru/", 2)
    result |> should contain ("http://third.ru/", 3)
    result |> should contain ("http://fourth.ru/", 4)