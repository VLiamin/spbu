module Task1

let count () = 
    let rec countFibonacci firstNumber secondNumber amount = 
        if (firstNumber > 1000000)  then
            amount
        else 
            countFibonacci (firstNumber + secondNumber) firstNumber (amount + firstNumber)
    countFibonacci 1 1 1
printf "%d" (count ())
